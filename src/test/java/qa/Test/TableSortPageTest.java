package qa.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.Base.Base;
import qa.Pages.HomePage;
import qa.Pages.TableSortPage;
import qa.TestData.ReadData;
import testComponent.FailureListener;

public class TableSortPageTest extends Base{
	TableSortPage tableSortPage;

	public TableSortPageTest() throws IOException {
		
		super();	
	}
	
		@BeforeClass
		public void initializa() throws IOException {
			tableSortPage = new TableSortPage();
		}
		
   
	@Test(priority =3, retryAnalyzer = FailureListener.class)
	public void getTItleTableSort() {
		String text =tableSortPage.getTileTableSort();
		Assert.assertEquals(text, "Selenium Easy - Tabel Sort and Search De");
	}
	
	
	@Test(priority=4, dataProvider = "getData")
	public void searchText(String text) {
		
		tableSortPage.searchTable(text);
	}
	
	
	@Test(priority=5, dataProvider = "getData")
	
	public void chechList(String text) {
	//text ="Burks";
		Boolean value =tableSortPage.checkSearchedText(text);
		Assert.assertTrue(value);
	}
	
	@Test(priority =6)
	public void sorting() {
		Map<String,List<String>>map =tableSortPage.sorting();
		//Assert.assertEquals(map.get("listUI"), map.get("sortedList"));
		}
	
	
	@Test(dependsOnMethods = "sorting")
	public void Pagination() {
		Map<String,List<String>>map =tableSortPage.pagination();
		Assert.assertEquals(map.get("nodes"), map.get("sortedList"));
	}
	@DataProvider
	public Object[] getData() {
		//Object[][] obj= new Object[2][1];
		//obj[0][0]="Burks";
	//	obj[1][0]="Greer";
		return new Object[] {"S"};
}
	
	
}
