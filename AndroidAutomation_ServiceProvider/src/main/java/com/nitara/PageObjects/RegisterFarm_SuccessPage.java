package com.nitara.PageObjects;

import org.json.JSONObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterFarm_SuccessPage extends BasePage{

	@AndroidFindBy(id = "textView34") 
	private MobileElement success_msg;
	
	@AndroidFindBy(id = "farmer_name") 
	private MobileElement farmer_name;
	
	@AndroidFindBy(id = "register_cattle_button") 
	private MobileElement register_cattle_button;
	
	public String successTxt() {
		String msg =getText(success_msg);
		System.out.println(msg);
		return msg;
	}
	
public JSONObject getPage() {
		
		JSONObject obj = new JSONObject();
		obj.put("farm_has_been_registered_successfully", success_msg.getText());
		obj.put("name",farmer_name.getText());
		obj.put("register_a_cattle", register_cattle_button.getText());
		System.out.println(obj);

		
		return obj;
    
	}

}
