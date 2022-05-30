package com.nitara.HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class ViewFollowUp extends GenericBase{
	
	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void FollowUp_ViewData(Map<String,String> data) throws Exception {	
		
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
		
		helper.goTo_AddHealthActivityScreenFromBasicCP(coopTag,"Follow up");
		
		/** Select treatment options */
		followUpOptionsPage.select_treatment();
		addFollowUpPage.fillFolowUpForm(data);
		
		/** Submit data and assert success message */
		helperFunctions.submitData();
		
		/** Go to view Follow Up - select Treatment */
		helper.goTo_ViewHealthActivityScreenFromCattleProfile(coopTag, "Treatment");

		/** View Treatment screen - Assert details*/
		viewTreatmentPage.waitForPageLoad();	
		viewTreatmentPage.select_viewMore();
//		viewTreatmentPage.assert_FollowUpMedicines(data.get("medicine")); 
//		viewTreatmentPage.assert_FollowUpDosage(data.get("FUpdosage"));
		viewTreatmentPage.assert_IsCured(data.get("FUpIsCured"));

	}


}
