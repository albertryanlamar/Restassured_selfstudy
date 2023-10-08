package day6;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Listeners;
//json ------> jsonschema
//https://jsonformatter.org/json-to-jsonschema

public class JsonSchemaValidation {
	@Test(description="test schema")
	void jsonschemavalidation() {
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/TravelAgent")
		.then()
			.assertThat()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
	}
}
