package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {

	/*public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "/exel/data.xlsx";
		testData(excelPath,"sheet1");
	}*/
	WebDriver driver = null;
	
	@BeforeTest
	public void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	
	@Test(dataProvider = "test1data" )
	public void test1(String userName, String password) {
		System.out.println(userName + " | " + password);
		
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
		driver.findElement(By.name("abc"));
	}
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "/exel/data.xlsx";
		Object data[][] = testData(excelPath, "sheet1");
		return data;
	}
	
	public Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i = 1; i < rowCount; i++){
			for (int j = 0; j < colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData + " | ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data;
	}
}
