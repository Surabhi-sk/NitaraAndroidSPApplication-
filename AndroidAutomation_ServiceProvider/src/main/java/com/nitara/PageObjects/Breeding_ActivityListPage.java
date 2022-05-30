package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_ActivityListPage extends BasePage{

	@AndroidFindBy(id = "artificial_insemination") 
	private MobileElement artificial_insemination;
	

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*calvingCardView.*\"))")
	private MobileElement calving;
	
	
	@AndroidFindBy(id = "pdCardView") 
	private MobileElement pd;
	
	@AndroidFindBy(id = "heatCardView") 
	private MobileElement heat;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*dryCardView.*\"))")  
	private MobileElement dryPeriod;
	
	public void select_dry() {
		waitForPageLoad();
		click(dryPeriod);
	}

	public void select_heat() {
		waitForPageLoad();
		click(heat);
	}
	
	public void select_ai() {
		waitForPageLoad();
		click(artificial_insemination);
	}
	
	public void select_calving() throws Exception {
		waitForPageLoad();
		click(calving);
	}
	
	
	public void select_pd() {
		waitVisibility(pd);
		click(pd);
	}
	
	public void select_Activity(String activity) {
		waitForPageLoad();
		if(activity.equalsIgnoreCase("heat")) 
			click(heat);
		else if(activity.equalsIgnoreCase("artificialInsemination"))
			click(artificial_insemination);
		else if(activity.equalsIgnoreCase("dryPeriod"))
			click(dryPeriod);
		else if(activity.equalsIgnoreCase("pd"))
			click(pd);
		else if(activity.equalsIgnoreCase("calving"))
			click(calving);
	}
	
}
