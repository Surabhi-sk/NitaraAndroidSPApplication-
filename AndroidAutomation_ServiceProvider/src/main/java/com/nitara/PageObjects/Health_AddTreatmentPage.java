package com.nitara.PageObjects;


import java.util.List;
import java.util.Map;

import com.nitara.Helper.GenerateData;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_AddTreatmentPage extends BasePage{

	@AndroidFindBy(id = "location") 
	private MobileElement phone_number;

	@AndroidFindBy(id = "enterSymptomsTv") 
	private MobileElement enterSymptoms;

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*diseaseSpinner.*\"))") 
	private MobileElement disease_dropdown;

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*addMedicineTv.*\"))") 
	private MobileElement addMedicine;

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*medicine.*\"))")  
	private MobileElement medicine_name;

	@AndroidFindBy(id = "dosage") 
	private MobileElement medicine_dosage;

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*antibioticsToggle.*\"))") 
	private MobileElement antibiotics_toggle;

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*followUpToggle.*\"))")  
	private MobileElement followUp_toggle;
	
	@AndroidFindBy(id = "follow_up_after")
	private MobileElement follow_up_after;

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*amountValue.*\"))")  
	private MobileElement amountValue;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*saveTreatmentDataBtn.*\"))") 
	private MobileElement saveTreatment_btn;

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*dateValue.*\"))") 
	private MobileElement dateValue;



	public void select_disease(String name) {
		click(disease_dropdown);
		List<MobileElement> diseaseList = (List<MobileElement>) driver.findElementsById("android:id/text1");
		for(int i=0;i<diseaseList.size()-1 ;i++ ) {
			if(diseaseList.get(i).getText().equalsIgnoreCase(name)) {
				diseaseList.get(i).click();
				break;
			}
		}

	}


	public void antibioticsGiven() {
		String checked = antibiotics_toggle.getAttribute("checked");
		if(checked.equals("false")) {
			antibiotics_toggle.click();	
		}
	}

	public void click_symptomsPage() {
		waitForPageLoad();
		click(enterSymptoms);
	}

	public void click_addMedicine() {
		click(addMedicine);
	}

	public void enter_medicineName(String med) {
		sendKeys(medicine_name, med);
	}

	public void enter_medicineDosage(String dose) {
		sendKeys(medicine_dosage, dose);

	}

	public void followUpRequired() {
		String checked = followUp_toggle.getAttribute("checked");
		if(checked.equals("false")) {
			followUp_toggle.click();	
		}

	}

	public void enter_followUpAfter(String days) {
		sendKeys(follow_up_after,days);

	}

	public void enter_amount(String amount) {
		sendKeys(amountValue,amount);

	}

	public void enter_date(String date) {
		dateValue.clear();
		sendKeys(dateValue,date);

	}

	public void click_save() {
		waitVisibility(saveTreatment_btn);
		click(saveTreatment_btn);

	}

	public void fillTreatmentForm(Map<String,String> data)
	{
		click_symptomsPage(); // Select symptoms

		//Select Symptoms
		new Health_TreatmentSymptomsPage().addSymptoms(data);

		// Select disease
		select_disease(data.get("disease"));

		// Add Medicine - dosage
		click_addMedicine(); 
		enter_medicineName(data.get("medicine"));
		enter_medicineDosage(data.get("dosage"));

		if(data.get("isAntibioticGiven").equalsIgnoreCase("true"))
			antibioticsGiven();

		if(data.get("isFollowUpRequired").equalsIgnoreCase("true")) {
			followUpRequired();
			enter_followUpAfter(data.get("followUpAfter"));
		}
		enter_amount(data.get("amount"));
		enter_date(new GenerateData().getPastDate(15));
		click_save();
		new Health_SuccessPage().pressSubmitButton();
	}


}
