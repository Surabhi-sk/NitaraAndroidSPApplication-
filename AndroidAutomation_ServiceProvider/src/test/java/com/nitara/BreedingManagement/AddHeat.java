package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class AddHeat extends GenericBase{


	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Heat_AddData(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String coopTag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		helper.goTo_AddBreedingActivityScreenFromBasicCP(coopTag,"heat");

		//Add Heat data
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(new GenerateData().getPastDate(10));
		addHeatPage.press_SaveButton();
	
		/** Assert success page */
		breedingSuccessPage.captureScreenshots("AddHeat");
		breedingSuccessPage.pressSubmitButton();
		
		/** Submit data and assert success message */
		new HelperFunctions().submitData();
	}
}

