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
		WarningPage.captureScreenshots("RegisterBull");
		WarningPage.assertWarningMsg("Name/Number should be only Alphabets or Numbers.");
	    
		
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
		
		/**Entering Already Registered TagNumber*/
		registerCattleBullPage.enter_TagNumber(data.get("tagNumber"));
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.press_SaveButton();
		
		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull");
		WarningPage.assertWarningMsg("Cattle with entered Name/Number exists. Please enter valid Name/Number.");
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
		WarningPage.captureScreenshots("RegisterBull");
		WarningPage.assertWarningMsg("Pashu Aadhar should only be Numeric.Please check and re-enter Pashu Aadhar.");

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
		WarningPage.captureScreenshots("RegisterBull");
		WarningPage.assertWarningMsg("Pashu Aadhar is not valid. Please check and re-enter valid 12-digit Pashu Aadhar Number.");
 
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
		WarningPage.captureScreenshots("RegisterBull");
		WarningPage.assertWarningMsg("Pashu Aadhar is not valid. Please check and re-enter valid 12-digit Pashu Aadhar Number.");

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
    	WarningPage.captureScreenshots("RegisterBull");
    	WarningPage.assertWarningMsg("Cattle Name/Number must be between 1-10 characters.");
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
		WarningPage.captureScreenshots("RegisterBull");
		WarningPage.assertWarningMsg("The field Year of Birth cannot be empty");
 
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
		WarningPage.captureScreenshots("RegisterBull");
		WarningPage.assertWarningMsg("Weight cannot be less than 15 kg. Please check weight and re-enter weight again.");
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
		WarningPage.captureScreenshots("RegisterBull");
		WarningPage.assertWarningMsg("Weight cannot be more than 2000 kg. Please check weight and re-enter weight again.");
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
		WarningPage.captureScreenshots("RegisterBull");
		WarningPage.assertWarningMsg("Animal cannot be under 6 months old to be a Bull. Please register animal as Calf.");
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
