package com.nitara.HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;

public class AddVaccination extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Vaccination_AddData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		
		helper.goTo_AddHealthActivityScreenFromBasicCP(coopTag,"Vaccination");


		/** Fill vaccination form  */
		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_dosage(data.get("dosage"));
		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.click_Save();

		healthRecordSuccessPage.captureScreenshots("AddVaccination");
		healthRecordSuccessPage.assertSuccessMsg("Vaccination has been Recorded successfully for");
		healthRecordSuccessPage.pressSubmitButton();

		/** Submit data and assert success message */
		helperFunctions.submitData();
	}
}
