package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Weight_RecordSuccessPage extends BasePage{
	
	@AndroidFindBy(id = "textView34") 
	private MobileElement successMsg;
	
	@AndroidFindBy(id = "methodUsed") 
	private MobileElement methodUsed;
	
	@AndroidFindBy(id = "record_another_weight_entry") 
	private MobileElement recordAnotherWeightEntry;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*weightBtn.*\"))")
	private MobileElement weight_btn;
	
	@AndroidFindBy(id = "submit_btn") 
	private MobileElement submit_btn;
	
	public void pressSubmitButton() {
		waitVisibility(submit_btn);
		click(submit_btn);
	}
	
	public void assert_successMsg() {
		Assert.assertEquals(successMsg.getText(),"Weight Record has been saved successfully for");
	}
	
	public void assert_method(String method) {
		Assert.assertEquals(methodUsed.getText(),"RECORDED BY "+method+" METHOD");
	}
	
	public void assert_weightSuccessPage(String calculateBy) {
		assert_successMsg();
		assert_method(calculateBy.toUpperCase());
	}
	
	public void click_recordAnotherWeightEntry() {
		click(recordAnotherWeightEntry);
	}


}
