package day3;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

public class cookiesdemo {
	
	//@Test
	void testcokkies() {
		
		given()
		.when()
			.get("https://www.google.com/")
		.then()
		    .cookie("AEC","Ad49MVGuOQs8ENJDc4MGoFFtv7QReDevUwKpm7IZLmGi6VzJCbRbkFsy0Ps")
			.log().all();
	}
	
	@Test
    void getcookiesInfo() {
    	
    	Response res = given()
    	
    	.when()
    		.get("https://www.google.com/");
    	
    	//String aa = res.then()
    	//		.extract()
    	//		.path("Cookies");
    	//get single cookie
    	//String aa = res.getCookie("AEC");
    	//String bb = res.getHeader("Content-Type");
    	//System.out.println("Cookie AEC value " + aa);
    	
    	//System.out.println("Header value " + bb);
    	
    	// get all cookies
        Map<String, String> cookiesMap = res.getCookies();
        System.out.println("Cookies value:");

        for (Map.Entry<String, String> entry : cookiesMap.entrySet()) {
            String cookieName = entry.getKey();
            String cookieValue = entry.getValue();
            System.out.println(cookieName + ": " + cookieValue);
        }
        
        for(String k : cookiesMap.keySet())
        {
        	String absss = res.getCookie(k);
        	 System.out.println("Cookie Name: " + absss);
        }
        
        Headers headerMap = res.getHeaders();
        System.out.println("Headers value:");
        for (Header header : headerMap) {
            String headerName = header.getName();
            String headerValue = header.getValue();
            System.out.println(headerName + ": " + headerValue);
        }
 
        

        
	}

}
