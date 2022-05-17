package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.Utils.Error;
import com.qa.opencart.Utils.ExcelUtil;
import com.qa.opencart.base.BaseTest;

public class RegistrationPageTest extends BaseTest {
	
	@BeforeClass
	public void setUpRegister() {
		registrationPage =loginpage.navigateToRegisterPage();
	}
	@DataProvider
	public Object[][] getRegistrationData() {
		Object data[][]=ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	
	@Test(dataProvider = "getRegistrationData")
	public void userRegistrationTest(String firstName, String lastName,String Email, String Telephone, String Password, String Subscribe) throws InterruptedException {
		Assert.assertTrue(registrationPage.accountregistration(firstName, lastName, Email, Telephone, Password,Subscribe ),
				Error.REGISTRATION_FAILED_MSG);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
