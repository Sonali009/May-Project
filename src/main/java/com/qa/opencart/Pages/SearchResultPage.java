package com.qa.opencart.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.ElementUtil;

public class SearchResultPage {
	
	ElementUtil elementutil;
	private WebDriver driver;
	
	//div[@class='product-thumb']
	By searchresult = By.xpath("//div[@class='product-thumb']");
	By resultItems = By.xpath("//div[@class='product-thumb']//h4/a");
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
		
	}
	
	public int getProductResultsCount() {
		return elementutil.getElements(searchresult).size();
		
	}
	
	public ProductInfoPage selectProductsFromResult(String productName) {
		List<WebElement> resultitemlist = elementutil.getElements(resultItems);
		System.out.println(productName+"   --> "+resultitemlist.size());
		for(WebElement e : resultitemlist) {
			if(e.getText().equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver); 
		
	}
	
	
	
	
	
	
	
	

}
