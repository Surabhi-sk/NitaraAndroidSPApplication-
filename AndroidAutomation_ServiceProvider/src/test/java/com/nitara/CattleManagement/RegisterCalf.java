package com.nitara.CattleManagement;

import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.nitara.AccountManagement.Login;
import com.nitara.Helper.Excel_Localisation;
import com.nitara.PageObjects.RegisterCattle_CalfPage;
import com.nitara.PageObjects.RegisterCattle_CattleTypePage;
import com.nitara.PageObjects.RegisterCattle_SearchFarmPage;
import com.nitara.PageObjects.RegisterCattle_SubmitDataPage;
import com.nitara.PageObjects.RegisterCattle_SuccessPage;
import com.nitara.PageObjects.SubmitData_EnterOTPPage;
import com.nitara.PageObjects.SubmitData_SuccessPage;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class RegisterCalf extends GenericBase {

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCalf_Valid(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoad();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoad();
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

//	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterCalf_Localisation(Map<String,String> data) throws Exception {
//				
//		String tagNumber = generateData.generateRandomNumber(7);
//		String cooptagNumber = generateData.generateRandomNumber(12);
//		
//		new Login().Login_ValidData();
//		
//		SPHomePage.pressRegisterCattleButton();
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

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCalf_TagSpecialCharacter(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		String tagNumber = data.get("tagNumber");
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoad();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("CALF");

		// Calf Register form
		registerCattleCalfPage.assert_CattleType();
		registerCattleCalfPage.assert_Phone_Number(phone);
		registerCattleCalfPage.enter_TagNumber(tagNumber);
		registerCattleCalfPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleCalfPage.select_YOB(data.get("yearOfBirth"));
		registerCattleCalfPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));
//		registerCattleCalfPage.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleCalfPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
//		
		registerCattleCalfPage.enter_weight(data.get("weight"));
		registerCattleCalfPage.press_SaveButton();
		registerCattleCalfPage.assertWarning(data.get("warningMessage"));

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCalf_CoopNonNumeric(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = data.get("coop");
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoad();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("CALF");

		// Calf Register form
		registerCattleCalfPage.assert_CattleType();
		registerCattleCalfPage.assert_Phone_Number(phone);
		registerCattleCalfPage.enter_TagNumber(tagNumber);
		registerCattleCalfPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleCalfPage.select_YOB(data.get("yearOfBirth"));
		registerCattleCalfPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));
//		registerCattleCalfPage.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleCalfPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
//		
		registerCattleCalfPage.enter_weight(data.get("weight"));
		registerCattleCalfPage.press_SaveButton();
		registerCattleCalfPage.assertWarning(data.get("warningMessage"));

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCalf_PALessThan12(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = data.get("coop");
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoad();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("CALF");

		// Calf Register form
		registerCattleCalfPage.assert_CattleType();
		registerCattleCalfPage.assert_Phone_Number(phone);
		registerCattleCalfPage.enter_TagNumber(tagNumber);
		registerCattleCalfPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleCalfPage.select_YOB(data.get("yearOfBirth"));
		registerCattleCalfPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));
//		registerCattleCalfPage.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleCalfPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
//		
		registerCattleCalfPage.enter_weight(data.get("weight"));
		registerCattleCalfPage.press_SaveButton();
		registerCattleCalfPage.assertWarning(data.get("warningMessage"));

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCalf_PAMoreThan12(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = data.get("coop");
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoad();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("CALF");

		// Calf Register form
		registerCattleCalfPage.assert_CattleType();
		registerCattleCalfPage.assert_Phone_Number(phone);
		registerCattleCalfPage.enter_TagNumber(tagNumber);
		registerCattleCalfPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleCalfPage.select_YOB(data.get("yearOfBirth"));
		registerCattleCalfPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));
//		registerCattleCalfPage.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleCalfPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
//		
		registerCattleCalfPage.enter_weight(data.get("weight"));
		registerCattleCalfPage.press_SaveButton();
		registerCattleCalfPage.assertWarning(data.get("warningMessage"));

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCalf_MinWeight(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoad();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("CALF");

		// Calf Register form
		registerCattleCalfPage.assert_CattleType();
		registerCattleCalfPage.assert_Phone_Number(phone);
		registerCattleCalfPage.enter_TagNumber(tagNumber);
		registerCattleCalfPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleCalfPage.select_YOB(data.get("yearOfBirth"));
		registerCattleCalfPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));
//		registerCattleCalfPage.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleCalfPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
//		
		registerCattleCalfPage.enter_weight(data.get("weight"));
		registerCattleCalfPage.press_SaveButton();

		registerCattleCalfPage.assertWarning(data.get("warningMessage"));

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCalf_MaxWeight(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoad();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("CALF");

		// Calf Register form
		registerCattleCalfPage.assert_CattleType();
		registerCattleCalfPage.assert_Phone_Number(phone);
		registerCattleCalfPage.enter_TagNumber(tagNumber);
		registerCattleCalfPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleCalfPage.select_YOB(data.get("yearOfBirth"));
		registerCattleCalfPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));
//		registerCattleCalfPage.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleCalfPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
//		
		registerCattleCalfPage.enter_weight(data.get("weight"));
		registerCattleCalfPage.press_SaveButton();
		registerCattleCalfPage.assertWarning(data.get("warningMessage"));

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCalf_TagMandate(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		String tagNumber = "";
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoad();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("CALF");

		// Calf Register form
		registerCattleCalfPage.assert_CattleType();
		registerCattleCalfPage.assert_Phone_Number(phone);
		registerCattleCalfPage.enter_TagNumber(tagNumber);
		registerCattleCalfPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleCalfPage.select_YOB(data.get("yearOfBirth"));
		registerCattleCalfPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));
//		registerCattleCalfPage.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleCalfPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
//		
		registerCattleCalfPage.enter_weight(data.get("weight"));
		registerCattleCalfPage.press_SaveButton();
		registerCattleCalfPage.assertWarning(data.get("warningMessage"));

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCalf_YOBMandate(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoad();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("CALF");

		// Calf Register form
		registerCattleCalfPage.assert_CattleType();
		registerCattleCalfPage.assert_Phone_Number(phone);
		registerCattleCalfPage.enter_TagNumber(tagNumber);
		registerCattleCalfPage.enter_CoopTagNumber(cooptagNumber);
//		registerCattleCalfPage.select_YOB(data.get("yearOfBirth"));
		registerCattleCalfPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));
//		registerCattleCalfPage.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleCalfPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
//		
		registerCattleCalfPage.enter_weight(data.get("weight"));
		registerCattleCalfPage.press_SaveButton();
		registerCattleCalfPage.assertWarning(data.get("warningMessage"));

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCalf_CheckSameTag(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		String tagNumber = data.get("tagNumber");
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoad();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("CALF");

		// Calf Register form
		registerCattleCalfPage.assert_CattleType();
		registerCattleCalfPage.assert_Phone_Number(phone);
		registerCattleCalfPage.enter_TagNumber(tagNumber);
		registerCattleCalfPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleCalfPage.select_YOB(data.get("yearOfBirth"));
		registerCattleCalfPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));
//		registerCattleCalfPage.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleCalfPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
//		
		registerCattleCalfPage.enter_weight(data.get("weight"));
		registerCattleCalfPage.press_SaveButton();
		registerCattleCalfPage.assertWarning(data.get("warningMessage"));

	}

}
