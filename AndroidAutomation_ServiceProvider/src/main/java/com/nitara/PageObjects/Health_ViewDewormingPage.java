package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_ViewDewormingPage  extends BasePage{

	@AndroidFindBy(id = "addDewromingData") 
	private MobileElement Add_Deworming;
	
	@AndroidFindBy(id = "viewMore") 
	private MobileElement viewMore;
	
	@AndroidFindBy(id = "dewormerName") 
	private MobileElement dewormerName;
	
	@AndroidFindBy(id = "dewormerDate") 
	private MobileElement dewormerDate;
	
	@AndroidFindBy(id = "editDeworming") 
	private MobileElement editDeworming;
	
	@AndroidFindBy(id = "deleteDeworming") 
	private MobileElement deleteDeworming;
	
	@AndroidFindBy(id = "android:id/message") 
	private MobileElement alertmessage;
	
	@AndroidFindBy(id = "snackbar_text") 
	private MobileElement snackbar_text;

	@AndroidFindBy(id = "android:id/button1") 
	private MobileElement yes_button;
	

	public void click_yes() {
		waitVisibility(yes_button);
		yes_button.click();
	}

	
	public void assert_DewormerDate(String date) {
		Assert.assertEquals(dewormerDate.getText(),date);
	}
	
	
	
	public void select_viewMore() {
		waitVisibility(viewMore);
		viewMore.click();
	}
	
	public void click_addDeworming() {
		waitVisibility(Add_Deworming);
		Add_Deworming.click();
	}
	
	public void assert_Dewormer(String name) {
		Assert.assertEquals(dewormerName.getText(),name);
	}
	


}
