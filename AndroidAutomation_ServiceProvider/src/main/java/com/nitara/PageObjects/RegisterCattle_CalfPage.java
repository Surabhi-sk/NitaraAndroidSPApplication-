package com.nitara.PageObjects;

import org.json.JSONObject;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterCattle_CalfPage extends BasePage{
	
	@AndroidFindBy(id = "backButtonText") 
	private MobileElement backButtonText;
	
	@AndroidFindBy(id = "textView55") 
	private MobileElement farmer;
	
	
	@AndroidFindBy(id = "textView58") 
	private MobileElement phone;
	
	@AndroidFindBy(id = "select_cattle_tv") 
	private MobileElement selected_cattle;


	@AndroidFindBy(id = "phone_number") 
	private MobileElement phone_number;
	
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView") 
	private MobileElement front;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView") 
	private MobileElement side;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView") 
	private MobileElement back;
	
	@AndroidFindBy(id = "cear_tag_number_lbl") 
	private MobileElement ear_tag_number_lbl;
	
	@AndroidFindBy(id = "cop_tag_num_lbl") 
	private MobileElement cop_tag_num_lbl;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]") 
	private MobileElement YOB;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
	private MobileElement kg;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
	private MobileElement weight_lbl;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView") 
	private MobileElement MOB;
	
	@AndroidFindBy(xpath = "optional_txt") 
	private MobileElement optional_txt;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*bree_lbl.*\"))") 
	private MobileElement breed_lbl;
	
	@AndroidFindBy(id = "earTagNumberOrName") 
	private MobileElement TagNumber;
	
	
	@AndroidFindBy(id = "cooperative_tag_number_et") 
	private MobileElement CoopTagNumber;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*year_of_birth_spinner.*\"))") 
	private MobileElement year_of_birth;
	
	
	@AndroidFindBy(id = "month_of_birth_spinner") 
	private MobileElement month;
	
	@AndroidFindBy(id = "crossed_with_list_spinner") 
	private MobileElement crossed_with;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*cattle_type_spinner.*\"))") 
	private MobileElement cattle_type;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*attle_type_lbl.*\"))") 
	private MobileElement cattle_type_lbl;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*breed_list_spinner.*\"))")  
	private MobileElement breed_list;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*crossbreed_lbl.*\"))") 
	private MobileElement crossbreed_lbl;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*crossbreed_toogle.*\"))")
	private MobileElement crossbreed_toogle;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*save_btn.*\"))") 
	private MobileElement save_btn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*weight.*\"))")  
	private MobileElement weight;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*mothered_by_lbl.*\"))")   
	private MobileElement mothered_by_lbl;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*cop_tag_num_lbl.*\"))") 
	private MobileElement sire;
	
	
	@AndroidFindBy(xpath = "	\r\n"
			+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
	private MobileElement gender;
	

	
	
public JSONObject getPage() {
		
		JSONObject obj = new JSONObject();
		obj.put("go_back_to_select_cattle_type", backButtonText.getText());
		obj.put("farmer",farmer.getText());
		obj.put("phone_number",phone.getText());
		obj.put("bull",selected_cattle.getText());
		obj.put("front", front.getText());
		obj.put("body",back.getText());
		obj.put("side", side.getText());
		obj.put("cooperative_tag_number", cop_tag_num_lbl.getText());
		obj.put("year_of_birth",YOB.getText());
		obj.put("birth_month", MOB.getText());
		obj.put("breed", cattle_type_lbl.getText());
		obj.put("breed_type", breed_lbl.getText());
		obj.put("crossbreed", crossbreed_lbl.getText());
		weight.getText();
		obj.put("weight", weight_lbl.getText());
		obj.put("save", save_btn.getText());
		System.out.println(obj);

		
		return obj;
    
	}
	
	
	
	public void assert_CattleType() {
		waitVisibility(selected_cattle);
		Assert.assertEquals(selected_cattle.getText(), "CALF");
	}
	
	public void assert_Phone_Number(String phone) {
		waitVisibility(phone_number);
		Assert.assertEquals(phone_number.getText(), phone);
	}
	
	public void enter_TagNumber(String tag) {
		waitVisibility(TagNumber);
		sendKeys(TagNumber,tag);
	}
	
	public void enter_CoopTagNumber(String tag) {
		waitVisibility(CoopTagNumber);
		sendKeys(CoopTagNumber,tag);
	}
	

	public void select_YOB(String year) {
		click(year_of_birth);
		select_dropdown(year);

	}
	
	public void select_month(String mnth) {
		click(month);
		select_dropdown(mnth);

	}
	
	public void select_cattleType(String type) {
		click(cattle_type);
		select_dropdown(type);
	}
	
	public void select_cattleBreed(String breed) {
		scrollfindElement("BREED");
		click(breed_list);
		select_dropdown(breed);
	}
	
	public void select_crossbreedToggle(String toggle,String crossbreed) {
		//scrollfindElement("CROSSBREED");
		String checked = crossbreed_toogle.getAttribute("checked");
		if(checked.equals("false") && toggle.equals("true")) {
			crossbreed_toogle.click(); 
			click(crossed_with);
			select_dropdown(crossbreed);
		}
	
	}
	
	
	public void click_crossbreedToggle() {
			crossbreed_toogle.click(); 
	
	}
	
	
	public void enter_weight(String kg) {
		sendKeys(weight,kg);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}

}
