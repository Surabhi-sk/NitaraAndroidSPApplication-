package com.nitara.HealthManagement;

import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;

public class FollowUp extends GenericBase{

	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void FollowUp_AddData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		
		helper.goTo_AddHealthActivityScreenFromBasicCP(coopTag,"Treatment");
		
		/** Fill Treatment Form */
		addTreatmentPage.fillTreatmentForm(data);
		
		/** Submit treatment data and assert success message */
		helperFunctions.submitData();
		submitDataSuccessPage.goto_Homepage();
		
		helper.goTo_AddHealthActivityScreenFromBasicCP(coopTag,"Follow up");
		
		/** Select treatment options */
		followUpOptionsPage.select_treatment();

		/** Fill FollowUp form */
		if(data.get("FUpIsCured").equalsIgnoreCase("true")) {
			addFollowUpPage.select_isCuredToggle(data.get("FUpIsCured"));}
		if(data.get("FUpIsFollowupRequired").equalsIgnoreCase("true")) {
			addFollowUpPage.select_followUpToggle(data.get("FUpIsFollowupRequired"), data.get("FUpFollowupAfter"));}
		addFollowUpPage.enter_date(new GenerateData().getPastDate(15));
		addFollowUpPage.click_save();

		/* Assert success message */
		healthRecordSuccessPage.captureScreenshots("AddFollowUp");
		healthRecordSuccessPage.assertSuccessMsg("Follow up has been Recorded successfully for");
		healthRecordSuccessPage.pressSubmitButton();

		/** Submit data and assert success message */
		helperFunctions.submitData();

	}


	
}
