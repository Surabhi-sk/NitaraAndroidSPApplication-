package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_AddCalvingPage extends BasePage{

	@AndroidFindBy(id = "twinsRdBtn") 
	private MobileElement Twins_RdBtn;
	
	@AndroidFindBy(id = "singleRdBtn") 
	private MobileElement Single_RdBtn;
	
	@AndroidFindBy(id = "maleRdBtn_single") 
	private MobileElement Male_RdBtn;
	
	@AndroidFindBy(id = "femaleRdBtn_single") 
	private MobileElement Female_RdBtn;
	
	@AndroidFindBy(id = "android:id/button1") 
	private MobileElement proceed;
	
	@AndroidFindBy(id = "calvingTime") 
	private MobileElement calvingTime;
	
	@AndroidFindBy(id = "abortedRdBtn_single") 
	private MobileElement Aborted_RdBtn;
	
	
	@AndroidFindBy(id = "calving_date") 
	private MobileElement calving_date;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*saveBtn.*\"))")    
	private MobileElement save_btn;
	
	
	public void enter_CalvingDate(String date) {
		calving_date.clear();
		sendKeys(calving_date,date);
	}
	
	public void enter_CalvingTime(String time) {
		calvingTime.sendKeys(time);
	}

	public void select_CalfResultSingle(String result,String gender) {
		
		
			Single_RdBtn.click();
			if(Male_RdBtn.getText().equalsIgnoreCase(gender))
			{
				Male_RdBtn.click();
			}
			
			else if(Female_RdBtn.getText().equalsIgnoreCase(gender))
			{
				Female_RdBtn.click();
			}
			
			else if(Aborted_RdBtn.getText().equalsIgnoreCase(gender))
			{
				Aborted_RdBtn.click();
			}

	}
	
	
	public void select_CalfResultTwins(String result,String gender1, String gender2) {
		
		
		Twins_RdBtn.click();
		if(Male_RdBtn.getText().equalsIgnoreCase(gender1) || Male_RdBtn.getText().equalsIgnoreCase(gender2))
		{
			Male_RdBtn.click();
		}
		
		if(Female_RdBtn.getText().equalsIgnoreCase(gender1) || Female_RdBtn.getText().equalsIgnoreCase(gender2))
		{
			Female_RdBtn.click();
		}
		
		if(Aborted_RdBtn.getText().equalsIgnoreCase(gender1)|| Aborted_RdBtn.getText().equalsIgnoreCase(gender2))
		{
			Aborted_RdBtn.click();
		}

}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
	
	public void press_proceed() {
		click(proceed);	
	}
}
