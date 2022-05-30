package com.nitara.HealthManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;


public class ViewTreatment extends GenericBase{

	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Treatment_ViewData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		
		helper.goTo_ViewHealthActivityScreenFromCattleProfile(coopTag, "Treatment");

		//** Add Treatment data from view treatment data page */
		viewTreatmentPage.select_AddTreatment();

		/** Fill Treatment Form */
		addTreatmentPage.fillTreatmentForm(data);
		
		
		/** Submit data and assert success message */
		helperFunctions.submitData();
		
		helper.goTo_ViewHealthActivityScreenFromCattleProfile(coopTag, "Treatment");

		/** View Treatment Data screen assert */
		viewTreatmentPage.captureScreenshots("ViewDeworming");
		viewTreatmentPage.assert_Treatment(data.get("disease"));
		viewTreatmentPage.select_viewMore();
		viewTreatmentPage.assert_TreatmentMedicines(data.get("medicine"));

	}

}
