package com.qa.testscript;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.testng.annotations.Test;

public class TC02_PDFPageSplitorAndValidator extends TestBase2 {

	@Test
	public void PDFPagesSpilor() throws Exception {
		PDDocument pddoc = PDDocument.load(bufferedInputStream);
		int noOfPages = pddoc.getNumberOfPages();
		System.out.println("Number of pages present in given PDF file is :" + noOfPages);
		Splitter splitter = new Splitter();
		List<PDDocument> splitPages;
		try {
			splitPages = splitter.split(pddoc);
			int num = 1;
			for (PDDocument myDoc : splitPages) {
				myDoc.save("D://Splitfile-" + num + " " + timestamp() + ".pdf");
				num++;
				myDoc.close();
			}
			pddoc.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
