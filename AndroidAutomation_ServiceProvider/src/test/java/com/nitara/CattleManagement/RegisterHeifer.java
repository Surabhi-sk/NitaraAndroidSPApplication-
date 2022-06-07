package com.nitara.CattleManagement;

import java.util.Map;

import org.testng.annotations.Test;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;

public class RegisterHeifer extends GenericBase {

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_HeiferCattle(Map<String, String> data) throws Exception {

		String tagNumber = generateRandomData.generateRandomNumber(7);
		String cooptagNumber = generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		// farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		// farmerHomePage.wait_load();
		farmerHomePage.click_RegisterCattleButton();
		System.out.println("Clicked");
		// farmerHomePage.clickskip_btn();

		/** Inseminated Heifer Register form */
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		 
		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		 
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		 
		 
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		 
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
		 

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			} else {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
		// Insemination
		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattleInseminated();
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}

			else{
				registerCattleInseminatedHeiferPage.isCattleInseminated();
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_PALess(Map<String, String> data) throws Exception {

		String tagNumber = generateRandomData.generateRandomNumber(7);
		String cooptagNumber = generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
//		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		System.out.println("Clicked");
		// farmerHomePage.clickskip_btn();

		/** Inseminated Heifer Register form */
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		 
		registerCattleInseminatedHeiferPage.assert_CattleType();
		String coop = data.get("cooptagNumber");
		if (coop.length() < 12) {
			// Error
		}
		 
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		 
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(coop);
		 
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		 
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		 
		 
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		 
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
		 

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			} else {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
		// Insemination
//		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
//			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}
//
//			else{
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
//			}
//		}
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_PAGreat(Map<String, String> data) throws Exception {

		String tagNumber = generateRandomData.generateRandomNumber(7);
		String cooptagNumber = generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
//		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		System.out.println("Clicked");
		// farmerHomePage.clickskip_btn();

		/** Inseminated Heifer Register form */
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		 
		registerCattleInseminatedHeiferPage.assert_CattleType();
		String coop = data.get("cooptagNumber");
		if (coop.length() > 12) {
			// Error
		}
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(coop);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		 
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		 
		 
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		 
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
		 

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			} else {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
		// Insemination
//		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
//			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}
//
//			else{
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
//			}
//		}
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_Tag(Map<String, String> data) throws Exception {

		String tagNumber = generateRandomData.generateRandomNumber(7);
		String cooptagNumber = generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		System.out.println("Clicked");
		// farmerHomePage.clickskip_btn();

		/** Inseminated Heifer Register form */
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		 
		registerCattleInseminatedHeiferPage.assert_CattleType();
		String tag = data.get("tagNumber");

		registerCattleInseminatedHeiferPage.enter_TagNumber(tag);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		 
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		 
		 
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		 
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
		 

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			} else {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
		// Insemination
//		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
//			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}
//
//			else{
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
//			}
//		}
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_CheckSameTag(Map<String, String> data) throws Exception {

		String tagNumber = generateRandomData.generateRandomNumber(7);
		String cooptagNumber = generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
//		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		System.out.println("Clicked");
		// farmerHomePage.clickskip_btn();

		/** Inseminated Heifer Register form */
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		 
		registerCattleInseminatedHeiferPage.assert_CattleType();
		String tag = "6266251";

		registerCattleInseminatedHeiferPage.enter_TagNumber(tag);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		 
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		 
		 
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		 
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
		 

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			} else {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
		// Insemination
//		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
//			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}
//
//			else{
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
//			}
//		}
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_Coop(Map<String, String> data) throws Exception {

		String tagNumber = generateRandomData.generateRandomNumber(7);
		String cooptagNumber = generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
//		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		System.out.println("Clicked");
		// farmerHomePage.clickskip_btn();

		/** Inseminated Heifer Register form */
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		 
		registerCattleInseminatedHeiferPage.assert_CattleType();
		String coop = data.get("cooptagNumber");
		if (coop.length() > 12) {
			// Error
		}
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(coop);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		 
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		 
		 
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		 
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
		 

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			} else {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
		// Insemination
//		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
//			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}
//
//			else{
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
//			}
//		}
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_TagCheck(Map<String, String> data) throws Exception {

		String tagNumber = generateRandomData.generateRandomNumber(7);
		String cooptagNumber = generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
//		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		System.out.println("Clicked");
		// farmerHomePage.clickskip_btn();

		/** Inseminated Heifer Register form */
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		 
		registerCattleInseminatedHeiferPage.assert_CattleType();
		String tag = data.get("tagNumber");

		registerCattleInseminatedHeiferPage.enter_TagNumber(tag);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		 
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		 
		 
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		 
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
		 

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			} else {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
		// Insemination
//		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
//			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}
//
//			else{
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
//			}
//		}
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BirthYear(Map<String, String> data) throws Exception {

		String tagNumber = generateRandomData.generateRandomNumber(7);
		String cooptagNumber = generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
//		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		System.out.println("Clicked");
		// farmerHomePage.clickskip_btn();

		/** Inseminated Heifer Register form */
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		 
		registerCattleInseminatedHeiferPage.assert_CattleType();
		String tag = data.get("tagNumber");

		registerCattleInseminatedHeiferPage.enter_TagNumber(tag);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		 
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		 
		 
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		 
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
		 

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			} else {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
		// Insemination
//		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
//			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}
//
//			else{
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
//			}
//		}
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_InseminationDate(Map<String, String> data) throws Exception {

		String tagNumber = generateRandomData.generateRandomNumber(7);
		String cooptagNumber = generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		System.out.println("Clicked");
		// farmerHomePage.clickskip_btn();

		/** Inseminated Heifer Register form */
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		 
		registerCattleInseminatedHeiferPage.assert_CattleType();

		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		 
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		 
		 
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		 
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
		 

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			} else {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
		// Insemination
		else if (data.get("isCattleInseminated").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattleInseminated();
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			}

			else {
				registerCattleInseminatedHeiferPage.isCattleInseminated();
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

		/*
		 * farmerHomePage.click_SearchCattleBtn();
		 * searchCattlePage.searchCattle(tagNumber);
		 */

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_Breeding(Map<String, String> data) throws Exception {

		String tagNumber = generateRandomData.generateRandomNumber(7);
		String cooptagNumber = generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
//		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		System.out.println("Clicked");
		// farmerHomePage.clickskip_btn();

		/** Inseminated Heifer Register form */
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		 
		registerCattleInseminatedHeiferPage.assert_CattleType();

		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		 
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		 
		 
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		 
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));


		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			} else {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
		// Insemination
		else if (data.get("isCattleInseminated").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattleInseminated();
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
						data.get("semenBrand"), data.get("bullId"));
			}

			else {
				registerCattleInseminatedHeiferPage.isCattleInseminated();
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
						data.get("bullId"));
			}
		}
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
		helper_AppNavigation.goTo_CattleProfileSelectActivity(tagNumber,"BREEDING");
		farmerHomePage.waitForPageLoad();

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_HeatEntry(Map<String, String> data) throws Exception {

		String tagNumber = generateRandomData.generateRandomNumber(7);
		String cooptagNumber = generateRandomData.generateRandomNumber(12);
		String dateOfBirth=data.get("yearOfBirth");
		
		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
//		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		System.out.println("Clicked");
		// farmerHomePage.clickskip_btn();

		/** Inseminated Heifer Register form */
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		registerCattleInseminatedHeiferPage.assert_CattleType();

		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(dateOfBirth);
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand"), data.get("bullId"));
			} else {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
		// Insemination
		else if (data.get("isCattleInseminated").equalsIgnoreCase("true")) {
			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattleInseminated();
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand"), data.get("bullId"));
			}

			else {
				registerCattleInseminatedHeiferPage.isCattleInseminated();
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
		helper_AppNavigation.goTo_CattleProfileSelectActivity(tagNumber,"BREEDING");
		farmerHomePage.waitForPageLoad();
	}

} // end of class
