package test;

import java.awt.RenderingHints.Key;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo {

	WebDriver driver = null;
	public static String browserName = null;
	
	
	@BeforeTest
	public void setupTest() {
		PropertiesFile.getProperties();
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	
	
	@Test
	public void googleSearch() {
		
		driver.get("https://google.com/");
		//WebElement textBox = driver.findElement(By.xpath("//input[@name='q']"));
		//textBox.sendKeys("TEST");
		driver.findElement(By.name("q")).sendKeys("Automation step by step1");
		
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
			
	}
	
	
	@AfterTest
	public void tearDownTest() {
		// close the browser
		//driver.close();
		//driver.quit();
		System.out.println("Test Completed Successfully");
		PropertiesFile.setProperties();
	}
}
