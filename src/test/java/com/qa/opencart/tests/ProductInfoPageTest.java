package com.qa.opencart.tests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest{
	SoftAssert softassert = new SoftAssert();
	
	@BeforeClass
	public void AccSetUp() {
		accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void productinfodatatest() {
		searchresultpage = accpage.doSearch("mackbook");
		productinfopage = searchresultpage.selectProductsFromResult("MacBook Pro");
		Map<String, String> accproductinfo = productinfopage.getProductInformation();
		softassert.assertTrue(productinfopage.getProductHeaderText().equals("Macbook Pro"));
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
