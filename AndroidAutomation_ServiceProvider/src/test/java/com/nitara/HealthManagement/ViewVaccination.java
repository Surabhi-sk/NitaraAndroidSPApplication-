package com.nitara.HealthManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;

public class ViewVaccination extends GenericBase{

	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Vaccination_ViewData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		helper.goTo_ViewHealthActivityScreenFromCattleProfile(coopTag, "Vaccination");


		//** Add Vaccination data from view treatment data page */
		viewVaccinationPage.click_addVaccination();


		// Add Vaccination
		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_dosage(data.get("dosage"));
		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.click_Save();


		healthRecordSuccessPage.assertSuccessMsg("Vaccination has been Recorded successfully for");
		healthRecordSuccessPage.pressSubmitButton();

		/** Submit data and assert success message */
		helperFunctions.submitData();

		helper.goTo_ViewHealthActivityScreenFromCattleProfile(coopTag, "Vaccination");

		/** View Vaccination Data screen assert */
		viewVaccinationPage.captureScreenshots("ViewVaccination");
		viewVaccinationPage.assert_Vaccine(data.get("vaccine"));
		viewVaccinationPage.select_viewMore();
		viewVaccinationPage.assert_vaccineDate(new GenerateData().getPastDate(00));


	}

}
