package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class AddHeat extends GenericBase {

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void Heat_AddData(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url, "RegisterMilkingOrDryCattle");

		helper.goTo_AddBreedingActivityScreenFromBasicCP(coopTag, "heat");

		// Add Heat data
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(new GenerateData().getPastDate(10));
		addHeatPage.press_SaveButton();

		/** Assert success page */
		breedingSuccessPage.captureScreenshots("AddHeat");
		breedingSuccessPage.pressSubmitButton();

		/** Submit data and assert success message */
		new HelperFunctions().submitData();
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void AddHeat_ArtificalHeat(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url, "RegisterMilkingOrDryCattle");

		helper.goTo_AddBreedingActivityScreenFromBasicCP(coopTag, "heat");

		// Add Heat data
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(new GenerateData().getPastDate(10));
		addHeatPage.press_SaveButton();

		/** Assert success page */
		breedingSuccessPage.captureScreenshots("AddHeat");
		breedingSuccessPage.pressSubmitButton();

		/** Submit data and assert success message */
		new HelperFunctions().submitData();
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void AddHeat_NaturalHeat(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url, "RegisterMilkingOrDryCattle");

		helper.goTo_AddBreedingActivityScreenFromBasicCP(coopTag, "heat");

		// Add Heat data
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(new GenerateData().getPastDate(10));
		addHeatPage.press_SaveButton();

		/** Assert success page */
		breedingSuccessPage.captureScreenshots("AddHeat");
		breedingSuccessPage.pressSubmitButton();

		/** Submit data and assert success message */
		new HelperFunctions().submitData();
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void AddHeat_MinimumGapOf14Days(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url, "AddHeat_MinimumGapOf14Days");
		
		helper.goTo_AddBreedingActivityScreenFromBasicCP(coopTag, "heat");

		// Add Heat data
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate("15 Jan 2021");
		addHeatPage.press_SaveButton();
		
		breedingSuccessPage.homeButton();
		helper.goTo_AddBreedingActivityScreenFromBasicCP(coopTag, "heat");
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate("16 Jan 2021");
		addHeatPage.press_SaveButton();
		addHeatPage.assertWarning(data.get("warningMessage"));

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void AddHeat_15DaysAfterLastCalvingDate(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url, "AddHeat_15DaysAfterLastCalvingDate");

		helper.goTo_AddBreedingActivityScreenFromBasicCP(coopTag, "heat");

		// Add Heat data
		addHeatPage.select_HeatType(data.get("heatType"));
//		addHeatPage.enter_HeatDate(new GenerateData().getPastDate(10));
		addHeatPage.enter_HeatDate("15 Jan 2021");
		addHeatPage.press_SaveButton();
		addHeatPage.assertWarning(data.get("warningMessage"));

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void AddHeat_AgeLessThan9(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url, "AddHeat_AgeLessThan9");

		helper.goTo_AddBreedingActivityScreenFromBasicCP(coopTag, "heat");

		// Add Heat data
		addHeatPage.select_HeatType(data.get("heatType"));
//		addHeatPage.enter_HeatDate(new GenerateData().getPastDate(10));
		addHeatPage.enter_HeatDate("15 Jul 2019");
		addHeatPage.press_SaveButton();
		addHeatPage.assertWarning(data.get("warningMessage"));

	}
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void AddHeat_ToPregnantCattle(Map<String, String> data) throws Exception {

		/** Login **/
		new Login().Login_ValidData();

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url, "AddHeat_ToPregnantCattle");

		helper.goTo_AddBreedingActivityScreenFromBasicCP(coopTag, "heat");

		// Add Heat data
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(new GenerateData().getPastDate(10));
		addHeatPage.press_SaveButton();
		addHeatPage.assertWarning(data.get("warningMessage"));

	}
}
