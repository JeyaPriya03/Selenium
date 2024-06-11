package qa.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class Base {
	public static Properties prop;
	public static WebDriver driver;
	
     public Base() throws IOException{
    	 prop = new Properties();
    	 //FileInputStream io = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\Properties\\Properties\\java\\qa\\Properties\\Properties");
    	 FileInputStream io = new FileInputStream("C:\\Users\\a888204\\OneDrive - Eviden\\Documents\\pro\\TestNGPratice1\\src\\main\\java\\qa\\Properties\\Properties");
    	 prop.load(io);
    	
     }
     
     
     public static void initilization() {
    	 if(prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
    		 driver = new ChromeDriver();
    		 driver.manage().window().maximize();
    	 }
    	 
    	 else if(prop.getProperty("broswer") == "Edge"){
    		 driver = new EdgeDriver();
    		 driver.manage().window().maximize();
    	 }
    	 
    	driver.get(prop.getProperty("url"));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	 
     }
     
    public static void tearUp() {
    	driver.close();
    }
}
