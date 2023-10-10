package seleniumPdf.SeleniumPdf;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PDFTextExtractor {
	private String inputPdfUrl = "https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf";

	private WebDriver driver = null;

	private static PDDocument document = null;

	private BufferedInputStream bufferedInputStream = null;

	private int numOfPages = 0;

 

 

	@SuppressWarnings("deprecation")

	public void setup() {

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.setHeadless(true);

		driver = new ChromeDriver(chromeOptions);

		driver.manage().window().maximize();

		driver.get(inputPdfUrl);

		System.out.println("SetUp");

	}

 

	@SuppressWarnings("deprecation")

	public void PDFLoader() throws Exception {

 

		System.out.println("PDFLoader");

 

		URL url  = new URL(inputPdfUrl);

		InputStream inputStream = url.openStream();

		bufferedInputStream = new BufferedInputStream(inputStream);

		PDDocument.load(bufferedInputStream);

		System.out.println(document.getNumberOfPages());

 

	}

 

	public void PDFTextExtracter() throws IOException {

 

		System.out.println("PDFTextExtracter");

		

 

		PDFTextStripper pdfTextStripper = new PDFTextStripper();

	    int startpage = pdfTextStripper.getStartPage();

	    System.out.println(startpage);

	    pdfTextStripper.getCurrentPage();

	    pdfTextStripper.getText(document);

	   // System.out.println(pdfTextStripper.getCurrentPage());

        String extractedText = pdfTextStripper.getParagraphStart();

        System.out.println(extractedText);

		

	}

 

	public void tearDown() {

		System.out.println("Ended");

		driver.quit();

	}

	public static void main(String[] args) throws Exception {

		PDFTextExtractor extractor = new PDFTextExtractor();

		//extractor.setup();

		//extractor.PDFLoader();

		//extractor.PDFTextExtracter();

		//extractor.tearDown();

	}

 

}
