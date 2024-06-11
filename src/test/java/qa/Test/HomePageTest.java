package qa.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.Base.Base;
import qa.Pages.HomePage;


public class HomePageTest extends Base{
HomePage homePage;

	public HomePageTest() throws IOException {
		super();
	}
		@BeforeTest
		public void setUp() throws IOException {
			initilization();
			
			homePage = new HomePage();
		}		
@Test(priority =1)
  public void getTitle() {
	String title =   homePage.getTitle();
	Assert.assertEquals(title, "Selenium Easy - Best Demo website to practice Selenium Webdriver Online");
  }

@Test(priority =2)
public void clickTable() throws IOException {
	
	 homePage.clickTableSort("Table Sort & Search");
	
}

}
