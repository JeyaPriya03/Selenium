package qa.Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import qa.Base.Base;

public class TableSortPage extends Base{
	
	
	@FindBy(xpath="//input")
	WebElement searchText;

	//@FindBy(xpath= "//table[@id='example']/tbody/tr/td")
	@FindBy(xpath ="//table[@id='example']/tbody/tr")
	List<WebElement>rows;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[1]")
	List<WebElement>column1;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[2]")
	List<WebElement>column2;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[3]")
	List<WebElement>column3;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[4]")
	List<WebElement>column4;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[5]")
	List<WebElement>column5;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[6]")
	List<WebElement>column6;
	
	@FindBy(xpath="//a[@class='paginate_button next disabled']")
	WebElement disabled;
	
	@FindBy(xpath="//a[@class='paginate_button next']")
	WebElement nextButton;
	
	@FindBy(xpath="//th[text()='Name']")
	WebElement sort;
	
	@FindBy(xpath="//div[@id='example_paginate']/span/a")
	List<WebElement> pagination;
	
	//@FindBy(xpath="th[aria-label='Office: activate to sort column ascending']")
	@FindBy(xpath="//th[text()='Office']")
	WebElement sortColumn3;
	
	public TableSortPage() throws IOException {
		PageFactory.initElements(driver,this);
	}

	public String getTileTableSort() {
		return driver.getTitle();
	}
	
	public void searchTable(String text) {
		searchText.sendKeys(text);
	}
	/*
	 * public Boolean checkSearchedText(String text) { Boolean value =
	 * list.stream().map(s->s.getText()).allMatch(s->s.contains(text)); return
	 * value; }
	 */
	
	public Boolean checkSearchedText(String text) {
		Boolean flag= false;
		System.out.println(column1.size());
		System.out.println(rows.size());
		int count =0;		
			for(int i=0;i<rows.size();i++) {
			if((column1.get(i).getText().toUpperCase().contains(text)) ||
			(column2.get(i).getText().contains(text)) ||
			(column3.get(i).getText().contains(text)) ||
			(column4.get(i).getText().contains(text)) ||
			(column5.get(i).getText().contains(text)) ||
			(column6.get(i).getText().contains(text))) {
				count++;
			}		
		}
			
	if(count ==rows.size()) {
		flag = true;
	}
	System.out.println(count);
		return flag;
	}

public Map<String, List<String>> sorting() {
	//for(WebElement i: column1)
	//List<String> list = i.getText();
	
	List<String> sortedList = column1.stream().map(s->s.getText()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	//sort.click();
	
	List<String> listinUI = column1.stream().map(s->s.getText()).collect(Collectors.toList());
	Map<String, List<String>> map = new HashMap<String, List<String>>();
	  map.put("sortedList",sortedList);
	  map.put("listUI",listinUI);
	  return map;	
}


public Map<String,List<String>>  pagination() {
	sortColumn3.click();
	for(int i=0;i<pagination.size();i++) {
		System.out.println("number og pages"+pagination.get(i).getText());
		//String pages = pagination.get(i).getText();
		//int page = Integer.parseInt(pages);
	}
		
		//Collection<String>tablePages = new ArrayList();
		
		List<String> nodes = new ArrayList<String>();
		
		for (WebElement i:column3)
			
			 nodes.add(i.getText());
		for(int k=1;k<pagination.size();k++) {
		
			pagination.get(k).click();
			for(WebElement j: column3) {
				nodes.add(j.getText());
			
			
				}
		}
		System.out.println(nodes);
		List<String> sortedList =nodes.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		//return nodes,sortedList;
		Map<String,List<String>> map = new HashMap<String, List<String>>();
		map.put("sortedList", sortedList);
		map.put("nodes", nodes);
		return map;
}
}
