package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;


public class jsonparsingresponse {
	
	@Test
	void test_jsonResponse()
	{
		// approach 1
		
		 /*given()
		    .contentType("application/json; charset=utf-8")	
	    .when()
	    	.get("https://reqres.in/api/unknown")
	    .then()
	    	.statusCode(200)
	    	.header("Content-Type","application/json; charset=utf-8")
	    	.body("data[5].name", is("blue turquoise")); */	    
		
		//approach 2
		Response res = 
		given()
			//.contentType("application/json; charset=utf-8")
		.when()
			.get("https://reqres.in/api/unknown");
		
		//Assert.assertEquals(res.getStatusCode(),200);
		//Assert.assertEquals(res.getHeader("Content-Type"),"application/json; charset=utf-8");
		//Assert.assertEquals(res.jsonPath().get("data[5].name").toString(),"blue turquoise");
		
		//JSON Object class
		String responseBody = res.getBody().asString();
		
           JSONObject obj = new JSONObject(responseBody);// converting response to jsonobject
           JSONArray aaaa = obj.getJSONArray("data");
            System.out.println("First value " +aaaa.getJSONObject(0));
            for (int i = 0; i < aaaa.length(); i++) {
                String aa = aaaa.getJSONObject(i).get("year").toString();
                System.out.println("Print array: " + aa);
            }
            
		
	}
	@Test(priority = 2)
	void testisapa() {
		Response a = given()
		.when()
			.get("https://reqres.in/api/unknown");

		String bb = a.getBody().asString();
		
		JSONObject oj = new JSONObject(bb);
        // Get the "data" array from the JSON response
        JSONArray dataArray = oj.getJSONArray("data");

        // Iterate over the elements of the "data" array using forEach
        dataArray.forEach(aaax -> {
            JSONObject dataObject = (JSONObject) aaax;
            String year = dataObject.get("year").toString();

            System.out.println("Name: " + year);

        });
       

	}
}
