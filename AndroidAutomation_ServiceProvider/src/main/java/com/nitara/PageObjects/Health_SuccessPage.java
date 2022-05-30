package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_SuccessPage extends BasePage{

	@AndroidFindBy(id = "successMessage") 
	private MobileElement success_msg;
	
	@AndroidFindBy(id = "submit_btn") 
	private MobileElement submit_btn;
	
	public void assertSuccessMsg(String msg) {
		waitVisibility(success_msg);
		Assert.assertEquals(success_msg.getText(),msg);
	} 
	
	public void pressSubmitButton() {
		waitVisibility(submit_btn);
		click(submit_btn);
	}
	
	

}
