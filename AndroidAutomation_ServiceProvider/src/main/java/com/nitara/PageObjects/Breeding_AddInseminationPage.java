package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_AddInseminationPage extends BasePage{

	@AndroidFindBy(id = "bullId") 
	private MobileElement bullId;
	
	@AndroidFindBy(id = "semenBrand") 
	private MobileElement semenBrand;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*saveBtn.*\"))")  
	private MobileElement save_btn;
	
	
	@AndroidFindBy(id = "insemination_date") 
	private MobileElement insemination_date;
	


	
	public void select_semenBrand(String brand) {
		click(semenBrand);
		select_dropdown(brand);
	}
	
	public void enter_BullId(String id) {
		sendKeys(bullId,id);
	}
	
	
	public void enter_InseminationDate(String date) {
		waitForPageLoad();
		insemination_date.clear();
		sendKeys(insemination_date,date);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
}
	
	
	
