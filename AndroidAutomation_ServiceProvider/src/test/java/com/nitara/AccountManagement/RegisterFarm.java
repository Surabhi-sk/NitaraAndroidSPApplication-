package com.nitara.AccountManagement;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nitara.PageObjects.RegisterFarm_EnterDetailsPage;
import com.nitara.PageObjects.RegisterFarm_EnterOTPPage;
import com.nitara.PageObjects.RegisterFarm_EnterPhonePage;
import com.nitara.PageObjects.RegisterFarm_SuccessPage;
import com.nitara.PageObjects.SP_HomePage;
import com.nitara.Report.TestReport;

import appCommonClasses.GenericBase;


public class RegisterFarm extends GenericBase{
	
	@Test(groups= {"Smoke"})
	public void registerFarm() throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		SPHomePage.waitForPageLoad();
		SPHomePage.pressRegisterFarmButton();
		
		String phoneNo = generateData.generateRandomPhoneNo();
		enterPhonePage.enterPhone(phoneNo);
		enterPhonePage.generateOtp();
		
		enterOTPPage.enter_otp("1111");			
		enterOTPPage.pressContinueBtn();
		
		farmerEnterDetailsPage.enter_firstName("Test");
		farmerEnterDetailsPage.enter_midname("Test");
		farmerEnterDetailsPage.enter_lastname("Test");
		farmerEnterDetailsPage.pressContinueBtn();
		
		RegisterFarm_SuccessPage success = new RegisterFarm_SuccessPage();
		String successMsg = success.successTxt();
		Assert.assertEquals(successMsg, "Farm has been Registered successfully");
	}
	
	
////	@Test
//	public void registerFarm_Localisation() throws Exception {
//		
//		GenerateData data = new GenerateData();
//		
//		String username = prop.getProperty("ServiceProviderUsername");
//		String password = prop.getProperty("ServiceProviderPassword"); 
//		
//		Login login = new Login();
//		login.userLogin(username, password);
//		
//		SP_HomePage sp = new SP_HomePage();
//		sp.pressRegisterFarmButton();
//		
//		RegisterFarm_EnterPhonePage phone = new RegisterFarm_EnterPhonePage();
//		Excel_Localisation excel= new Excel_Localisation();
//		JSONObject status = excel.ExcelCompare(phone.getPage(), phone.getClass().toString());
//		System.out.println(status);
//		String phoneNo = data.generateRandomPhoneNo();
//		phone.enterPhone(phoneNo);
//		phone.generateOtp();
//		
//		
//		RegisterFarm_EnterOTPPage otp = new RegisterFarm_EnterOTPPage();
//		status = excel.ExcelCompare(otp.getPage(), otp.getClass().toString());
//		System.out.println(status);
//		otp.enter_otp("1111");			
//		otp.pressContinueBtn();
//		
//		RegisterFarm_EnterDetailsPage details = new RegisterFarm_EnterDetailsPage();
//		status = excel.ExcelCompare(details.getPage(), details.getClass().toString());
//		System.out.println(status);
//		details.enterName("Farmer");
//		details.pressContinueBtn();
//		
//		RegisterFarm_SuccessPage success = new RegisterFarm_SuccessPage();
//		status = excel.ExcelCompare(success.getPage(), success.getClass().toString());
//		System.out.println(status);
//		
//		
//	}


}
