package com.qa.testscript;


import java.io.File;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.testng.annotations.Test;

@Test
public class TC05_PDFMergeTwoFiles extends TestBase {
	
	
	
	String url1="E:\\SeleniumPdf\\Files\\sample1.pdf";
    String url2="E:\\SeleniumPdf\\Files\\sample2.pdf";
	
	    public void PDFMergeFiles() throws Exception {
	    	File file1= new File(url1);
	        File file2=new File(url2);
	        
	        File newFile=new File("E:\\SeleniumPdf\\merge.pdf");
	        newFile.mkdirs();
	        PDFMergerUtility merge=new PDFMergerUtility();
	        merge.setDestinationFileName(newFile+"\\newfile.pdf");
	        
	        merge.addSource(file1);
	        merge.addSource(file2);
	        merge.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
	        System.out.println("pdf created");
	        
	        
	    }
	   
	    	

		   
}











   
   


