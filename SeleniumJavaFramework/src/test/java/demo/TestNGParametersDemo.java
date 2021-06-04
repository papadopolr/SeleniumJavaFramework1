package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestNGParametersDemo {

	
	@Test
	@Parameters({"MyName"})
	public void test(@Optional("Radu") String name) {
		
		System.out.println("Name is: " + name);
		
	}
}
