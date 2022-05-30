package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_SuccessPage extends BasePage{

	@AndroidFindBy(id = "submit_btn") 
	private MobileElement submit_btn;
	
	@AndroidFindBy(id = "submissionStatus") //com.nitara.serviceprovider:id/submissionStatus
	private MobileElement submissionStatus;
	
	@AndroidFindBy(id = "home") 
	private MobileElement home;
	
	public void pressSubmitButton() {
		waitVisibility(submit_btn);
		click(submit_btn);
	}
	
	public void assertSubmissionStatus(String status) {
		Assert.assertEquals(submissionStatus.getText(),status);
	}
	
	public void homeButton() {
		click(home);
	}
	

}
