package com.Utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {


	public static void TakesScreenShot(WebDriver driver) throws IOException {

		File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File d = new File("D:/Shubham QA/Java Programs/Hybrid_Framework/ScreenShots/FailedTC.jpg");

		FileUtils.copyFile(s, d);

	}
	
	
}
