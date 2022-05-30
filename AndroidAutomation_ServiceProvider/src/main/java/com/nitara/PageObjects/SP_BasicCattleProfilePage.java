package com.nitara.PageObjects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SP_BasicCattleProfilePage extends BasePage{

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*svBreeding.*\"))")  
	private MobileElement breeding;
	
	@AndroidFindBy(id = "svHealth") 
	private MobileElement health;
	
	
	@AndroidFindBy(id = "tvCattleDetails") 
	private MobileElement cattleProfile;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*svWeight.*\"))")  
	private MobileElement weight;
	
	public void select_weight() {
		waitVisibility(weight);
		click(weight);
	}
	public void select_breeding() {
		waitVisibility(breeding);
		click(breeding);
	}

	public void select_health() {
		waitVisibility(health);
		click(health);
		
	}
	
	public void select_cattleProfile() {
		waitVisibility(cattleProfile);
		click(cattleProfile);
		
}

}