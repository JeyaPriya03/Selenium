package qa.TestData;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.core.util.FileUtils;
import org.testng.annotations.DataProvider;

public class ReadData {
   @DataProvider
	public Object[] getData() {
		//Object[][] obj= new Object[2][1];
		//obj[0][0]="Burks";
	//	obj[1][0]="Greer";
		return new Object[] {"burks"};
}
}