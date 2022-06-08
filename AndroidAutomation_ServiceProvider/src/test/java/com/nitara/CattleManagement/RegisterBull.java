package com.nitara.CattleManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class RegisterBull extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_Bull(Map<String,String> data) throws Exception {


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
		searchFarmPage.waitForPageLoadBar();

		cattleTypePage.select_cattleType("BULL");

		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.assert_Phone_Number(phone);
		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.select_month(data.get("monthOfBirth"));

		registerCattleBullPage.enter_weight(data.get("weight"));
		registerCattleBullPage.press_SaveButton();

		registerCattleSuccessPage.captureScreenshots("RegisterBull");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
		registerCattleSuccessPage.pressSubmitButton();

		/** Submit data and assert success message */
		helperFunctions.submitData();

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullTagNumberAccceptsSpecialCharacters(Map<String,String> data) throws Exception{

		/**Login **/
		new Login().Login_ValidData();

		SPHomePage.pressRegisterCattleButton();

		//Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();

		cattleTypePage.select_cattleType("BULL");

		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.assert_Phone_Number(phone);
		registerCattleBullPage.enter_TagNumber(data.get("tagNumber"));


		/**Entering TagNumber with special characters*/
		registerCattleBullPage.enter_TagNumber(data.get("tagNumber"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull Tag with special characters");
		WarningPage.assertWarningMsg(data.get("warningMessage"));


	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullSameEarTag(Map<String,String> data) throws Exception{

		/**Login **/
		new Login().Login_ValidData();

		SPHomePage.pressRegisterCattleButton();

		//Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();

		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();

		/**Registering Bull with a certain Tag Number*/
		String tagNumber = generateData.generateRandomNumber(7);

		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.select_month(data.get("monthOfBirth"));
		registerCattleBullPage.enter_weight(data.get("weight"));
		registerCattleBullPage.press_SaveButton();

		/**Registering another Bull with same tag Number*/
		registerCattleSuccessPage.pressRecordAnotherCattleBtn();

		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();

		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull with same eartag");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullCoopTagNumberAcceptsNonNumericValue(Map<String,String> data) throws Exception{

		/**Login **/
		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);

		SPHomePage.pressRegisterCattleButton();

		//Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();

		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);

		/**Entering CoopTagNumber having non numeric values*/
		registerCattleBullPage.enter_CoopTagNumber(data.get("cooptagNumber"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull with non numeric cooptagNumber");
		WarningPage.assertWarningMsg(data.get("warningMessage"));

	}


	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullPashuAadharLesserThan12Digits(Map<String,String> data) throws Exception{

		/**Login **/
		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);

		SPHomePage.pressRegisterCattleButton();

		//Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();

		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);

		/**Entering CoopTagNumber having non numeric values*/
		registerCattleBullPage.enter_CoopTagNumber(data.get("cooptagNumber"));
		registerCattleBullPage.press_SaveButton();
		Thread.sleep(3000);

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull with Pashu aadhar less than 12 digits");
		WarningPage.assertWarningMsg(data.get("warningMessage"));WarningPage.assertWarningMsg(data.get("warningMessage"));

	}


	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullPashuAadharMoreThan12Digits(Map<String,String> data) throws Exception{

		/**Login **/
		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);

		SPHomePage.pressRegisterCattleButton();

		//Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();

		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);

		/**Entering CoopTagNumber having non numeric values*/
		registerCattleBullPage.enter_CoopTagNumber(data.get("cooptagNumber"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull with pashu aadhar more than 12 digits");
		WarningPage.assertWarningMsg(data.get("warningMessage"));

	}


	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullCattleTagMandatory(Map<String,String> data) throws Exception{
		/**Login **/
		new Login().Login_ValidData();

		SPHomePage.pressRegisterCattleButton();

		//Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();

		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull Cattle Tag Mandatory");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}


	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullYearOfBirthMandatory(Map<String,String> data) throws Exception{

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
		searchFarmPage.waitForPageLoadBar();

		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.enter_CoopTagNumber (cooptagNumber);
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull without year of birth");
		WarningPage.assertWarningMsg(data.get("warningMessage"));

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullMinimumWeight(Map<String,String> data) throws Exception{

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
		searchFarmPage.waitForPageLoadBar();

		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.enter_CoopTagNumber (cooptagNumber);
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.select_month(data.get("monthOfBirth"));
		registerCattleBullPage.select_cattleType(data.get("cattleType"));
		registerCattleBullPage.select_cattleBreed(data.get("breed"));

		/**Entering weight of bull less than 15kgs*/
		registerCattleBullPage.enter_weight(data.get("weight"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull weight less than 15kg");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullMaximumWeight(Map<String,String> data) throws Exception{

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
		searchFarmPage.waitForPageLoadBar();

		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.enter_CoopTagNumber (cooptagNumber);
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.select_month(data.get("monthOfBirth"));
		registerCattleBullPage.select_cattleType(data.get("cattleType"));
		registerCattleBullPage.select_cattleBreed(data.get("breed"));

		/**Entering weight of bull more than 1000kgs*/
		registerCattleBullPage.enter_weight(data.get("weight"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull with weight more than 2000kg");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullUnder6Months(Map<String,String> data) throws Exception{

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
		searchFarmPage.waitForPageLoadBar();

		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.enter_CoopTagNumber (cooptagNumber);
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.select_month(data.get("monthOfBirth"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull under 6 months");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

//	//@Test
//	public void registerBull_Localisation() throws Exception {
//
//		GenerateData data = new GenerateData();
//
//		String username = prop.getProperty("ServiceProviderUsername");
//		String password = prop.getProperty("ServiceProviderPassword");
//
//		String tagNumber = data.generateRandomNumber(7);
//		String cooptagNumber = data.generateRandomNumber(12);
//
//		/*Login login = new Login();
//		login.userLogin(username, password);*/
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
//		type.findElement("આખલો");
//		Thread.sleep(2000);
//
//		RegisterCattle_BullPage reg = new RegisterCattle_BullPage();
//		status = excel.ExcelCompare(reg.getPage(), reg.getClass().toString());
//		System.out.println(status);
//		reg.assert_Phone_Number(phone);
//		reg.enter_TagNumber(tagNumber);
//		reg.enter_CoopTagNumber(cooptagNumber);
//		reg.select_YOB("2018");
//		reg.select_month("JANUARY");
//		reg.enter_weight("250");
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
//	}


}
