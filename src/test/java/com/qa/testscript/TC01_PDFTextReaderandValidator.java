package com.qa.testscript;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_PDFTextReaderandValidator extends TestBase2 {

	@Test
	public void PDFContentComparsion() throws IOException {

		PDDocument pddoc = PDDocument.load(bufferedInputStream);
		int pageCount = pddoc.getNumberOfPages();
		Assert.assertEquals(pageCount, 4);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String pdfTextSaverVariableOne = pdfStripper.getText(pddoc);
		//System.out.println(pdfTextSaverVariableOne);
		Assert.assertTrue(pdfTextSaverVariableOne.contains("Secondary bookmarks in a PDF file."));
		Assert.assertTrue(pdfTextSaverVariableOne.contains("Accelio Present Applied Technology"));
		sleep();
		pdfStripper.setStartPage(1);
		String pdfTextSaverVariableTwo= pdfStripper.getText(pddoc);
		Assert.assertTrue(pdfTextSaverVariableTwo.contains("Sample Data File "));
		pddoc.close();

	}
}