package com.nitara.AccountManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;


public class Login extends GenericBase{

	@Test
	public void Login_ValidData() throws Exception {
		
		/** Select Language */
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.waitForPageLoadBar();
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo("8820288909");
		enterPhoneNoPage.click_continue();
		enterPhoneNoPage.waitForPageLoadBar();
		
		/** Enter PIN */
		enterPinPage.enter_pin("123456");
		enterPinPage.click_loginBtn();
		
		/** Navigated to SP Home page - assert if user on SP homepage */
		SPHomePage.assert_SPHomePage();
	}

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Login_PinLessThan6(Map<String,String> data) throws Exception{
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn();
				
		enterPhoneNoPage.enter_PhoneNo(data.get("phoneNumber"));
		enterPhoneNoPage.click_continue();
		
		enterPinPage.enter_pin(data.get("pin"));
		enterPinPage.click_loginBtn();
		enterPinPage.assertWarning(data.get("warningMessage"));

	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Login_PinMandate(Map<String,String> data) throws Exception{
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn();
		
		enterPhoneNoPage.enter_PhoneNo(data.get("phoneNumber"));
		enterPhoneNoPage.click_continue();
		
//		enterPinPage.enter_pin(data.get("pin"));
		enterPinPage.click_loginBtn();
		enterPinPage.assertWarning(data.get("warningMessage"));

	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Login_PhoneMandate(Map<String,String> data) throws Exception{
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn();
		
//		enterPhoneNoPage.enter_PhoneNo(data.get("phoneNumber"));
//		enterPhoneNoPage.enter_PhoneNo("");
		enterPhoneNoPage.click_continue();
		enterPinPage.assertWarning(data.get("warningMessage"));

	}
}
