package day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.json.JSONObject;

public class parsingxml_response {
	@Test
      public void testxml() 
	  {
    	  //approach 1
		/*
		 given()
		 .when()
		 	.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		 .then()
		 	.statusCode(200)
		 	.header("Content-Type", "application/xml; charset=utf-8")
		 	.body("TravelerinformationResponse.page", is("1"))
		 	.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", is("Developer"));
		 	*/
    	  // approach 2
		 
		Response a= given()
		 .when()
		 .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		 
          Assert.assertEquals(a.getStatusCode(), 200);
          Assert.assertEquals(a.getHeader("Content-Type"), "application/xml; charset=utf-8");
          String bb = a.xmlPath().getString("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
          Assert.assertEquals(bb, "Developer");
          printbody(bb);
      }
	@Test(priority = 1)
	void getbody() {
		Response a= given()
				 .when()
				 .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		String resbody = a.getBody().asString();
		String bac = a.xmlPath().get("Travelerinformation.travelers.Travelerinformation[0].name").toString();
		
		printbody(bac);
		
		
	}
	@Test(priority = 2)
	void testxmlresponse() {
		Response a= given()
				 .when()
				 .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		          
		          XmlPath xmobj = new XmlPath(a.asString());
		         List<String> i=  xmobj.getList("Travelerinformation.travelers.Travelerinformation");
		         Assert.assertEquals(i.size(), 10);
		         System.out.println("Travel infomations" + i);
		         
		         //verify traveler name
		         List<String> io=  xmobj.getList("Travelerinformation.travelers.Travelerinformation.name");
		         for(String travelname : io) {
		        	 if(travelname.equals("Developer")) {
		        		 System.out.println("Travel name" + travelname);
		        	 };
		         }
	}
	void printbody(String aa) {
		System.out.print("Travel info: " + aa + "\n");
	}
}
