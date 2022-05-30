package com.nitara.HealthManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class ViewDeworming extends GenericBase{

	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Deworming_ViewData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		
		helper.goTo_ViewHealthActivityScreenFromCattleProfile(coopTag, "Deworming");

		//** Add Deworming data from view treatment data page */
		viewDewormingPage.click_addDeworming();

		// Add Deworming
		addDewormingPage.select_dewormer(data.get("dewormer"));
		addDewormingPage.enter_Amount(data.get("amount"));
		addDewormingPage.click_Save();

		healthRecordSuccessPage.assertSuccessMsg("Deworming has been recorded successfully for");
		healthRecordSuccessPage.pressSubmitButton();


		/** Submit data and assert success message */
		helperFunctions.submitData();
		
		helper.goTo_ViewHealthActivityScreenFromCattleProfile(coopTag, "Deworming");
		
		viewDewormingPage.captureScreenshots("ViewDeworming");
		viewDewormingPage.assert_Dewormer(data.get("dewormer"));
		viewDewormingPage.select_viewMore();
		viewDewormingPage.assert_DewormerDate(new GenerateData().getPastDate(0));
	}
}
