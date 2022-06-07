package com.nitara.AccountManagement;

import org.testng.annotations.Test;
import appCommonClasses.GenericBase;

public class LoginWithOTP extends GenericBase{


	@Test(groups = {"Regression"})
	public void LoginwithOTP_ValidData() throws Exception {
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("4444444444");
		enterPhoneNoPage.click_continue();
		
		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();
		
		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Navigated to SP Home page - assert if user on SP homepage */
		SPHomePage.assert_SPHomePage();
		
	}
	
	@Test(groups = {"Regression"})
	public void LoginwithOTP_LessThan4Digits() throws Exception{
				
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number */
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("4444444444");
		enterPhoneNoPage.click_continue();
		
		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();
		
		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.enter_otp("111 ");
		enterOTPpage.click_ContinueBtn();
		
		
		/** Assert Warning Message */
	    WarningPage.captureScreenshots("Login with OTP less than 4 digits");
		WarningPage.assertWarningMsg("Please enter OTP to continue.");
	}

	@Test(groups = {"Regression"})
	public void LoginwithOTP_IncorrectOTP() throws Exception{
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number */
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("4444444444");
		enterPhoneNoPage.click_continue();
		
		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();
		
		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.enter_otp("1234");
		enterOTPpage.click_ContinueBtn();
		
		
		/** Assert Warning Message */
	    WarningPage.captureScreenshots("Login with Incorrect OTP");
		WarningPage.assertWarningMsg("The OTP you entered is incorrect. Please check & re-enter the correct OTP.");
		
	}
	
	@Test(groups = {"Regression"})
	public void LoginWithOTP_30SecondsCounter() throws Exception{
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number */
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("4444444444");
		enterPhoneNoPage.click_continue();
		
		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();
		
		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_ResendSMSBtn();
		
		/**Assertions */
		enterOTPpage.captureScreenshots("Navigated to Enter OTP page after clicking Resend OTP");
		enterOTPpage.assert_enterOTPpage();
		
	}
	
	@Test(groups = {"Regression"})
	public void LoginWithOTP_ResendOTPMoreThanThreeTimesViaSMS() throws Exception{
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number */
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("4444444444");
		enterPhoneNoPage.click_continue();
		
		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();
		
		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_ResendSMSBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_ResendSMSBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_ResendSMSBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_ResendSMSBtn();
		
		/** Assert Warning Message */
	    WarningPage.captureScreenshots("Login with OTP send SMS more than 3 times");
		WarningPage.assertWarningMsg("Maximum resend OTP attempts exhausted. Please wait for 5 minutes and Generate New OTP.");
		
	}
	
	@Test(groups = {"Regression"})
    public void LoginWithOTP_ResendOTPMoreThanThreeTimesViaCall() throws Exception{
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number */
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("4444444444");
		enterPhoneNoPage.click_continue();
		
		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();
		
		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_SendOTPViaCallBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_SendOTPViaCallBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_SendOTPViaCallBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_SendOTPViaCallBtn();
		enterPhoneNoPage.waitForPageLoad();
		
		/** Assert Warning Message */
	    WarningPage.captureScreenshots("Login with OTP send OTP via call more than 3 times");
		WarningPage.assertWarningMsg("Maximum resend OTP attempts exhausted. Please wait for 5 minutes and Generate New OTP.");
		
	}

}
