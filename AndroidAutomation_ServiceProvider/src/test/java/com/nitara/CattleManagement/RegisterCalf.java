package com.nitara.CattleManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class RegisterCalf extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_Calf(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = generateData.generateRandomNumber(12);
		
		SPHomePage.pressRegisterCattleButton();
		
		//Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		
		cattleTypePage.select_cattleType("CALF");
		
		// Calf Register form
		registerCattleCalfPage.assert_CattleType();
		registerCattleCalfPage.assert_Phone_Number(phone);
		registerCattleCalfPage.enter_TagNumber(tagNumber);
		registerCattleCalfPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleCalfPage.select_YOB(data.get("yearOfBirth"));
		registerCattleCalfPage.select_month(data.get("monthOfBirth"));
//		registerCattleCalfPage.select_cattleType(data.get("cattleType"));
//		registerCattleCalfPage.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleCalfPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
//		
		registerCattleCalfPage.enter_weight(data.get("weight"));
		registerCattleCalfPage.press_SaveButton();
		
		registerCattleSuccessPage.captureScreenshots("RegisterCalf");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
		registerCattleSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		helperFunctions.submitData();
		
	}
	
	
//	//@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterCattle_CalfLocalisation(Map<String,String> data) throws Exception {
//		
//		GenerateData dat = new GenerateData();
//		
//		String username = prop.getProperty("ServiceProviderUsername");
//		String password = prop.getProperty("ServiceProviderPassword"); 
//		
//		String tagNumber = dat.generateRandomNumber(7);
//		String cooptagNumber = dat.generateRandomNumber(12);
//		
//		Login login = new Login();
//		login.userLogin(username, password);
//		
//		SP_HomePage sp = new SP_HomePage();
//		sp.pressRegisterCattleButton();
//		
//		//Search for farm
//		RegisterCattle_SearchFarmPage farmSearch = new RegisterCattle_SearchFarmPage();
//		Excel_Localisation excel= new Excel_Localisation();
//		JSONObject status = excel.ExcelCompare(farmSearch.getPage(), farmSearch.getClass().toString());
//		System.out.println(status);
//		String phone = prop.getProperty("FarmerPhone");
//		farmSearch.enterPhoneNumber(phone);
//		farmSearch.pressSearchButton();
//		farmSearch.select_farm(phone);
//		
//		RegisterCattle_CattleTypePage type = new RegisterCattle_CattleTypePage();
//		status = excel.ExcelCompare(type.getPage(), type.getClass().toString());
//		System.out.println(status);
//		type.findElement("વાછરડું");
//		Thread.sleep(2000);
//		
//		RegisterCattle_CalfPage reg = new RegisterCattle_CalfPage();
//		reg.click_crossbreedToggle();
//		status = excel.ExcelCompare(reg.getPage(), reg.getClass().toString());
//		System.out.println(status);
//		reg.assert_Phone_Number(phone);
//		reg.enter_TagNumber(tagNumber);
//		reg.enter_CoopTagNumber(cooptagNumber);
//		reg.select_YOB(data.get("yearOfBirth"));
//		reg.select_month(data.get("monthOfBirth"));
//		reg.click_crossbreedToggle();
//		reg.enter_weight(data.get("weight"));
//		reg.press_SaveButton();
//
//		
//		RegisterCattle_SuccessPage success = new RegisterCattle_SuccessPage();
//		status = excel.ExcelCompare(success.getPage(), success.getClass().toString());
//		System.out.println(status);
//		
//		
//		RegisterCattle_SubmitDataPage submit = new RegisterCattle_SubmitDataPage();
//		submit.pressSubmitButton();
//		submit.pressSubmitButton();
//		
//		SubmitData_EnterOTPPage otp = new SubmitData_EnterOTPPage();
//		otp.enter_otp("1111");			
//		otp.pressContinueBtn();
//		
//		SubmitData_SuccessPage successMsg = new SubmitData_SuccessPage();
//		successMsg.assert_cattleCount(1);
//		successMsg.assert_successMsg();
//		successMsg.assert_totalRequest("1");
//		successMsg.assert_requestSubmitted("1");
//	}
//



}
