package com.qa.testscript;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class TC05_PDFMergeTwoFiles extends TestBase2 {
	
	private URL  fristFileDownloadURL = null;
	private URL  secondFileDownloadURL = null;
	private InputStream inputStreamFileOneDownload = null;
	private InputStream inputStreamFileTwoDownload = null;
	private BufferedInputStream bufferStreamFileOne = null;
	private BufferedInputStream bufferStreamFileTwo = null;
	
	    public void PDFMergeFiles() throws Exception {
	    	
	    	//java.lang.IllegalStateException: PDF contains an encryption dictionary, please remove it with setAllSecurityToBeRemoved() or set a protection policy with protect()

		    PDFFilesDownload(inputPDFUrl, inputPDFUrl);
		    
		    File file1 = new File("D://Downloaded//*.pdf");
	        File file2 =new File("D://Downloaded//*.pdf");
	       
	        
	        File newFile=new File("E:\\SeleniumPdf\\merged "+timestamp()+".pdf");
	        newFile.mkdirs();
	        PDFMergerUtility merge=new PDFMergerUtility();
	        merge.setDestinationFileName(newFile+"\\After Merged file Created "+timestamp()+".pdf");
	        
	        merge.addSource(file1);
	        merge.addSource(file2);
	        merge.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
	        
	    }
	    
	    @Parameters({"FirstFileURL","SecondFileURL"})
	    public void PDFFilesDownload(String FirstFileURL, String SecondFileURL) throws Exception {
	    	
	    	
	    	sleep();
	    	fristFileDownloadURL = new URL(FirstFileURL);
	    	secondFileDownloadURL = new URL(SecondFileURL);
	    	sleep();
	    	inputStreamFileOneDownload = fristFileDownloadURL.openStream();
	    	inputStreamFileTwoDownload = secondFileDownloadURL.openStream();
	    	
	    	bufferStreamFileOne = new BufferedInputStream(inputStreamFileTwoDownload);
	    	bufferStreamFileTwo = new BufferedInputStream(inputStreamFileTwoDownload);
	    	
	    	
	    	
	    	PDDocument pddocFileOne = PDDocument.load(bufferStreamFileOne);
	    	PDDocument pddocFileTwo = PDDocument.load(bufferStreamFileTwo);
	    	
	    	for (int fileCount = 0; fileCount <=2;fileCount++) {
	    			
		    	if (pddocFileOne.isEncrypted() && pddocFileTwo.isEncrypted() ) {
		    		pddocFileOne.setAllSecurityToBeRemoved(true);
		    		pddocFileOne.save("D://Downloaded//" + fileCount + ".pdf");
		    		pddocFileOne.close();
		    		
		    		pddocFileTwo.setAllSecurityToBeRemoved(true);
		    		pddocFileTwo.save("D://Downloaded//" + fileCount + ".pdf");
		    		pddocFileTwo.close();
		    	}
		    	
	    	}
	    	
	    }

}











   
   


