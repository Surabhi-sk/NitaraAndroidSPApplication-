package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper;
import appCommonClasses.HelperFunctions;

public class AddCalving extends GenericBase{


	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Calving_AddData(Map<String,String> data) throws Exception {

		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingCattle_Inseminated");

		//new HelperFunctions().Insemination_ForGivenDate(coopTag,new GenerateData().getPastDate(283));
		
		new Helper().goTo_AddBreedingActivityScreenFromBasicCP(coopTag,"calving");
		
		/** Fill Calving form */
		if(data.get("calfResult").equalsIgnoreCase("Single")) {
			addCalvingPage.select_CalfResultSingle(data.get("calfResult"),data.get("calfGender1"));
		}
		else {
			addCalvingPage.select_CalfResultTwins(data.get("calfResult"),data.get("calfGender1"),data.get("calfGender2"));
		}
		
		addCalvingPage.press_SaveButton();
		addCalvingPage.press_proceed();

		/** Assert success page */
		breedingSuccessPage.captureScreenshots("AddCalving");
		breedingSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		new HelperFunctions().submitData();
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddCalving_150DaysAfterInseminationDate(Map<String,String> data) throws Exception {

		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		new HelperFunctions().Insemination_ForGivenDate(coopTag,new GenerateData().getPastDate(151));
//		new HelperFunctions().PD_ForGivenDate(Tag, generateRandomData.getPastDate(151 - 21));
		new Helper().goTo_AddBreedingActivityScreenFromBasicCP(coopTag,"calving");
		
		/** Fill Calving form */
		if(data.get("calfResult").equalsIgnoreCase("Single")) {
			addCalvingPage.select_CalfResultSingle(data.get("calfResult"),data.get("calfGender1"));
		}
		else {
			addCalvingPage.select_CalfResultTwins(data.get("calfResult"),data.get("calfGender1"),data.get("calfGender2"));
		}
		addCalvingPage.enter_CalvingDate(new GenerateData().getPastDate(20));
		addCalvingPage.press_SaveButton();
		addCalvingPage.assertWarning(data.get("warningMessage"));
//
//		addCalvingPage.press_proceed();
//
//		/** Assert success page */
//		breedingSuccessPage.captureScreenshots("AddCalving");
//		breedingSuccessPage.pressSubmitButton();
//		
//		/** Submit data and assert success message */
//		new HelperFunctions().submitData();
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddCalving_NoPDActivity(Map<String,String> data) throws Exception {

		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		new HelperFunctions().Insemination_ForGivenDate(coopTag,new GenerateData().getPastDate(283));
		
		new Helper().goTo_AddBreedingActivityScreenFromBasicCP(coopTag,"calving");
		
		/** Fill Calving form */
		if(data.get("calfResult").equalsIgnoreCase("Single")) {
			addCalvingPage.select_CalfResultSingle(data.get("calfResult"),data.get("calfGender1"));
		}
		else {
			addCalvingPage.select_CalfResultTwins(data.get("calfResult"),data.get("calfGender1"),data.get("calfGender2"));
		}
		addCalvingPage.enter_CalvingDate(new GenerateData().getPastDate(20));
		addCalvingPage.press_SaveButton();
		addCalvingPage.assertWarning(data.get("warningMessage"));
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddCalving_NoInsemination(Map<String,String> data) throws Exception {

		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

//		new HelperFunctions().Insemination_ForGivenDate(coopTag,new GenerateData().getPastDate(283));
		
		new Helper().goTo_AddBreedingActivityScreenFromBasicCP(coopTag,"calving");
		addCalvingPage.assertWarning(data.get("warningMessage"));

	}
}
