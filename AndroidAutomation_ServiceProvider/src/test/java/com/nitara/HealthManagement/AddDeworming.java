package com.nitara.HealthManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class AddDeworming extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Deworming_AddData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

	
		helper.goTo_AddHealthActivityScreenFromBasicCP(coopTag,"Deworming");

		
		// Add Deworming
		addDewormingPage.select_dewormer(data.get("dewormer"));
		addDewormingPage.enter_Amount(data.get("amount"));
		addDewormingPage.click_Save();
		
		healthRecordSuccessPage.captureScreenshots("AddDeworming");
		healthRecordSuccessPage.assertSuccessMsg("Deworming has been recorded successfully for");
		healthRecordSuccessPage.pressSubmitButton();


		/** Submit data and assert success message */
		helperFunctions.submitData();

	}
}
