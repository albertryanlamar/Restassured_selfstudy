package day1;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.Reporter;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class http_request {
	int idto;
 
@Test(priority =1)
 void getUser() {
	
	   given()
	  .when()
	    .get("https://reqres.in/api/users?page=2")
	  .then()
	     .statusCode(200)
	     .body("page",equalTo(2))
	     .log().all();
	 
 }
@Test(priority =2)
void creatuser() {
	 // in java we have hash map collection, by using it will generate the post request into hash map, and convert hash map into json format
	 // dont hash map in project, we donot hold the data in real project
	 HashMap data = new HashMap();
	 data.put("name", "Sensai mo to");
	 data.put("job", "Hokage");
	 
	 Response bobo = 
	  // given section
	  given()
        .contentType("application/json")
        .body(data)
      // when section
     .when()
        .post("https://reqres.in/api/users"); // request_post
	 
     // First 'then()' block - Verify status code is 201
     bobo.then()
             .assertThat()
             .statusCode(201);
              System.out.println("Status is OK");

     // Second 'then()' block - Verify response body contains the 'name' and 'job' fields
     bobo.then()
             .assertThat()
             .body("name", is("Sensai mo to"))
             .body("job", is("Hokage"));

     //Third 'then()' block - Verify response headers
    // bobo.then()
             //.assertThat()
             //.header("Content-Type", "application/json")
             ///.header("Server", "cloudflare");

     // Fourth 'then()' block - Perform additional assertions or verifications as needed
     // You can also extract and store specific values from the response for later use
     String userId = bobo.then()
             .extract()
             .path("id");
      // Fifth 'then()' block - Perform additional assertions or verifications as needed
      String cret = bobo.then()
             .extract()
             //.path("createdAt");
             .jsonPath().get("createdAt");
      System.out.println("Createdat "+ cret);
     //.then()
     //.response
    // .log().all();
  //.then()
   // .statusCode(201)
    //.log().all();
    
}
//@Test(priority = 3)
// void deluser() {
	//when()
	//.delete("https://reqres.in/api/idto")
	//.then()
	//.statusCode(204)
	//.log().all();
 //}

}
