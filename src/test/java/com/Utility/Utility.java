package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {


	public static void TakesScreenShot(WebDriver driver) throws IOException {

		File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File d = new File("D:/Shubham QA/Java Programs/Hybrid_Framework/ScreenShots/FailedTC.jpg");

		FileUtils.copyFile(s, d);

	}
	public static String GetDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException {
		
		String userdata;
		FileInputStream excel = new FileInputStream("D:/Shubham QA/Java Programs/Hybrid_Framework/ExcelData/ExcelDataSelenium.xlsx");
	
		Sheet data = WorkbookFactory.create(excel).getSheet("Sheet1");
		
		try {
			 userdata = data.getRow(row).getCell(cell).getStringCellValue();
		}
		catch (Exception e) {
			long NumData = (long) data.getRow(row).getCell(cell).getNumericCellValue();

			userdata = (""+NumData);
		}
		
		
		return userdata;
	}
	
	
}
