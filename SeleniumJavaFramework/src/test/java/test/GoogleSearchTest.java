package test;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import Pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null; 
	
	public static void main(String[] args) {
		googleSearch();
	}

	public static void googleSearch() {
		//System.getProperty()
		//WebDriver driver = new ChromeDriver();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		//WebElement textBox = driver.findElement(By.xpath("//input[@name='q']"));
		//textBox.sendKeys("TEST");
		//driver.findElement(By.name("q")).sendKeys("Automation step by step1");
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation RADU");
		
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		//driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		GoogleSearchPage.button_search(driver).click();
		//driver.close();
		
		System.out.println("Test Completed Successfully");
				
	}
}
