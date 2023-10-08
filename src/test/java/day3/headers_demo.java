package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class headers_demo {
	@Test(priority=1)
	void test_headers() {
		given()
		.when()
		    .get("https://www.google.com/")
		.then()
		    .header("Content-Type", "text/html; charset=ISO-8859-1")
		    .and()
		    .header("Cache-Control", equalTo("private, max-age=0"))
		    .and()
		    .header("Server",equalTo("gws"))
			.log().all();
	}
	@Test(priority=2)
	void test_headersINfo() {
		Response a = given()
		.when()
		    .get("https://www.google.com/");
		//get specific header
		a.getHeader("Content-Type");
		//print all headers
		System.out.println("All headers:\n" + a.getHeaders());
		
		Headers myheadersInfo = a.getHeaders();		
		// other way
		String yuy = "Content-Type";
		Header hea = myheadersInfo.get(yuy);
		if(hea!=null) {
			System.out.println(hea);
		} else {
            System.out.println(yuy + " not found");
        }
		//get all headers info
		
		for(Header hd : myheadersInfo) {
			System.out.println("Headers Info");
			System.out.println(hd.getName() + hd.getValue());		
		}
		
		//other way
		for(Header hd: myheadersInfo) {
			String headername = hd.getName();
			String headervalue= hd.getValue();
			System.out.println(headername + headervalue);
		}
		// other way to get specific headers
		String[] bb = {"Content-Type","Cache-Control"};
		
		for(String anc : bb ) {
			Header header = myheadersInfo.get(anc);
			if(header != null) {
			System.out.println(header.getName() + header.getValue());
			}
		}
		
		
				}
	}

