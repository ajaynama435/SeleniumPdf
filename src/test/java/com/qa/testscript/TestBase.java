package com.qa.testscript;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {

	public WebDriver driver = null;
	public URL parseUrl = null;
	public InputStream inputStream = null;
	public BufferedInputStream bufferedInputStream = null;
	public PDDocument pddoc = null;
	public String inputPDFUrl = "https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf";
	public Timestamp timestamp = null;
	public static String screenshotsSubFolderName;
	public  ExtentReports extentReports;
	public  ExtentTest extentTest;

	@BeforeClass
	public void setup() throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir"));
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(inputPDFUrl);
		parseUrl = new URL(inputPDFUrl);
		inputStream = parseUrl.openStream();
		bufferedInputStream = new BufferedInputStream(inputStream);
		
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		try {
			if (driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy_MM_dd#HH_mm_ss").format(new Date());
	}

	public void sleep() {
		try {
			Thread.sleep(9000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String captureScreenshot(String fileName) {
		
		if(screenshotsSubFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		    screenshotsSubFolderName = myDateObj.format(myFormatObj);
		}
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+ screenshotsSubFolderName+"/"+fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();
	}
	
	@Test
	public void demo() {
		
	}

}
