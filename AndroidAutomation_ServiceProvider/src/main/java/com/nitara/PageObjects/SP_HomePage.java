package com.nitara.PageObjects;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nitara.Helper.GenerateData;
import com.nitara.PageObjects.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SP_HomePage extends BasePage{

	@AndroidFindBy(id = "register_farm_btn") 
	private MobileElement register_farm_btn;

	@AndroidFindBy(id = "request_in_progress_bar") 
	private MobileElement request_in_progress_bar;

	@AndroidFindBy(id = "register_cattle_btn") 
	private MobileElement register_cattle_btn;

	@AndroidFindBy(id = "textView65") 
	private MobileElement register_farm;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView") 
	private MobileElement mumbai;

	@AndroidFindBy(id = "textView52") 
	private MobileElement register_cattle;

	@AndroidFindBy(id = "search_farm_param") 
	private MobileElement search_cattle;

	@AndroidFindBy(id = "search_btn") 
	private MobileElement search_btn;

	@AndroidFindBy(id = "home") 
	private MobileElement home_btn;
	
	@AndroidFindBy(id ="settings")
	private MobileElement settings;

	@AndroidFindBy(id ="search_by_phone_num")
	private MobileElement search_by_phone_num;
	
	@AndroidFindBy(id ="search_cattle_farm_sp_phone")
	private MobileElement search_cattle_farm_sp_phone;
	
	@AndroidFindBy(id ="earTagNumber")
	private MobileElement earTagNumber;
	
	@AndroidFindBy(id ="tvCattleTag")
	private MobileElement tvCattleTag;
	
	public void searchFarm(String farmerNumber) {
		click(search_by_phone_num);
		sendKeys(search_cattle,farmerNumber);
		waitVisibility(search_btn);
		click(search_btn);

	}
	
	public void searchCattleinFarm(String tag) {
		sendKeys(search_cattle_farm_sp_phone,tag);
		click(search_btn);
		Assert.assertEquals(earTagNumber.getText(), tag);
		click(earTagNumber);
		waitForPageLoad();
		Assert.assertEquals(tvCattleTag.getText(), tag);		
	}
	
	public void assertSearchButtonInvisibility() {
		click(search_by_phone_num);
		GenerateData generateData = new GenerateData();
		String phoneNumber = generateData.generateRandomNumber(9);
		sendKeys(search_cattle,phoneNumber);
		List<WebElement> searchButton=  (List<WebElement>) driver.findElements(By.id("search_btn"));
		Assert.assertTrue(searchButton.size()==0);
	}
	
	public void assertCattle(String tag)
	{	
		Assert.assertEquals(tvCattleTag.getText(), tag);
	}
	
	public void pressRegisterFarmButton()
	{	waitVisibility(register_farm_btn);

	click(register_farm_btn);	
	}

	public void pressRegisterCattleButton()
	{	waitVisibility(register_cattle_btn);
	click(register_cattle_btn);	
	}


	public void searchCattle(String coopTag) {
		sendKeys(search_cattle,coopTag);
		waitVisibility(search_btn);
		click(search_btn);

	}

	public JSONObject getPage() {

		JSONObject obj = new JSONObject();
		obj.put("register_a_cattle", register_cattle);
		obj.put("mumbai", mumbai);
		obj.put("register_farm",register_farm);
		System.out.println(obj);


		return obj;

	}

	public void assert_SPHomePage() {
		waitForPageLoad();
		waitVisibility(home_btn);


	}
	
	public void wait_basicCattleProfileScreenLoad() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,50, 500);
			wait
            .ignoring(StaleElementReferenceException.class)
            .ignoring(NoSuchElementException.class)
            .until(ExpectedConditions.invisibilityOf(request_in_progress_bar));
			} catch (NoSuchElementException e) {
			}
	}
	
	public void click_SettingsButton()
	{	waitForVisibility(settings);
		click(settings);	
	}
	
	
	
	
	
	
	
	
	
	
	
	





}
