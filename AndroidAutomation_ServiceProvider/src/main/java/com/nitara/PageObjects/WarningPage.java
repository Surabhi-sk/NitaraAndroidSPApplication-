package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WarningPage extends BasePage{
	
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement warning_msg;

	
	public void assertWarningMsg(String msg) {
		waitVisibility(warning_msg);
		Assert.assertEquals(warning_msg.getText(),msg);
	}

}
