package com.nitara.AccountManagement;

import org.testng.annotations.Test;

import appCommonClasses.GenericBase;

public class Login extends GenericBase{

	@Test
	public void Login_ValidData() throws Exception {
		
		/** Select Language */
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo("8888888882");
		enterPhoneNoPage.click_continue();
		
		/** Enter PIN */
		enterPinPage.enter_pin("123456");
		enterPinPage.click_loginBtn();
		
		/** Navigated to SP Home page - assert if user on SP homepage */
		SPHomePage.assert_SPHomePage();
	}

}
