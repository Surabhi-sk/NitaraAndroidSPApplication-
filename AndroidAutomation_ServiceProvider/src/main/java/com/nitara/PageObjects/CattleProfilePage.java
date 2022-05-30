package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CattleProfilePage extends BasePage{

	@AndroidFindBy(id = "healthBtn") 
	private MobileElement health_btn;
	
	@AndroidFindBy(id = "breedingBtn")
	private MobileElement breeding_btn;
	
	public void select_Health() {
		waitForVisibility(health_btn);
		health_btn.click();
	}
	
	public void select_Breeding() {
		waitForVisibility(breeding_btn);
		breeding_btn.click();
	}
	
	
}
