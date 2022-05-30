package com.nitara.CattleManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;


public class RegisterHeifer extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_Heifer(Map<String,String> data) throws Exception {
		
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
		
		
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");


		// Inseminated Heifer Register form
		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.assert_Phone_Number(phone);
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB("2021");
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));

		// Check cattle Pregnant - Artificial or Natural Insemination
		if(data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));
			}
			else{
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural Insemination
		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattleInseminated();
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand"),data.get("bullId"));}

			else{
				registerCattleInseminatedHeiferPage.isCattleInseminated();
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

		registerCattleInseminatedHeiferPage.press_SaveButton();

		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
		registerCattleSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		helperFunctions.submitData();

	}
}