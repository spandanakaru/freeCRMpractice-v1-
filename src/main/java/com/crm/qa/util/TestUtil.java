package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.base.TestBase;
import com.sun.media.sound.InvalidFormatException;

public class TestUtil extends TestBase {

	public static long page_load_timeout=20;
	public static long implicit_wait = 10;
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\SpandanaKaru\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\crm_TestData.xlsx";
	
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	//static Workbook book;
	//static Sheet sheet;
	
	public void SwitchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file =null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try {
			//book = WorkbookFactory.create(file);
			wb = new XSSFWorkbook(file);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	/*catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
	*/

		
		//sheet = book.getSheet(sheetName);
		sh=wb.getSheet(sheetName);
		//old code
/*		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i< sheet.getLastRowNum();i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}
		}
*/
		
		//new code
		Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		
		for(int i=0;i< sh.getLastRowNum();i++)
		{
			for(int k=0; k<sh.getRow(0).getLastCellNum();k++)
			{
				data[i][k]= sh.getRow(i+1).getCell(k).getStringCellValue();
			}
		}

		
		return data;
		
	}
}
