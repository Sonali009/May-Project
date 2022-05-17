package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.Pages.AccountsPage;
import com.qa.opencart.Pages.ProductInfoPage;
import com.qa.opencart.Utils.Constants;
import com.qa.opencart.Utils.Error;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.factory.DriverFactory;



public class AccountsPageTests extends BaseTest{
	
	SoftAssert softassert = new SoftAssert();
	
	@BeforeClass
	public void AccSetUp() {
		
		accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority =1)
	public void AccPageTitleTest() {
		String title = accpage.getAccPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.ACC_PAGE_TITLE);
	}
	
	@Test(priority =2)
	public void accPageHeaderTest() {
		Assert.assertTrue(accpage.isLogoExist());
		
	}
	@Test(priority =3)
	public void accPageSectionsCountTest() {
		Assert.assertEquals(accpage.getAccountPageHeadersCount(), Constants.ACC_PAGE_SECTIONS_COUNT, Error.ACC_PAGE_SECTION_ERROR);
	}
	@Test(priority =4)
	public void accpagesectionsTest() {
		List<String> actualaccseclist= accpage.getAccountPageHeadersList();
		System.out.println(actualaccseclist);
		Assert.assertEquals(actualaccseclist, Constants.expectedAccSecList());
	}
	
	@Test(priority =5)
	public void searchTest() {
		searchresultpage = accpage.doSearch("macbook");
		Assert.assertTrue(searchresultpage.getProductResultsCount()>0, Error.SEARCH_NOT_SUCCESSFUL);
	}
	
	
	@Test(priority = 6)
	public void selectproducttest() {
		searchresultpage = accpage.doSearch("macbook");
		productinfopage = searchresultpage.selectProductsFromResult("MacBook Pro");
		String actualheader = productinfopage.getProductHeaderText();
		softassert.assertEquals(actualheader, "MacBook Pro", Error.PRODUCT_HEADER_NOT_FOUND);
		softassert.assertEquals(productinfopage.getProductImagesCount(), Constants.PRODUCT_IMAGES_COUNT_MACBOOK);
		softassert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
