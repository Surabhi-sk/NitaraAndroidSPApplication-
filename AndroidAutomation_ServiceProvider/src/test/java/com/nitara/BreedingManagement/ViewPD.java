package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;

public class ViewPD extends GenericBase{


	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void PD_ViewData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingCattle_Inseminated");


		/* Service Provider Home page - Enter Co-op tag in the search */

		//helperFunctions.Insemination_ForGivenDate(coopTag,new GenerateData().getPastDate(283));

		addAIPage.waitForPageLoad();
		helper.goTo_AddBreedingActivityScreenFromCattleProfile(coopTag,"pd");

		addPDPage.enter_PDdate(new GenerateData().getPastDate(30-21));
		addPDPage.select_isCattlePregnant(data.get("isCattlePregnant"));
		addPDPage.press_SaveButton();

		/** Assert success page */
		breedingSuccessPage.pressSubmitButton();

		/** Submit data and assert success message */
		helperFunctions.submitData();

		helper.goTo_BreedingTimeline(coopTag);
		breedingTimelinePage.captureScreenshots("ViewPD");
		breedingTimelinePage.check_breedingStatus("Open");
		breedingTimelinePage.verify_PD(data.get("isCattlePregnant"),new GenerateData().getPastDate(30-21));

	}

}
