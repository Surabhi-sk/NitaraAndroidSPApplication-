package com.nitara.HealthManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class Treatment  extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Treatment_AddData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		helper.goTo_AddHealthActivityScreenFromBasicCP(coopTag,"Treatment");

		/** Fill Treatment Form */
		addTreatmentPage.click_symptomsPage(); // Select symptoms

		//Select Symptoms
		int count =  Integer.valueOf(data.get("symptomsCount"));
		String[] symptomsList = new String[count];
		for(int i=0;i<count;i++) {
			symptomsList[i]= data.get("symptoms["+i+"]");
		}
		diseaseSymptoms.select_symptomsFromList(symptomsList);
		diseaseSymptoms.click_save();

		// Select disease
		addTreatmentPage.select_disease(data.get("disease"));

		// Add Medicine - dosage
		addTreatmentPage.click_addMedicine(); 
		addTreatmentPage.enter_medicineName(data.get("medicine"));
		addTreatmentPage.enter_medicineDosage(data.get("dosage"));

		if(data.get("isAntibioticGiven").equalsIgnoreCase("true"))
			addTreatmentPage.antibioticsGiven();

		if(data.get("isFollowUpRequired").equalsIgnoreCase("true")) {
			addTreatmentPage.followUpRequired();
			addTreatmentPage.enter_followUpAfter(data.get("followUpAfter"));
		}
		addTreatmentPage.enter_amount(data.get("amount"));
		addTreatmentPage.enter_date(new GenerateData().getPastDate(15));
		addTreatmentPage.click_save();

		healthRecordSuccessPage.captureScreenshots("AddTreatment");
		healthRecordSuccessPage.assertSuccessMsg("Treatment has been Recorded successfully for");
		healthRecordSuccessPage.pressSubmitButton();

		/** Submit data and assert success message */
		helperFunctions.submitData();



	}
}
