package com.qa.opencart.Pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	ElementUtil elementUtil;
	private By productHeader = By.xpath("//div[@class='col-sm-4']/h1");
	private By productimages = By.xpath("//div[@class='col-sm-8']/ul/li/a/img");
	private By productMetaDtata = By.xpath("(//div[@class='col-sm-4']/ul)[1]/li");
	private By productPriceData = By.xpath("(//div[@class='col-sm-4']/ul)[2]/li");
	private By quantity = By.xpath("//input[@id='input-quantity']");
	private By addtocartbutton = By.xpath("//div[@class='form-group']/button");
	private By successmsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProductHeaderText() {
		return elementUtil.doGetElementText(productHeader).trim();
	} 
	
	 public int getProductImagesCount() {
		return elementUtil.getElements(productimages).size();
	 }
	

	 public Map<String, String> getProductInformation() {
		 Map<String, String> productinfo = new HashMap<String, String>();
		 productinfo.put("name", getProductHeaderText());
		 
		List<WebElement> productMetaData =  elementUtil.getElements(productMetaDtata);
			System.out.println(productMetaData.size());
		 
			for(WebElement e :productMetaData ) {
				String meta[] = e.getText().split(":");
				String metakey =   meta[0].trim();
				String metavalue = meta[1].trim();
				productinfo.put(metakey, metavalue);				
			}
		
			List<WebElement> productPriceList = elementUtil.getElements(productPriceData);
			productinfo.put("price", productPriceList.get(0).getText().trim());
			productinfo.put("exTaxPrice", productPriceList.get(1).getText().trim());
			return productinfo;
			
	 }
	 
	 public void selectquantity(String qty) {
		 elementUtil.doSendKeys(quantity, qty);
		 	 }
	 public void addToCart() {
		 elementUtil.doClick(addtocartbutton);
	 }
	 
	 public String getsuccessmsg() {
		 return elementUtil.doGetElementText(successmsg);
	 }
	 
	 
	 
	 
	 
	 
}
