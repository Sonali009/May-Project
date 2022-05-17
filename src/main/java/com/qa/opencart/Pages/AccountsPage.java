package com.qa.opencart.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.Utils.ElementUtil;

public class AccountsPage {
	
	ElementUtil elementutil;
	private WebDriver driver;

	By logo = By.xpath("//div[@id='logo']/h1/a");
	By Headers = By.xpath("//div[@id='content']/h2");
	By SearchField = By.id("search");
	By searchButton = By.className("fa fa-search");
	
	
	public AccountsPage (WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
	}
	
	public String getAccPageTitle() {
		return elementutil.waitForTitleIs(10, Constants.ACC_PAGE_TITLE);
		
	}
	public boolean isLogoExist() {
		return elementutil.doIsDisplayed(logo);
	}
	
	
	public int getAccountPageHeadersCount() {
		return elementutil.getElements(Headers).size();
	}
	
	public List<String> getAccountPageHeadersList() {
		List<WebElement> acclist = elementutil.getElements(Headers);
		List<String> accsectionlist = new ArrayList<String>();
				for(WebElement e :acclist ) {
					accsectionlist.add(e.getText());			
		}
				return accsectionlist;
	}
	
	public SearchResultPage doSearch(String productname) {
		elementutil.waitForTitle(20, Constants.ACC_PAGE_TITLE);
		elementutil.doSendKeys(SearchField, productname);
		
		elementutil.doClick(searchButton);
		return new SearchResultPage(driver);
	}
	
	
	
}
