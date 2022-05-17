package com.qa.opencart.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class LoginPageTests extends BaseTest{
	
	@Description("login page title tst")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		System.out.println(title);
		
		
		Assert.assertEquals(title, "macbook");
		
	}

	@Description("forgot pwd")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void forgotpasswordLinkExist() {
		Assert.assertTrue(loginpage.isForgotPswdLinkExist());
	}
	
	@Description("login with correct credentials")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void loginTest() {
		accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		accpage.getAccPageTitle();
		Assert.assertEquals(accpage.getAccPageTitle(), Constants.ACC_PAGE_TITLE);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
