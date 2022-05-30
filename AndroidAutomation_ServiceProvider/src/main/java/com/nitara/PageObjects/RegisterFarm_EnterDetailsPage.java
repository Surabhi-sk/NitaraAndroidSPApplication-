package com.nitara.PageObjects;

import org.json.JSONObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterFarm_EnterDetailsPage extends BasePage{

	@AndroidFindBy(id = "textView3") 
	private MobileElement change_phonenumber;
	
	@AndroidFindBy(id = "textView12") 
	private MobileElement phone_number;
	
	@AndroidFindBy(id = "textView45") 
	private MobileElement uploadPhoto;

	@AndroidFindBy(id = "textView49") 
	private MobileElement language;

	@AndroidFindBy(id = "textView47") 
	private MobileElement name;

	@AndroidFindBy(id = "android:id/text1") 
	private MobileElement english;
	
	@AndroidFindBy(id = "continue_button") 
	private MobileElement continue_btn;
	
	@AndroidFindBy(id = "farmer_name") 
	private MobileElement farmer_firstname;
	
	@AndroidFindBy(id = "farmer_midname") 
	private MobileElement farmer_midname;
	
	@AndroidFindBy(id = "farmer_lastname") 
	private MobileElement farmer_lastname;
	
	

	public void enter_firstName(String name)  {
		sendKeys(farmer_firstname,name);
	}
	
	public void enter_midname(String name)  {
		sendKeys(farmer_midname,name);
	}
	
	public void enter_lastname(String name)  {
		sendKeys(farmer_lastname,name);
	}
	
	public void pressContinueBtn() {
		click(continue_btn);

	}
	
	public void select_language(String lang) {
		click(language);
		//android:id/text1
		select_dropdown(lang);

	}
	
public JSONObject getPage() {
		
		JSONObject obj = new JSONObject();
		obj.put("change_phone_number", change_phonenumber.getText());
		obj.put("phone_number",phone_number.getText());
		obj.put("upload_farm_owner_photo", uploadPhoto.getText());
		obj.put("name",name.getText());
		obj.put("language",language.getText());
		obj.put("english",english.getText());
		obj.put("continue", continue_btn.getText());
		System.out.println(obj);

		
		return obj;
    
	}

}
