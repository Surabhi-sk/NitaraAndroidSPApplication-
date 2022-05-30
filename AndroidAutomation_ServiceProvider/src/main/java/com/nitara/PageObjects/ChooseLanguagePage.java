package com.nitara.PageObjects;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChooseLanguagePage extends BasePage{
	
	@AndroidFindBy(id = "skip_btn") 
	private MobileElement skip_btn;
	
	public void select_Language(String language) {
		String[] lang = {"ENGLISH","GUJARATI","MARATHI","HINDI"};
		waitForPageLoad();
		List<MobileElement> langOptions = (List<MobileElement>) driver.findElementsByClassName("android.view.ViewGroup");
		for(int i=0;i<langOptions.size();i++) {
			if(language.toUpperCase().contentEquals(lang[i])) {
				System.out.println("Chosen");
				langOptions.get(i).click();
				break;} }
	}
		
		public void click_skipBtn() {
			click(skip_btn);	
		}
				
				
		
	

}
