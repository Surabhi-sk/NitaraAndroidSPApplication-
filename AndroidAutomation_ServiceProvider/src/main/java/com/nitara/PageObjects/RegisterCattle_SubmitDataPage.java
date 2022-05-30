package com.nitara.PageObjects;

import org.json.JSONObject;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterCattle_SubmitDataPage extends BasePage{

	@AndroidFindBy(id = "submit_btn") 
	private MobileElement submit_btn;
	
	@AndroidFindBy(id = "submissionStatus") 
	private MobileElement submissionStatus;
	
public JSONObject getPage() {
		
		JSONObject obj = new JSONObject();
		obj.put("submit_btn",submit_btn.getText());
		obj.put("Offline_submission_successful",submissionStatus.getText());
		System.out.println(obj);

		
		return obj;
    
	}

public void pressSubmitButton() {
	waitVisibility(submit_btn);
	click(submit_btn);
}

public void assertSubmissionStatus(String status) {
	Assert.assertEquals(submissionStatus.getText(),status);
}


}
