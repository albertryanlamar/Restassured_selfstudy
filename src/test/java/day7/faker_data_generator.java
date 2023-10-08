package day7;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

public class faker_data_generator 
{
	@Test
	void testGenerateDummyData() 
	{
		Faker fke = new Faker();
		String fname = fke.name().firstName();
		String lname = fke.name().lastName();
		
		String uname = fke.name().username();
		String passw = fke.internet().password();
		
		String phone = fke.phoneNumber().cellPhone();
		
		String emailadd = fke.internet().emailAddress();
		
		System.out.println("Full Name" + fname + " " + lname);
		
	}
}
