package day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class createClass
{ 
	@Test(priority = 1)
	void test_createUser(ITestContext context) 
	{
		Faker fake = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", fake.name().name());
		data.put("job", fake.job().position());
		
		Response res = given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://reqres.in/api/users");
		String responsebody=res.getBody().asString();
		int ids = res.jsonPath().getInt("id");
		
		System.out.println("Result " + responsebody);
		System.out.println("ID is " + ids);		
		
		//context.setAttribute("use_id",ids);//set the variable in test level
	    context.getSuite().setAttribute("use_id", ids);
	}
}
