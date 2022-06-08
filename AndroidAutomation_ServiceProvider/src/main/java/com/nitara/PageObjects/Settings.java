package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Settings extends BasePage{
	
	@AndroidFindBy(id="logout_btn")  
	private MobileElement logout_btn;
	
	public void select_logoutbtn()
	{	
		click(logout_btn);	
	}
	
	

}
