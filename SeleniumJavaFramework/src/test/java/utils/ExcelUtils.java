package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}
		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause()); 
			exp.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//getRowCount();
		getCellDataString(0,0);
		getCellDataNumber(1,1);
	}

	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows:" + rowCount);
			workbook.close();
		} 
		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause()); 
			exp.printStackTrace();
		}
		return rowCount;
	}
	
	public static int getColumnCount() {
		int columnCount = 0;
		try {
			columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of columns:" + columnCount);
			workbook.close();
		} 
		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause()); 
			exp.printStackTrace();
		}
		return columnCount;
	}

	public static String getCellDataString(int rowNum, int colNum) {
		String cellDate = null;
		try {
			cellDate = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(cellDate);
		}
		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause()); 
			exp.printStackTrace();
		}
		return cellDate;
	}
	
	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			double cellDate = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellDate);
		}
		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause()); 
			exp.printStackTrace();
		}
	}


}
