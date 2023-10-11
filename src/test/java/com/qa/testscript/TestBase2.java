package com.qa.testscript;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBase2 {

	public WebDriver driver = null;
	public URL parseUrl = null;
	public InputStream inputStream = null;
	public BufferedInputStream bufferedInputStream = null;
	public PDDocument pddoc = null;
	public String inputPDFUrl = "https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf";
	public Timestamp timestamp = null;

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
	
	@Test
	public void demo() {
		System.out.println("Demo called");
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

}
