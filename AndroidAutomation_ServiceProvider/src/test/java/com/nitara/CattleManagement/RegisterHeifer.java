package com.nitara.CattleManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;

public class RegisterHeifer extends GenericBase {

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_Heifer(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		// Inseminated Heifer Register form
		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.assert_Phone_Number(phone);
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB("2021");
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));

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

		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
		registerCattleSuccessPage.pressSubmitButton();

		/** Submit data and assert success message */
		helperFunctions.submitData();

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterHeifer_TagSpecialCharacter(Map<String, String> data) throws Exception {

		new Login().Login_ValidData();

		String tagNumber = data.get("tagNumber");
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));

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

		registerCattleInseminatedHeiferPage.press_SaveButton();

		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterHeifer_CheckSameTag(Map<String, String> data) throws Exception {

		new Login().Login_ValidData();

		String tagNumber = data.get("tagNumber");
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));

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

		registerCattleInseminatedHeiferPage.press_SaveButton();

		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterHeifer_CoopNonNumeric(Map<String, String> data) throws Exception {

		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = data.get("coop");
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));

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

		registerCattleInseminatedHeiferPage.press_SaveButton();

		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterHeifer_PALess(Map<String, String> data) throws Exception {

		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = data.get("coop");
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));

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

		registerCattleInseminatedHeiferPage.press_SaveButton();

		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterHeifer_PAGreat(Map<String, String> data) throws Exception {

		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = data.get("coop");
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));

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

		registerCattleInseminatedHeiferPage.press_SaveButton();

		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterHeifer_TagMandate(Map<String, String> data) throws Exception {

		new Login().Login_ValidData();

		String tagNumber = "";
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));

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

		registerCattleInseminatedHeiferPage.press_SaveButton();

		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterHeifer_BirthYear(Map<String, String> data) throws Exception {

		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB("");
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));

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

		registerCattleInseminatedHeiferPage.press_SaveButton();

		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterHeifer_InseminationDate(Map<String, String> data) throws Exception {

		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		registerCattleInseminatedHeiferPage.isCattleInseminated();
		registerCattleInseminatedHeiferPage.enter_InseminationDate(data.get("inseminationDate"));

		registerCattleInseminatedHeiferPage.press_SaveButton();

		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterHeifer_InseminationDateCheck(Map<String, String> data) throws Exception {

		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));

		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
					data.get("crossedWith"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		registerCattleInseminatedHeiferPage.isCattleInseminated();
		registerCattleInseminatedHeiferPage.enter_InseminationDate(data.get("inseminationDate"));

		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterHeifer_HeatEntry(Map<String, String> data) throws Exception {

		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));

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
		} else if (data.get("isCattleInseminated").equalsIgnoreCase("true")) {
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
		helper.goTo_BreedingTimeline(cooptagNumber);
		breedingTimelinePage.assert_HeatEntry();
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void RegisterHeifer_VerifyBreedingActivity(Map<String, String> data) throws Exception {

		new Login().Login_ValidData();

		String tagNumber = generateData.generateRandomNumber(7);
		String cooptagNumber = generateData.generateRandomNumber(12);
		searchFarmPage.waitForPageLoad();
		SPHomePage.pressRegisterCattleButton();

		// Search for farm
		String phone = prop.getProperty("FarmerPhone");
		searchFarmPage.enterPhoneNumber(phone);
		searchFarmPage.pressSearchButton();
		searchFarmPage.select_farm(phone);

		searchFarmPage.waitForPageLoad();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");

		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));

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

		registerCattleInseminatedHeiferPage.press_SaveButton();
		helper.goTo_BreedingTimeline(cooptagNumber);
		breedingTimelinePage.assert_HeatEntry();
	}

}