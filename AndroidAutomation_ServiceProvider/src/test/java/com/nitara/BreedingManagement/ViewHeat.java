package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;


public class ViewHeat extends GenericBase{


	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Heat_ViewData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		
		helper.goTo_AddBreedingActivityScreenFromCattleProfile(coopTag,"Heat");
		
		//Add Heat data
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(new GenerateData().getPastDate(10));
		addHeatPage.press_SaveButton();

		/** Assert success page */
		breedingSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		helperFunctions.submitData();
		
		helper.goTo_BreedingTimeline(coopTag);
		breedingTimelinePage.captureScreenshots("ViewHeat");
		breedingTimelinePage.check_breedingStatus("Open");
		breedingTimelinePage.checkDateLeft(new GenerateData().getPastDate(10));
		breedingTimelinePage.check_HeatType(data.get("heatType"));}

}
