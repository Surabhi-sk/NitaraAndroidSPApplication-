package com.nitara.AccountManagement;

import org.testng.annotations.Test;
import appCommonClasses.GenericBase;

public class LoginWithOTP extends GenericBase{


	@Test
	public void LoginwithOTP_ValidData() throws Exception {
		
		/** Select Language */
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo("4444444444");
		enterPhoneNoPage.click_continue();
		
		/** Enter PIN */
		enterPinPage.click_loginWithOtpBtn();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Navigated to SP Home page - assert if user on SP homepage */
		SPHomePage.assert_SPHomePage();
		
	}

}
