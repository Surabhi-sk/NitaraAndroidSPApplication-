package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class ViewInsemination extends GenericBase{


	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Insemination_AddData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		
		helper.goTo_AddBreedingActivityScreenFromCattleProfile(coopTag,"artificialInsemination");

		/** Fill AI form */
		addAIPage.enter_BullId(data.get("bullId"));
		addAIPage.enter_InseminationDate(data.get("inseminationDate"));
		addAIPage.press_SaveButton();

		/** Assert success page */
		breedingSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		helperFunctions.submitData();

		helper.goTo_BreedingTimeline(coopTag);
		breedingTimelinePage.captureScreenshots("ViewInsemination");
		breedingTimelinePage.verify_Insemination(data.get("type"),data.get("inseminationDate"));
	}

}
