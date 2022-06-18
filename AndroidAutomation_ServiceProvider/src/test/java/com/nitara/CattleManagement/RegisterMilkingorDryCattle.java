package com.nitara.CattleManagement;


import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class RegisterMilkingorDryCattle extends GenericBase{
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterMilkingorDryCattle_TagnumberAcceptsSpecialChars(Map<String,String> data) throws Exception{		
		
		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Enter Tag number with special chars and save */
		registerMilkingCattlePage.enter_TagNumber(data.get("tagNumber"));		
		registerMilkingCattlePage.press_SaveButton();	
		registerMilkingCattlePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterMilkingorDryCattle_DuplicateTagnumberAllowed(Map<String,String> data) throws Exception{	
		
		String calving_date = generateData.getPastDate(0);
		
		/** Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String Tag = helperFunctions.RegisterMilkingorDryCattle();
		
		/** Start Registering next cattle */
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Enter previously registered Tag number and calving date and save */
		registerMilkingCattlePage.enter_TagNumber(Tag);		
		registerMilkingCattlePage.enter_Calvingdate(calving_date);
		registerMilkingCattlePage.press_SaveButton();		
		registerMilkingCattlePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterMilkingorDryCattle_CoopTagnumberAcceptsNonnumericChars(Map<String,String> data) throws Exception{

		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Enter Tag number, Non-numeric Coop Tag Number and save  */
		registerMilkingCattlePage.enter_TagNumber(data.get("tagNumber"));	
		registerMilkingCattlePage.enter_CoopTagNumber(data.get("coopTagNumber"));
		registerMilkingCattlePage.press_SaveButton();		
		registerMilkingCattlePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterMilkingorDryCattle_CoopTagnumberAcceptsLessDigits(Map<String,String> data) throws Exception{

		String cooptagNumber =generateData.generateRandomNumber(11);
		
		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Enter Tag number, 11 digit Coop Tag Number and save  */
		registerMilkingCattlePage.enter_TagNumber(data.get("tagNumber"));	
		registerMilkingCattlePage.enter_CoopTagNumber(cooptagNumber);
		registerMilkingCattlePage.press_SaveButton();		
		registerMilkingCattlePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterMilkingorDryCattle_CoopTagnumberAcceptsMoreDigits(Map<String,String> data) throws Exception{
	
		String cooptagNumber =generateData.generateRandomNumber(13);
		
		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Enter Tag number, 13 digit Coop Tag Number and save  */
		registerMilkingCattlePage.enter_TagNumber(data.get("tagNumber"));	
		registerMilkingCattlePage.enter_CoopTagNumber(cooptagNumber);
		registerMilkingCattlePage.press_SaveButton();		
		registerMilkingCattlePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterMilkingorDryCattle_TagnumberMandate(Map<String,String> data) throws Exception{

		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Save without entering any field  */
		registerMilkingCattlePage.press_SaveButton();	
		//registerMilkingCattlePage.press_SuggestionPopup();
		registerMilkingCattlePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterMilkingorDryCattle_CalvingDateMandate(Map<String,String> data) throws Exception{
		
		String tagNumber =generateData.generateRandomNumber(7);

		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Enter Tag number and save  */
		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
		registerMilkingCattlePage.press_SaveButton();	
		registerMilkingCattlePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterMilkingorDryCattle_InseminationDateMandate(Map<String,String> data) throws Exception{

		String tagNumber =generateData.generateRandomNumber(7);
		String calving_date = generateData.getPastDate(0);

		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Enter Tag number and save  */
		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
		registerMilkingCattlePage.enter_Calvingdate(calving_date);
		registerMilkingCattlePage.isCattleInseminated();
		registerMilkingCattlePage.press_SaveButton();		
		registerMilkingCattlePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterMilkingorDryCattle_DryPeriodDateMandate(Map<String,String> data) throws Exception{

		String tagNumber =generateData.generateRandomNumber(7);
		String calving_date = generateData.getPastDate(0);

		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Enter Tag number and save  */
		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
		registerMilkingCattlePage.enter_Calvingdate(calving_date);
		registerMilkingCattlePage.cattleIsDry();
		registerMilkingCattlePage.press_SaveButton();		
		registerMilkingCattlePage.assertWarningMsg(data.get("warningMessage"));
		
	}

	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterMilkingorDryCattle_CalvingAndInseminationDateGap(Map<String,String> data) throws Exception{

		String tagNumber =generateData.generateRandomNumber(7);
		String insemination_date = generateData.getPastDate(0);
		String calving_date = generateData.getPastDate(14);

		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Enter Tag number and save  */
		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
		registerMilkingCattlePage.enter_Calvingdate(calving_date);
		registerMilkingCattlePage.isCattleInseminated();
		registerMilkingCattlePage.enter_InseminationDate(insemination_date);
		registerMilkingCattlePage.press_SaveButton();		
		registerMilkingCattlePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterMilkingorDryCattle_DryPeriodDateCannotBeBeforeCalvingDate(Map<String,String> data) throws Exception{

		String tagNumber =generateData.generateRandomNumber(7);
		String calving_date = generateData.getPastDate(0);
		String dry_period_date = generateData.getPastDate(1);

		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Enter Tag number and save  */
		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
		registerMilkingCattlePage.enter_Calvingdate(calving_date);
		registerMilkingCattlePage.cattleIsDry();
		registerMilkingCattlePage.enter_DryPeriodDate(dry_period_date);
		registerMilkingCattlePage.press_SaveButton();		
		registerMilkingCattlePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression")
	public void RegisterMilkingorDryCattle_DefaultHeatEntryAdded() throws Exception{

		String tagNumber =generateData.generateRandomNumber(7);
		String cooptagNumber =generateData.generateRandomNumber(12);
		String calving_date = generateData.getPastDate(30);
		String insemination_date = generateData.getPastDate(0);

		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		SPHomePage.pressRegisterCattleButton();
		
		/** Search for farm **/
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.waitForPageLoadBar();
		searchFarmPage.select_farm(phone);
		searchFarmPage.waitForPageLoadBar();
		
		/** Select Cattle Type page - Select Milking and Dry Cattle */
		cattleTypePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		
		/** Milking and Dry Cattle page - Enter Tag number and save  */
		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
		registerMilkingCattlePage.enter_CoopTagNumber(cooptagNumber);
		registerMilkingCattlePage.enter_Calvingdate(calving_date);
		registerMilkingCattlePage.isCattleInseminated();
		registerMilkingCattlePage.enter_InseminationDate(insemination_date);
		registerMilkingCattlePage.press_SaveButton();
		
		/** Go to the home page, search for cattle using cooptagnumber and then in breeding activity assert heat entry **/
		registerCattleSuccessPage.goBackToHomePage();
		helper.goTo_BreedingTimeline(cooptagNumber);
		breedingTimelinePage.assert_HeatEntry();
		
	}

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
