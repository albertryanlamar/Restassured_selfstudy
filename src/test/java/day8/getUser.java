package day8;
import static io.restassured.RestAssured.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class getUser {
	@Test
	void test_getuser(ITestContext context) 
	{
		
		//int idto = (Integer) context.getAttribute("use_id"); //testlevel: this should come from creatuser class
		int idto = (Integer) context.getSuite().getAttribute("use_id");
		Response a =given()
		    //.contentType("application/json")
			.pathParam("id", idto)
		.when()
			.get("https://reqres.in/api/users/{id}");
		//.then()
		   // .statusCode(200);
		    //.log().all();
		int asc = a.getStatusCode();
		System.out.println("Status Code: " + asc);
			System.out.println("Retrieved use_id value: " + idto);
		
		
	}
}
