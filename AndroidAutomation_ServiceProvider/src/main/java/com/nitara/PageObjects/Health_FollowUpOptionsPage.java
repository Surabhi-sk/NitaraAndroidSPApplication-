package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_FollowUpOptionsPage extends BasePage{
	
	@AndroidFindBy(id = "diseasesTv") 
	private MobileElement treatment;
	
	
	public void select_treatment() {
		treatment.click();
	}
	

}
