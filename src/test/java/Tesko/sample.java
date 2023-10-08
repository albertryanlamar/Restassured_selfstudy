package Tesko;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class sample {
	String aac;
	public String aa;
	@Test(priority =1)
  public void setautho() {
	  
	  Response a = given()
			  .cookie("__cf_bm=I5U8KJA9GciuoDtQVXmUOFgBs4muY9LWoHNOzFUsF1Q-1692149731-0-AWOIzDPKlbF0HyFtTkYExmVee5uzLRxdX/dKcFY2OBCfRA0N94NY3UCbY4uZ3n2ObthDF3b7+CnmlN6RL2cVWS4=")
			  .header("Authorization","Basic NnUwbWZtcXRtZTdiZXV1a20xMTAyMTlhbDU6ZzRoMmppbGwzdGkwaXVxZnJuY29mcTFpNmU5OTJiMWczbGpsa2QyMmNmdGtrNmVkb2c0")   
	    .when()
	    .post("https://test-cxs.globe.com.ph/v1/channels/oauth/token");
	 String aac= a.then()
		.extract()
		.jsonPath().get("result.accessToken").toString();
	  //String getto = a.jsonPath().get("result.accessToken").toString();
	 System.out.println("Result: \n" + aac);
	 
	 String aa="aaaaa";
  }
	@Test(priority = 2, dependsOnMethods = "setautho", alwaysRun = true)
	void sendotp() {
		
		  //String auth = aac;
		  File f = new File(".\\sentotp.json");
          FileReader fr;
          System.out.println("Sample:"+aa);
          System.out.println("Token header:"+aac);
         
		try {
			fr = new FileReader(f);
			JSONTokener tk = new JSONTokener(fr);
			JSONObject ob = new JSONObject(tk);
			
			
	         given()
			 	.header("Content-Type","application/json")
			 	.cookie("__cf_bm=I5U8KJA9GciuoDtQVXmUOFgBs4muY9LWoHNOzFUsF1Q-1692149731-0-AWOIzDPKlbF0HyFtTkYExmVee5uzLRxdX/dKcFY2OBCfRA0N94NY3UCbY4uZ3n2ObthDF3b7+CnmlN6RL2cVWS4=")
			 	.header("Authorization",aac)
			 	.body(ob.toString())
			 	
			.when()
				.post("https://test-cxs.globe.com.ph/v1/subscriber/otp")
	         .then()
	         	.statusCode(401)
	         	.log().all();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		 

	}

}
