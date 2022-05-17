package com.qa.opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.Constants;
import com.qa.opencart.Utils.ElementUtil;

public class RegistrationPage {
	private WebDriver driver;
	private ElementUtil elementutil;
	
	
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");
	
	private By subscribeYes = By.xpath("//label[@class='radio-inline'][position()=1]/input");
	private By subscribeNo = By.xpath("//label[@class='radio-inline'][position()=2]/input");
	private By agreecheckbox = By.name("agree");
	private By continueButton = By.xpath("//input[@class='btn btn-primary']");
	private By successmsg = By.xpath("//div[@id='content']/h1");
	private By logoutLink = By.xpath("(//a[contains(text(),'Logout')])[2]");
	private By registrationLink = By.xpath("(//a[contains(text(), 'Register')])[2]");
	
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		elementutil = new ElementUtil(driver);
	}
	
	
	
	public boolean accountregistration(String firstName, String lastName,String Email, String Telephone, String Password, String Subscribe) throws InterruptedException {
		elementutil.doSendKeys(this.firstname,firstName );
		elementutil.doSendKeys(this.lastname,lastName );
		elementutil.doSendKeys(this.email,Email );
		elementutil.doSendKeys(this.telephone,Telephone );
		elementutil.doSendKeys(this.password,Password );
		elementutil.doSendKeys(this.confirmpassword, Password );
		
		if(Subscribe.equals("Yes")) {
			elementutil.doClick(subscribeYes);
		}
		else {
			elementutil.doClick(subscribeNo);
		}
		
		elementutil.doClick(agreecheckbox);
		elementutil.doClick(continueButton);
		elementutil.waitForVisiblilityOfElement(this.successmsg, 5);
		String msg = elementutil.doGetElementText(this.successmsg);
		//elementutil.doClick(logoutLink);
		//Thread.sleep(6000);
		if(msg.contains(Constants.ACCOUNT_CREATION_SUCCESS_MSG)) {
			elementutil.doClick(logoutLink);
			elementutil.doClick(registrationLink);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
