package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static String highlight;
	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the driver based on diff parameters.
	 * 
	 * @param browser
	 */

	public WebDriver init_driver(Properties prop) {

		String browsername = prop.getProperty("browser").trim();
		highlight = prop.getProperty("highlight").trim();
		optionsManager = new OptionsManager(prop);
		
		System.out.println("browser is -->" + "browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFireFoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFireFoxOptions()));
		} 
		else if (browsername.equalsIgnoreCase("safari")) {
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}

		else {
			System.out.println("browser not found");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		prop=init_prop();
		driver.get(prop.getProperty("url").trim());
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
/*
 * This method is initializing the properties from .properties file
 */
	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip = null;
		String env = System.getProperty("env");
		if(env==null) {
			 try {
				ip = new FileInputStream("src\\test\\resources\\config\\config.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}}
			 else {
				 try {
				 switch (env) {
				case "qa":
					ip = new FileInputStream("src\\test\\resources\\config\\qa.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("src\\test\\resources\\config\\dev.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("src\\test\\resources\\config\\stage.config.properties");
					break;

				default:
					break;
				}
			 }
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
				 try {
					 prop.load(ip);
				 }catch(IOException e) {
					 e.printStackTrace();
				 }
		
				return prop;
	}
		return prop;

	}
	

public String getScreenshot() {
	String src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
	File srcFile = new File(src);
	
	String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
	File destination = new File(path);
	
	try {
		FileUtils.copyFile(srcFile, destination);
	}catch (IOException e){ 
			e.printStackTrace();
		}
	return path;
	
}

public WebDriver init_driver(String browser, String browserVersion) {
	// TODO Auto-generated method stub
	return driver;
}













}
