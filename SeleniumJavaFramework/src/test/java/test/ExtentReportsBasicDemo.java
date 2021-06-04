package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasicDemo {
	
	private static WebDriver driver = null;
	

	public static void main(String[] args) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtendReports.html") ;
		
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test 1", "This is a test to validate Google search functionality");
        
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting Test Case");
		
		driver.get("https://google.com");
		test1.pass("Navidated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered text in search box");
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test1.pass("Presed enter");
		
		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		
		test1.pass("Test completed!");
		
		extent.flush(); // important 
	}

}
