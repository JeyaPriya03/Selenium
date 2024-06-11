package testComponent;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import qa.Base.Base;
import qa.Config.GetSS;
import reports.ExtendReport;

public class Listener extends Base implements ITestListener {
	
	public Listener() throws IOException {
		
		// TODO Auto-generated constructor stub
	}

	ExtentTest test;
	ExtentReports extend = ExtendReport.Report();
	
	@Override		
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        	extend.flush();
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult arg0) {					
        // TODO Auto-generated method stub	
    	String path= null;
    	try {
		path =	GetSS.getSnap(arg0.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		test.addScreenCaptureFromPath(path, arg0.getMethod().getMethodName());
        		test.fail(arg0.getThrowable());
    }		

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub				
    	test = extend.createTest(arg0.getMethod().getMethodName());
    }		

    @Override		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		test.log(Status.PASS, "passed");
    }		
}
