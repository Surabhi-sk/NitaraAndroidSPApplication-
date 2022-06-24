package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnterPinPage extends BasePage{

	@AndroidFindBy(id = "enterPin") 
	private MobileElement pin_Et;
	
	@AndroidFindBy(id = "loginBtn") 
	private MobileElement loginBtn;
	
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement warning_msg;
	
	@AndroidFindBy(id = "loginWithOtpTv") 
	private MobileElement loginWithOtpBtn;
	
	
	@AndroidFindBy(id = "forgotPin") 
	private MobileElement forgotPinBtn;
	
	
	public void enter_pin(String pin) {
		sendKeys(pin_Et, pin);
	}
	
	public void click_loginBtn() {
		click(loginBtn);
	}
	
	public void click_forgotPinBtn() {
		click(forgotPinBtn);
	}
	
	public void click_loginWithOtpBtn() {
		click(loginWithOtpBtn);
	}
	public void assertWarning(String message) {
		waitVisibility(warning_msg);
		Assert.assertEquals(warning_msg.getText(),message);		
	}

}
