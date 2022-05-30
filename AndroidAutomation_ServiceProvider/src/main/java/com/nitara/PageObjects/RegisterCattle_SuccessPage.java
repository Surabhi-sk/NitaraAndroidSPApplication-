package com.nitara.PageObjects;

import org.json.JSONObject;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterCattle_SuccessPage extends BasePage{

	@AndroidFindBy(id = "cattleTag") 
	private MobileElement cattleTag;
	
	
	@AndroidFindBy(id = "textView34") 
	private MobileElement succes_msg;
	
	@AndroidFindBy(id = "submit_btn") 
	private MobileElement submit_btn;
	
	@AndroidFindBy(id = "submissionStatus") 
	private MobileElement submissionStatus;
	
	@AndroidFindBy(id = "home") 
	private MobileElement home_btn;
	
	@AndroidFindBy(id = "record_another_cattle") 
	private MobileElement record_another_cattle;

	public void assertCattleTag(String tag) {
		waitVisibility(cattleTag);
		Assert.assertEquals(cattleTag.getText(),tag);
	}
	
	public void assertSuccessMsg(String msg) {
		waitVisibility(succes_msg);
		Assert.assertEquals(succes_msg.getText(),msg);
	} 
	
	public void pressSubmitButton() {
		waitVisibility(submit_btn);
		click(submit_btn);
	}
	
	public void assertSubmissionStatus(String status) {
		Assert.assertEquals(submissionStatus.getText(),status);
	}

	public void goBackToHomePage() {
		// TODO Auto-generated method stub
		click(home_btn);		
		
	}
	
public JSONObject getPage() {
		
		JSONObject obj = new JSONObject();
		obj.put("Registration has been saved successfully for", succes_msg.getText());
		obj.put("record_another_cattle",record_another_cattle.getText());
		obj.put("submit",submit_btn.getText());
		System.out.println(obj);

		
		return obj;
    
	}


}
