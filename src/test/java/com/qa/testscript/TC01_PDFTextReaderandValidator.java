package com.qa.testscript;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC01_PDFTextReaderandValidator extends TestBase {
	TestBase base;
	@Parameters("inputPDFUrl")
	@Test
	public void PDFTextReader(String inputPDFUrl) {
		try {
			parseUrl = new URL(inputPDFUrl);
			inputStream = parseUrl.openStream();
			bufferedInputStream = new BufferedInputStream(inputStream);
			pddoc.load(bufferedInputStream);

		} catch (MalformedURLException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


