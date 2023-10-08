package day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteUser 
{
	@Test
	void test_deleteUser(ITestContext context) 
	{
		//int idto = (Integer) context.getAttribute("use_id");
		int idto = (Integer) context.getSuite().getAttribute("use_id");
		given()
			.pathParam("id", idto)
		.when()
			.delete("https://reqres.in/api/users/{id}")
		.then()
			.statusCode(204);
	}
}
