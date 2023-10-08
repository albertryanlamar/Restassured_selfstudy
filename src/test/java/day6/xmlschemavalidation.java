package day6;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.matcher.RestAssuredMatchers;
import org.testng.annotations.Test;
public class xmlschemavalidation 
{
	@Test
	void xmlschemaValidation() 
	{
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.assertThat()
			.body(RestAssuredMatchers.matchesXsdInClasspath("traveler.xsd"));
	}
}
