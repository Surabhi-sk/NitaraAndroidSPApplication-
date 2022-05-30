package com.nitara.BreedingManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class ViewDryPeriod extends GenericBase {

	@Test
	public void Dry_ViewData() throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		
		helper.goTo_AddBreedingActivityScreenFromCattleProfile(coopTag,"dryPeriod");

		addDryPeriodPage.press_SaveButton();

		/** Assert success page */
		breedingSuccessPage.pressSubmitButton();

		/** Submit data and assert success message */
		new HelperFunctions().submitData();

		helper.goTo_BreedingTimeline(coopTag);
		breedingTimelinePage.captureScreenshots("ViewDryPeriod");
		breedingTimelinePage.check_breedingStatus("Dry");

	}
}
