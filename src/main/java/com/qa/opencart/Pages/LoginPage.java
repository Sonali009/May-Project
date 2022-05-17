package com.qa.opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.Utils.ElementUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Story("userstory - 100, design the login page for demo opencart")
@Epic("Epic-100: design login page feature")
public class LoginPage {
	//private WebDriver driver;
	private ElementUtil elementutil;
	private WebDriver driver;

	//Page Objects - By Locators - object reference
	
	private By username = By.xpath("//input[@id='input-email']");
	private By password = By.xpath("//input[@id='input-password']");
	private By loginbutton = By.xpath("//input[@value='Login']");
	private By forgotpassword = By.xpath("//div[@class='form-group']/a[text() = 'Forgotten Password']");
	private By registerLink = By.linkText("Register");
	
	
	//Constructor -
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
			}
	
	
	//page actions-
	@Step("getting login page title ...")
	public String getLoginPageTitle() {
		//return driver.getTitle();
		return elementutil.waitForTitleContains(5, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Step("forgot pwd ....")
	public boolean isForgotPswdLinkExist() {
		//return driver.findElement(forgotpassword).isDisplayed();
		return elementutil.doIsDisplayed(forgotpassword);
	}
	@Step("login with username: {0} and pwd: {1}")
	public AccountsPage doLogin(String un, String pwd) {
		
		System.out.println(un+pwd);
		//driver.findElement(username).sendKeys(un);
		//driver.findElement(password).sendKeys(pwd);
		//driver.findElement(loginbutton).click();
		elementutil.doSendKeys(username, un);
		elementutil.doSendKeys(password, pwd);
		elementutil.doClick(loginbutton);
		return new AccountsPage(driver);
		
	}
	@Step("navigate to register page")
public RegistrationPage navigateToRegisterPage() {
		elementutil.doClick(registerLink);
		return new RegistrationPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
