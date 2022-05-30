package com.nitara.BreedingManagement;


import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper;
import appCommonClasses.HelperFunctions;


public class AddPD extends GenericBase{


	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void PD_AddData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingCattle_Inseminated");
		
		
		//helperFunctions.Insemination_ForGivenDate(coopTag,new GenerateData().getPastDate(283));
		
		new Helper().goTo_AddBreedingActivityScreenFromBasicCP(coopTag,"pd");

		/** Fill PD form */
		addPDPage.enter_PDdate(new GenerateData().getPastDate(30-21));
		addPDPage.select_isCattlePregnant(data.get("isCattlePregnant"));
		addPDPage.press_SaveButton();
		
		/** Assert success page */
		breedingSuccessPage.captureScreenshots("AddPD");
		breedingSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		new HelperFunctions().submitData();
	}
}
