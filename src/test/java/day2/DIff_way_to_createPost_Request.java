package day2;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap; // java collection that you can store your data
/*	Ways to create request body
Hashmap 
Using org.json library = need to include in promt.xml
Using POJO class (plain old java object) = need tp creat separate class
Using external jsonfile */

public class DIff_way_to_createPost_Request {
//1.) post request Using hashmap
	// @Test (priority=1)
	void testUsing_hashmap() 
	{
		HashMap hap = new HashMap();
		hap.put("name", "Al");
		hap.put("job", "Taga Punas Lang");
		// example array
		// String coursearr[] = {"A","b"};
		// hap.put("course", coursearr);
		
		given()
		.contentType("application/json")
		.body(hap)
		
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.assertThat()
			.body("name",is("Al"))
			.body("job",is("Taga Punas Lang"))
			//.header("Content-Type","application/json: charset=utf-8")
			.log().all();
	}
	
	//2.) Using org.json library
		//@Test(priority=1)
		void testpostUsing_orgjsonlib() 
		{
		// creating data using org.json library
           JSONObject jsobj = new JSONObject();
           jsobj.put("name", "Al1");
           jsobj.put("job", "Taga2");
           
			given()
			.contentType("application/json")
			.body(jsobj.toString())
			
			.when()
				.post("https://reqres.in/api/users")
				
			.then()
				.statusCode(201)
				.assertThat()
				.body("name",is("Al1"))
				.body("job",is("Taga2"))
				//.header("Content-Type","application/json: charset=utf-8")
				.log().all();
		}
		
//3.) Using POJO Class
		//@Test(priority=2)
		void testpostUsing_pojo()
		{
		
			pojo_postrequest poj = new pojo_postrequest();
					poj.setName("Er");
					poj.setJob("JOb1");
			
			given()
			.contentType("application/json")
			.body(poj)
			.when()
				.post("https://reqres.in/api/users")
				
			.then()
				.statusCode(201)
				.assertThat()
				.body("name",is("Er"))
				.body("job",is("JOb1"))
				//.header("Content-Type","application/json: charset=utf-8")
				.log().all();
			System.out.println("Hi" + poj.getName());
		}
		//4.) Using external jsonfile
		@Test(priority=1)
		void testpostUsing_jsonfile() throws FileNotFoundException
		{
		
            File f = new File(".\\body.json");
            FileReader fr = new FileReader(f);
            JSONTokener jt = new JSONTokener(fr);
            
            JSONObject ob = new JSONObject(jt);
            
			given()
			.contentType("application/json")
		    .body(ob.toString())
			.when()
				.post("https://reqres.in/api/users")
				
			.then()
				.statusCode(201)
				.assertThat()
				.body("name",is("Hi"))
				.body("job",is("Hello"))
				//.header("Content-Type","application/json: charset=utf-8")
				.log().all();
		}
		//5.) using test ko lang
		@Test(priority=2)
		void testpostUsing_akin()
		{
			String jsonString = "{\"name\":\"John\", \"job\":\"New York\"}";
			
			JSONTokener j = new JSONTokener(jsonString);
			
			JSONObject oc = new JSONObject(j);
            
			given()
			.contentType("application/json")
		    .body(oc.toString())
			.when()
				.post("https://reqres.in/api/users")
				
			.then()
				.statusCode(201)
				.assertThat()
				.body("name",is("John"))
				.body("job",is("New York"))
				//.header("Content-Type","application/json: charset=utf-8")
				.log().all();
		}
	
	@Test(priority=2)
	// Deleting the record
	void testDel() {
		given()
		.when()
		   .delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204);
		  System.out.println("Record is Deleted");
	}
}
