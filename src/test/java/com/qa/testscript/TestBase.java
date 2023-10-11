package com.qa.testscript;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {


	public WebDriver driver = null;
	public URL parseUrl = null;
	public InputStream inputStream = null;
	public BufferedInputStream bufferedInputStream = null;
	public PDDocument pddoc = null;

	@Parameters("inputPDFUrl")
	@BeforeTest
	public void setup(String inputPDFUrl) {
		System.out.println("Started");
		/*
		 * ChromeOptions chromeOptions = new ChromeOptions();
		 * chromeOptions.setHeadless(true); driver = new ChromeDriver(chromeOptions);
		 */
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(inputPDFUrl);
	}
    
    
	@AfterTest
	public void tearDown() {
		try {
			if(driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
