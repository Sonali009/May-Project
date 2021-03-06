package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	
	
	public OptionsManager(Properties prop) {
		this.prop=prop;
	}
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("--incognito"))) co.addArguments("--incognito");
		
		return co;
	}
	
	public FirefoxOptions getFireFoxOptions() {
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("--incognito"))) fo.addArguments("--incognito");
		
		return fo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
