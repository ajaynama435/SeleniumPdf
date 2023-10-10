package seleniumPdf.SeleniumPdf;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class PdfValidation {
	Timestamp timestamp = null;
	WebDriver driver;
	String url="https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf";

	public void setup() throws InterruptedException
	{ChromeOptions chromeOptions = new ChromeOptions();

	chromeOptions.setHeadless(true);

	driver = new ChromeDriver(chromeOptions );

	driver.manage().window().maximize();
	driver.get(url);
	Thread.sleep(2000);

	System.out.println("ajay");
	}

	public void PDFLoader() throws Exception {



		System.out.println("PDFLoader");



		URL purl  = new URL(url);

		InputStream inputStream = purl.openStream();

		BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

		PDDocument pdDocument=PDDocument.load(bufferedInputStream);
		int noOfPages=pdDocument.getNumberOfPages();
		System.out.println(noOfPages);
		Splitter splitter=new Splitter();
		System.out.println("split start");
		timestamp=new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);

		List<PDDocument> splitPages=splitter.split(pdDocument);
		int num=1;
		for(PDDocument myDoc:splitPages)
		{
			myDoc.save("E:\\SeleniumPdf\\file"+num+".pdf");
			num++;
			myDoc.close();
		}



	}
	
		
	
	public void readPdfContent() throws IOException
	{
		URL pdfurl= new URL(url);
		InputStream ip=pdfurl.openStream();
		BufferedInputStream bf=new BufferedInputStream(ip);
		PDDocument pdDocument=PDDocument.load(bf);
		int pageCount=pdDocument.getNumberOfPages();
		System.out.println(pageCount);
		Assert.assertEquals(pageCount, 4);
		
		//pdf text content
		
		PDFTextStripper pdfStripper=new PDFTextStripper();
		String pdfText=pdfStripper.getText(pdDocument);
		System.out.println(pdfText);
		Assert.assertTrue(pdfText.contains("Secondary bookmarks in a PDF file."));
		System.out.println("***********************");
		Assert.assertTrue(pdfText.contains("Accelio Present Applied Technology"));
		System.out.println("***************************");
		
		//if you want particular page content;
		
		pdfStripper.setStartPage(1);
		String pdfText1=pdfStripper.getText(pdDocument);
		System.out.println("******hello world***********");
		
		Assert.assertTrue(pdfText.contains("Sample Data File "));
		
	}
	



	public void quit()
	{
		driver.quit();
	}


	public static void main(String[] args) throws Exception {
		PdfValidation pdf=new PdfValidation();
		pdf.setup();
		pdf.PDFLoader();
		pdf.readPdfContent();
		
		pdf.quit();
		

	}



}
