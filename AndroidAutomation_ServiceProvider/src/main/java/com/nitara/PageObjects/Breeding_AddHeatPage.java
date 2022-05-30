package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_AddHeatPage extends BasePage{
	
	@AndroidFindBy(id = "naturalBtn") 
	private MobileElement natural_btn;
	
	@AndroidFindBy(id = "artificialBtn") 
	private MobileElement artificial_btn;
	
	@AndroidFindBy(id = "heat_date") 
	private MobileElement heat_date;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*saveBtn.*\"))") 
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "cattleTagName") 
	private MobileElement cattleTag;
	

	public void assert_CattleTag(String tag) {
		Assert.assertEquals(cattleTag.getText(), tag);
	}
	
	

//	public void select_Time(String time) {
//		String[] splitString = time.split(":");
//		System.out.println(splitString);
//		String hour = splitString[0];
//		System.out.println(hour);
//		String min = splitString[1];
//		System.out.println(min);
//		String a = splitString[2];
//		System.out.println(a);
//		heatTime.click();
//		timePicker.click();
//		input_hour.click();
//		input_hour.clear();
//		sendKeys(input_hour, hour);
//		input_minute.click();
//		input_minute.clear();
//		sendKeys(input_minute, min);
////		click(am_pm);
////		select_dropdown(a);
//		ok_btn.click();
//		
//	}
	

	
	public void select_HeatType(String type) {
		
		if(type.equalsIgnoreCase("artificial")) {
			artificial_btn.click();
		}
	}
	
	public void edit_HeatType(String type) {
		
		if(type.equalsIgnoreCase("artificial")) {
			natural_btn.click();
		}
		
		else {
			artificial_btn.click();
		}
	}
	

	
	public void enter_HeatDate(String date) {
		heat_date.clear();
		sendKeys(heat_date,date);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
	

}



