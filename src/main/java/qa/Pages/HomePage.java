package qa.Pages;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.Base.Base;



public class HomePage extends Base{
	
	
	@FindBy(xpath="(//a[@class='dropdown-toggle'])[3]")
	WebElement clickTable;

	
	@FindBy(xpath=("//li[@class='dropdown open']/ul[@class='dropdown-menu']/li/a"))
			List<WebElement> list;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}

	
	public String getTitle() {
		return driver.getTitle();
	}
	
	
	public TableSortPage clickTableSort(String tableText) throws IOException {
		clickTable.click();
		for(WebElement i : list) {
			if(i.getText().contains(tableText)) {
				i.click();
				break;
			}
			
		}
		return new TableSortPage();
	}
		
		
	}

