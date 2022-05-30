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
