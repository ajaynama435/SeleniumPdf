package com.qa.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	
	    static  ExtentReports extentrep= new ExtentReports();

		public static String timestamp() {
			return new SimpleDateFormat("yyyy_MM_dd#HH_mm_ss").format(new Date());
		}
	    public synchronized static  ExtentReports CreateExtentReports() {
	    	
	       ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/Test-Report-"+timestamp()+".html");
	       reporter.config().setReportName("PDF Automation - Validation & Comparsion Extent Report");
	       extentrep.attachReporter(reporter);
	       extentrep.setSystemInfo("Website name", "PDF Automation");
	       

	       return extentrep;
	    }
	   
	    
	 

	
}
