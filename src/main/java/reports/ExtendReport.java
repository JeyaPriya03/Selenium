package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.vimalselvam.cucumber.listener.Reporter;

public class ExtendReport {
	
	public  static ExtentReports Report() {
  String path = "C:\\Users\\a888204\\OneDrive - Eviden\\Documents\\pro\\TestNGPratice1\\src\\main\\java\\reports\\report";
  
	
		  
		  ExtentSparkReporter spark = new ExtentSparkReporter(path);
		  spark.config().setDocumentTitle("testing");
		  
		  ExtentReports extent = new ExtentReports();
		  extent.attachReporter(spark);
		 extent.setSystemInfo("Tester", "Priya") ;
		 return extent;
		  
	}

	
}
