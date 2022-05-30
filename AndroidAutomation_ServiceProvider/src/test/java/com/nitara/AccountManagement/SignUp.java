package com.nitara.AccountManagement;

import org.testng.annotations.Test;

import appCommonClasses.GenericBase;

public class SignUp extends GenericBase{

	@Test
	public void SignUp_ValidData() throws Exception {
		
		/** Select Language */
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		String phone =generateData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Enter PIN */
		createPasswordPage.enter_createPin(123456);
		createPasswordPage.enter_reEnterPin(123456);
		createPasswordPage.click_savePin();
		
		/** Enter Username */
		String firstName = "fName"+generateData.generateRandomNumber(2);
		String lastName = "lName"+generateData.generateRandomNumber(2);
		enterUsername.enter_firstName(firstName);
		enterUsername.enter_lastName(lastName);
		enterUsername.click_createNewAccount();
		
		/** Assert Success Page */
		createAccountSuccessPage.assert_snackBarText();
		createAccountSuccessPage.assert_successPageMsg();
		createAccountSuccessPage.click_getStartedBtn();
		
		/** Navigated to SP Home page - assert if set location option is shown */
		SPHomePage.assert_SPHomePage();

		
	}
	

}
