package com.nitara.PageObjects;

import java.util.List;

import io.appium.java_client.MobileElement;

public class CattleProfile_HealthListPage extends BasePage{
	 
	public void select_treatment() {
	List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsById("container");
	elementsOne.get(2).click();
	}
	
	public void select_deworming() {
		List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsById("container");
		elementsOne.get(1).click();
		}

	public void select_vaccination() {
		List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsById("container");
		elementsOne.get(0).click();
		
	}
}
