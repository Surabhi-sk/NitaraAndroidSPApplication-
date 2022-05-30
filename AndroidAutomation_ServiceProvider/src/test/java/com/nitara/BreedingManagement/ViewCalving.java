package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class ViewCalving extends GenericBase{

		
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Calving_AddData(Map<String,String> data) throws Exception {

		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingCattle_Inseminated");

		
		//new HelperFunctions().Insemination_ForGivenDate(coopTag, new GenerateData().getPastDate(283));
		
		helper.goTo_AddBreedingActivityScreenFromCattleProfile(coopTag,"calving");
		
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
		breedingSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		new HelperFunctions().submitData();
		
		helper.goTo_BreedingTimeline(coopTag);
		breedingTimelinePage.captureScreenshots("ViewCalving");
		breedingTimelinePage.check_breedingStatus("Open");
	}

}
