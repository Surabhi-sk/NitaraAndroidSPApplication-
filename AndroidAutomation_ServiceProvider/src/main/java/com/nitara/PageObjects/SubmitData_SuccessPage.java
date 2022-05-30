package com.nitara.PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SubmitData_SuccessPage extends BasePage{

	@AndroidFindBy(id = "messageText") 
	private MobileElement message_txt;

	@AndroidFindBy(id = "cattleCount") 
	private MobileElement cattleCount;

	@AndroidFindBy(id = "totalRequestSubmittedValue") 
	private MobileElement totalRequest;


	@AndroidFindBy(id = "totalRequestSubmittedValue") 
	private MobileElement requestSubmitted;

	@AndroidFindBy(id = "totalRequestSubmittedValue") 
	private MobileElement requestFailed;

	@AndroidFindBy(id = "home") 
	private MobileElement home;


	public void assert_successMsg() {
		waitVisibility(message_txt);
		Assert.assertEquals(message_txt.getText(),"Activities Has Been Saved Successfully For");

	}


	public void assert_cattleCount(int count) {
		Assert.assertEquals(cattleCount.getText(), count+" Cattle");

	}

	public void assert_totalRequest(String count) {
		Assert.assertEquals(totalRequest.getText(),count);

	}

	public void assert_requestSubmitted(String count) {
		Assert.assertEquals(requestSubmitted.getText(),count);

	}
	
	public void goto_Homepage() {
		home.click();
	}


}
