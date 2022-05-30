package com.nitara.BreedingManagement;


import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper;
import appCommonClasses.HelperFunctions;

public class AddDryPeriod  extends GenericBase{


	@Test
	public void Dry_AddData() throws Exception {

		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		
		new Helper().goTo_AddBreedingActivityScreenFromBasicCP(coopTag,"dryPeriod");
		
		addDryPeriodPage.press_SaveButton();
		
		/** Assert success page */
		breedingSuccessPage.captureScreenshots("AddDryPeriod");
		breedingSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		new HelperFunctions().submitData();
	}
}
