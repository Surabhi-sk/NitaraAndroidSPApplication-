package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class AddInsemination  extends GenericBase{


	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Insemination_AddData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		helper.goTo_AddBreedingActivityScreenFromBasicCP(coopTag,"artificialInsemination");
		
		/** Fill AI form */
		addAIPage.waitForPageLoad();
		addAIPage.enter_BullId(data.get("bullId"));
		addAIPage.enter_InseminationDate(data.get("inseminationDate"));
		addAIPage.press_SaveButton();

		/** Assert success page */
		breedingSuccessPage.captureScreenshots("AddInsemination");
		breedingSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		new HelperFunctions().submitData();
	}
}