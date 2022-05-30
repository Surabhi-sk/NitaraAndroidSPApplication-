package com.nitara.AccountManagement;

import org.testng.annotations.Test;

import appCommonClasses.GenericBase;

public class ForgotPin extends GenericBase{

	@Test
	public void ForgotPIN() throws Exception {
		
		/** Select Language */
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo("4444444444");
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterPinPage.click_forgotPinBtn();
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Enter PIN */
		int pin = Integer.parseInt(generateData.generateRandomNumber(6));
		createPasswordPage.enter_createPin(pin);
		createPasswordPage.enter_reEnterPin(pin);
		createPasswordPage.click_savePin();
		
		/** Navigated to SP Home page - assert if user on SP homepage */
		SPHomePage.assert_SPHomePage();
		
		
	}
	
		
}
