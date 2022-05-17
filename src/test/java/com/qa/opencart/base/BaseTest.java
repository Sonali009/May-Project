package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.opencart.Pages.AccountsPage;
import com.qa.opencart.Pages.LoginPage;
import com.qa.opencart.Pages.ProductInfoPage;
import com.qa.opencart.Pages.RegistrationPage;
import com.qa.opencart.Pages.SearchResultPage;
import com.qa.opencart.factory.DriverFactory;

public class BaseTest {

	
	private WebDriver driver;
	DriverFactory df;
	public LoginPage loginpage;
	public AccountsPage accpage;
	public Properties prop;
	public SearchResultPage searchresultpage;
	public ProductInfoPage productinfopage;
	public RegistrationPage registrationPage;
	
	
	
	@Parameters({"browser", "version"})
	@BeforeTest
	public void setUp(String browserName, String browserVersion) {
		df = new DriverFactory();
		prop = df.init_prop();
		String browser = prop.getProperty("browser");
		String browserEnv = System.getProperty("browser");
		
		if(browserName!=null) {
			browser = browserName;
		}
		if(browserEnv!=null) {
			browser = browserEnv;
		}
		driver = df.init_driver(browser, browserVersion);
		loginpage = new LoginPage(driver);
		
	}
	
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
