package com.nitara.CattleManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class SearchCattle extends GenericBase{
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SearchCattle_farmNotFound(Map<String,String> data) throws Exception{	
		
		
		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		
		/** Enter Farmer Number that is not registered**/
		SPHomePage.searchFarm(data.get("phoneNo"));
		
		SPHomePage.waitForPageLoadBar();
		
		SPHomePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SearchCattle_farmNotInCurrentArea(Map<String,String> data) throws Exception{	
		
		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		
		/** Enter Farmer Number that is not in the current area**/
		SPHomePage.searchFarm(data.get("phoneNo"));
		
		SPHomePage.waitForPageLoadBar();
		
		SPHomePage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression")
	public void SearchCattle_farmerNumberHasLessDigits() throws Exception{	
		
		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		
		/** To verify user should not be able to search farm with number less than 10 digits**/
		SPHomePage.assertSearchButtonInvisibility();
		
	}
	
	@Test(groups="Regression")
	public void SearchCattle_byFarmerNumber() throws Exception{	
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle").split(" ")[1];
		
		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		
		/** Search Cattle**/
		String phone = prop.getProperty("FarmerPhone");
		SPHomePage.searchFarm(phone);
		
		SPHomePage.waitForPageLoadBar();
		
		SPHomePage.searchCattleinFarm(Tag);	
	}
	
	@Test(groups="Regression")
	public void SearchCattle_byPashuAadhar() throws Exception{	
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String [] id =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle").split(" ");
		String Tag = id[1];
		String coopTag = id[0];
		
		/** Login **/
		new Login().Login_ValidData();
		
		searchFarmPage.waitForPageLoadBar();
		
		/** Search Cattle**/
		SPHomePage.searchCattle(coopTag);
		
		SPHomePage.waitForPageLoadBar();
		
		SPHomePage.assertCattle(Tag);
	}
	

}
