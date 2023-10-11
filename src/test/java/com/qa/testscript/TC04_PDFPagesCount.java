package com.qa.testscript;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.testng.annotations.Test;

public class TC04_PDFPagesCount extends TestBase2{
	
	private int pageCount = 0;
	
	@Test
	public void PDFFilePagesCount() throws IOException {
		PDDocument pddoc = PDDocument.load(bufferedInputStream);
		 pageCount = pddoc.getNumberOfPages();
		System.out.println("Number of pages present in given PDF file is :"+pageCount);
		pddoc.close();
				
	}

}
