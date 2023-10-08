package day3;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class query_param {
	
    @Test
	void test_queryandpath() {
		
	Response res=given()
			.pathParam("mypath","users")
			.queryParam("page", 2)
			.queryParam("id", 7)
		    
		.when()
		    .get("https://reqres.in/api/{mypath}"); 
	
		res.then()
			.statusCode(200)
			.assertThat()
			.body("data.first_name", is("Michael"))
			.log().all();
		

	}
    

}
