package day7;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Authentication {
//Basic Authentication	
	@Test
	void testBasicAuthentication() {
		
		 given()
		 	.auth()
		 	//.basic("postman", "password")
		 	.basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200);	
	}
	
	@Test
	void testDigestAuthentication() {
		
		 given()
		 	.auth()
		 	//.basic("postman", "password")
		 	.digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200);	
	}
//Preemptive authentication	
	@Test
	void testPreemptiveAuthentication() {
		
		 given()
		 	.auth()
		 	//.basic("postman", "password")
		 	.preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200);	
	}
	//bearer token
	@Test
	void testBearerTokenAuthentication() {
		String bearertkr ="ghpsdsdasdsadsdasd";
		 given()
		 	.headers("Authorization", "Bearer "+bearertkr)
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200);	
	}
//Oauth1 athentication	
	@Test
	void testOauth1Authentication() {
		 given()
		 	.auth()
		 	.oauth("consumerKey","consumerSecrete","accessToken", "tokenSecrete")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200);	
	}
	
	//Oauth2 athentication	
		@Test
		void testOauth2Authentication() {
			 given()
			 	.auth()
			 	.oauth2("tokenadadsdhgdhghdghgh")
			.when()
				.get("https://postman-echo.com/basic-auth")
			.then()
				.statusCode(200);	
		}
		
		//APIKey athentication	
		@Test
		void testAPIKeyAuthentication() {
			 given()
			 	.queryParam("appid", "a")//pwede param yung authenticatio or pede headers
			.when()
				.get("https://postman-echo.com/basic-auth")
			.then()
				.statusCode(200);	
		}
}
