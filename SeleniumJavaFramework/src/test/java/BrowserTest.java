import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {
		
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectpath);
		
		//System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckodriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver" , projectpath + "\\driver\\chromedriver\\chromedriver.exe" );
		//WebDriver driver = new ChromeDriver();

		//System.setProperty("webdriver.ie.driver" , projectpath + "\\driver\\iedriver\\IEDriverServer.exe" );
		//WebDriver driver = new InternetExplorerDriver();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("http://google.com/");
		WebElement textBox = driver.findElement(By.xpath("//input[@name='q']"));
		textBox.sendKeys("Automation Sep by step");
		
		List<WebElement> listOfInputElements =  driver.findElements(By.xpath("//input"));
		int count =  listOfInputElements.size();
		System.out.println("Count of Input elements: "+ count );
		
		//driver.findElement(By.name("q")).sendKeys("Radu");
		
		Thread.sleep(3000);
		//driver.close();
		//driver.quit();
	}
}
