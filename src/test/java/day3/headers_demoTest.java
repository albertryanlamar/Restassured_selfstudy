package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class headers_demoTest {
	
	@Test
	void demo_headerTest() {
		
		given()
		// cookies, authentication, parameters, content,body request
		.when()
		// all request type, ex: Get request, Post, delete, update request
			.get("https://www.google.com/")
		.then()
		// validation
		    .statusCode(200)
		    // validation of every header
			.header("Content-Type","text/html; charset=ISO-8859-1")
		    .header("Cache-Control","private, max-age=0")
		    .log().all();
			// other way to validate
			//.header("Content-Type",equalTo ("text/html; charset=ISO-8859-1"))
			
		   // get the whole headers
		   // System.out.println("All Headers: " + a.getHeaders());
		
		
	}


}
