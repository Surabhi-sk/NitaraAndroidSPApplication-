package com.nitara.WeightManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class ViewWeight extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Weight_ViewData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		
		helper.goTo_AddWeightScreenFromBasicCP(coopTag);
		
		/** Fill Weight Form */
		if(data.get("calculateBy").equalsIgnoreCase("girth")) {
			addWeightPage.waitForPageLoad();
			addWeightPage.enter_girth(data.get("girth"));
			addWeightPage.enter_length(data.get("length"));
			addWeightPage.assert_calculatedWeight(data.get("girth"),data.get("length"));
			addWeightPage.enter_weightDate(data.get("dateOfWeight"));
			addWeightPage.click_saveBtn();
		}
		else {
			addWeightPage.waitForPageLoad();
			addWeightPage.waitForPageLoad();
			addWeightPage.select_directWeightMethod();
			addWeightPage.enter_weight(data.get("weight"));
			addWeightPage.enter_weightDate(data.get("dateOfWeight"));
			addWeightPage.click_saveBtn();
		}

		weightSuccessPage.assert_successMsg();
		weightSuccessPage.assert_method(data.get("calculateBy").toUpperCase());
		weightSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		helperFunctions.submitData();

	}	

}
