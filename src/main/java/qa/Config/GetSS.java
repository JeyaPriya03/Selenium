package qa.Config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import net.masterthought.cucumber.json.Output;
import qa.Base.Base;

public class GetSS extends Base {
public GetSS() throws IOException {
		//super();
		// TODO Auto-generated constructor stub
	}

public static String getSnap(String testCaseName) throws IOException  {
	File ss=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File file = new File (System.getProperty("user.dir")+("//reports//")+testCaseName+(".png"));
	FileUtils.copyFile(ss,file);
	return System.getProperty("user.dir")+("//reports//")+testCaseName+(".png");
}
}
