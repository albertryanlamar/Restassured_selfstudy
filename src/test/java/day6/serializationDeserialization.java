package day6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class serializationDeserialization {
	// POJO ----------> JSON(serialization)
	@Test
	void serializatio_convert_POJO2Json() throws JsonProcessingException {
		
		//Created java object using POJO
		pojo_postrequest poj = new pojo_postrequest();
		
		poj.setName("Er");
		poj.setJob("JOb1");
		
		//Convert java object --------> json object(serialization)
		ObjectMapper objMapper = new ObjectMapper();
		String jsondata = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(poj);
	    
		System.out.println(jsondata);
	}
	//JSOn -------------> Pojo
	@Test(priority=2)
	void deserializatio_JSON_convert_POJO() throws JsonProcessingException {
		//Create java object using POJO
		
		String jsonString = "{\"name\":\"John\", \"job\":\"New York\"}";
		
		//Convert json data -------->pojo(deserialization)
		ObjectMapper objMapper = new ObjectMapper();
		pojo_postrequest ss = objMapper.readValue(jsonString, pojo_postrequest.class);//convert json to pojo
	    
		
		System.out.println(ss.getName());
		System.out.println(ss.getJob());
	}
}
