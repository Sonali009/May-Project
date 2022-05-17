package com.qa.opencart.Utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACC_PAGE_TITLE = "My Account";
	public static final int ACC_PAGE_SECTIONS_COUNT = 4;
	public static final int PRODUCT_IMAGES_COUNT_MACBOOK =4;
	public static final String ACCOUNT_CREATION_SUCCESS_MSG = "Your Account Has Been Created";
	
	//****************sheetnames***************
	public static final String REGISTER_SHEET_NAME = "register";
	
	public static List<String> expectedAccSecList() {
		List<String> expList = new ArrayList<String>();
		expList.add("My Account");
		expList.add("My Orders");
		expList.add("My Affiliate Account");
		expList.add("Newsletter");
		
		return expList; 
	}

}
