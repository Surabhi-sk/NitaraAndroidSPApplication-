package com.nitara.CattleManagement;


import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class RegisterMilkingorDryCattle extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_MilkingorDryCattle(Map<String,String> data) throws InterruptedException, Exception {
		
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
		
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");

		registerMilkingCattlePage.assert_CattleType();
		registerMilkingCattlePage.assert_Phone_Number(phone);
		registerMilkingCattlePage.enter_TagNumber(tagNumber);
		registerMilkingCattlePage.enter_CoopTagNumber(cooptagNumber);

		registerMilkingCattlePage.select_Lactation(data.get("currentLactation"));
		registerMilkingCattlePage.enter_Calvingdate(data.get("lastCalvingDate"));
		registerMilkingCattlePage.enter_CalfCount(data.get("calfCount"));
		registerMilkingCattlePage.enter_Calf1Gender(data.get("calf1Gender"));

		if(data.get("calfCount").equalsIgnoreCase("twins")) {
			registerMilkingCattlePage.enter_Calf2Gender(data.get("calf2Gender"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if(data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerMilkingCattlePage.isCattlePregnant(data.get("pregnantSince"));
				registerMilkingCattlePage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));
			}
			else{
				registerMilkingCattlePage.isCattlePregnant(data.get("pregnantSince"));
				registerMilkingCattlePage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural Insemination
		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerMilkingCattlePage.isCattleInseminated();
				registerMilkingCattlePage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}

			else{
				registerMilkingCattlePage.isCattleInseminated();
				registerMilkingCattlePage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}
		

		registerMilkingCattlePage.press_SaveButton();
		
		registerCattleSuccessPage.captureScreenshots("RegisterMilch");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
		registerCattleSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		helperFunctions.submitData();
		
		
	}

}
