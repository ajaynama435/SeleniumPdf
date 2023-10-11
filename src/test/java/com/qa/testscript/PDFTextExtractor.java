package com.qa.testscript;

import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;

public class PDFTextExtractor extends TestBase {

	public PDFTextStripper pdfTextStripper = null;
	public PDFParser parser = null;
	public COSDocument cosDoc = null;
	public String parsedText = null;

	@Test
	public void PDFTextExtracter() throws IOException {

		System.out.println("PDFTextExtracter");

		pdfTextStripper = new PDFTextStripper();
		parser = new PDFParser((RandomAccessRead) bufferedInputStream);
		parser.parse();
		cosDoc = parser.getDocument();
		pddoc = new PDDocument(cosDoc);
		pdfTextStripper.setStartPage(2);
		pdfTextStripper.setEndPage(4);
		parsedText = pdfTextStripper.getText(pddoc);
		System.out.println(parsedText);
		pddoc.close();

	}

}
