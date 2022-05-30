package com.nitara.PageObjects;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterCattle_SearchFarmPage extends BasePage{


	@AndroidFindBy(id = "search_farm_param") 
	private MobileElement search_farm_param;

	@AndroidFindBy(id = "search_btn") 
	private MobileElement search_btn;

	@AndroidFindBy(id = "farm_search_result_rv") 
	private MobileElement farm_search_result;
	
	@AndroidFindBy(id = "farmer_phone_number") 
	private MobileElement phone_number;
	
	@AndroidFindBy(id = "textView51") 
	private MobileElement goBack_Home;
	
	@AndroidFindBy(id = "register_farm_btn") 
	private MobileElement register_farm_btn;
	

public JSONObject getPage() {
		
		JSONObject obj = new JSONObject();
		obj.put("go_back_to_home", goBack_Home.getText());
		obj.put("register_farm",register_farm_btn.getText());
		obj.put("search_by_farm_/_owner_/_id", search_farm_param.getText());
		System.out.println(obj);

		
		return obj;
    
	}
	
	public void select_farm(String phone) {
		List<MobileElement> childElements = farm_search_result.findElements(By.className("android.widget.FrameLayout"));
		for (MobileElement ele: childElements) {
			MobileElement listitem = ele.findElement(By.className("android.view.ViewGroup"));
			MobileElement phoneNumber = listitem.findElement(By.id("farmer_phone_number"));
			if(phoneNumber.getText().contains(phone)) {
				phone_number.click();
			
			}
			
		}
		
	}
	
	public void enterPhoneNumber(String phone)  {
		sendKeys(search_farm_param, phone);
	}
	
	public void pressSearchButton()
	{	waitVisibility(search_btn);
		click(search_btn);	
	}
	
	
	/*public void getTextPhone() {
		String phone = phone_number.getText();
		System.out.println(phone);
	}*/


}
