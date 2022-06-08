package com.nitara.AccountManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class ForgotPin extends GenericBase{
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void ForgotPin_PinLessThanSixDigitsNotAccepted(Map<String,String> data) throws Exception{
		
		/** Select Language */
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		String phone = prop.getProperty("Username");
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/**Forgot PIN */
		enterPinPage.click_forgotPinBtn();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Set PIN of 2 digits and click save*/
		int pin = Integer.parseInt(generateData.generateRandomNumber(2));
		createPasswordPage.enter_createPin(pin);
		createPasswordPage.click_savePin();
		createPasswordPage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void ForgotPin_PinAndConfirmPinMustMatch(Map<String,String> data) throws Exception{
		
		/** Select Language */
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		String phone = prop.getProperty("Username");
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/**Forgot PIN */
		enterPinPage.click_forgotPinBtn();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Set PIN and Confirm PIN to different numbers and click save*/
		int pin1 = Integer.parseInt(generateData.generateRandomNumber(6));
		int pin2 = Integer.parseInt(generateData.generateRandomNumber(6));
		createPasswordPage.enter_createPin(pin1);
		createPasswordPage.enter_reEnterPin(pin2);
		createPasswordPage.click_savePin();
		createPasswordPage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void ForgotPin_CannotSetOldPin(Map<String,String> data) throws Exception{
		
		/** Select Language */
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		String phone = prop.getProperty("Username");
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/**Forgot PIN */
		enterPinPage.click_forgotPinBtn();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Set PIN */
		int pin = Integer.parseInt(generateData.generateRandomNumber(6));
		createPasswordPage.enter_createPin(pin);
		createPasswordPage.enter_reEnterPin(pin);
		createPasswordPage.click_savePin();
		
		/** Navigated to Farmer Home page - assert if user on farmer homepage */
		SPHomePage.waitForPageLoad();
		SPHomePage.assert_SPHomePage();
		
		/** Logout **/
		SPHomePage.click_SettingsButton();
		settingsPage.waitForPageLoad();
		settingsPage.select_logoutbtn();
		
		
		/** Login again **/
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/**Forgot PIN */
		enterPinPage.click_forgotPinBtn();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Set PIN */
		createPasswordPage.enter_createPin(pin);
		createPasswordPage.enter_reEnterPin(pin);
		createPasswordPage.click_savePin();
		
		createPasswordPage.assertWarningMsg(data.get("warningMessage"));
		
	}

	@Test
	public void ForgotPIN() throws Exception {
		
		/** Select Language */
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		String phone = prop.getProperty("Username");
		enterPhoneNoPage.enter_PhoneNo(phone);
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
