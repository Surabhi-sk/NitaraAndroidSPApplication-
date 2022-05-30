package com.nitara.PageObjects;

import org.json.JSONObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterFarm_EnterPhonePage extends BasePage{

	
	@AndroidFindBy(id = "textView3") 
	private MobileElement goBack_Text; 
	
	@AndroidFindBy(id = "textView4") 
	private MobileElement phone_number;
	
	@AndroidFindBy(id = "farmer_phone_number") 
	private MobileElement farmer_phone_number;
	
	@AndroidFindBy(id = "textView") 
	private MobileElement message;
	
	@AndroidFindBy(id = "generate_otp_btn") 
	private MobileElement generateOtp_btn;
	

	public void enterPhone(String username)  {
		waitVisibility(farmer_phone_number);
		sendKeys(farmer_phone_number,username);
	}
	
	public void generateOtp()  {
		click(generateOtp_btn);
	}

public JSONObject getPage() {
		
		JSONObject obj = new JSONObject();
		obj.put("go_back_to_home", goBack_Text.getText());
		obj.put("phone_number", phone_number.getText());
		obj.put("you_will_receive_a_one_time_password_on_the_given_mobile_number",message.getText());
		obj.put("generate_otp", generateOtp_btn.getText() );
		System.out.println(obj);
		return obj;
    
	}

}
	

	
	
	
	
		
		