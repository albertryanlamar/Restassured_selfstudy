package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class updateUser {
	@Test
	void test_updateUser(ITestContext context) 
	{
		//int idto = (Integer) context.getAttribute("use_id"); //testlevel
		int idto = (Integer) context.getSuite().getAttribute("use_id"); //test suite level
		Faker fake = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", fake.name().name());
		data.put("job", fake.job().position());
		int id = 0;
		
		Response res = given()
			.contentType("application/json")
			.pathParam("id", idto)
			.body(data.toString())
		.when()
			.put("https://reqres.in/api/users/{id}");
		String responsebody=res.getBody().asString();
		
		System.out.println("Result " + responsebody);
	}
}
