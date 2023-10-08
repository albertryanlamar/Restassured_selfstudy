package day5;

import java.io.File;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class fileUpload {
	@Test
	void singlefile() {
		File f = new File(".\\body.json");
		given()
			.multiPart("File",f)
			.contentType("multipart/form-data")
		.when()
		    .post("http://localhost:8080/uploadFile")
		.then()
		.log().all();
	}
	
	void multiplefile() {
		File f1 = new File(".\\body.json");
		File f2 = new File(".\\body.json");
		given()
			.multiPart("File",f1)
			.multiPart("File",f2)
			.contentType("multipart/form-data")
		.when()
		    .post("http://localhost:8080/uploadMultipleFiles")
		.then()
			.body("File", is("test"))
		    .log().all();
	}
	
	void multiplefilesmoreupload() {
		File f1 = new File(".\\body.json");
		File f2 = new File(".\\body.json");
		
		File filearr[] = {f1,f2};
		
		given()
			.multiPart("File",filearr)
			.contentType("multipart/form-data")
		.when()
		    .post("http://localhost:8080/uploadMultipleFiles")
		.then()
			.body("File", is("test"))
		    .log().all();
	}
	
	
	// Verify the download
	@Test(priority =3)
	void verifydownload() {
		
		given()
		.when()	
			.get("http://localhost:8080/uploadMultipleFiles")
		.then()
			.statusCode(200)
		    .log().all();
		}
}
