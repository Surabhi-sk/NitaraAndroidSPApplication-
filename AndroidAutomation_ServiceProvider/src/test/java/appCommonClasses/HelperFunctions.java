package appCommonClasses;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import com.nitara.utils.ExcelUtils;
import com.nitara.PageObjects.RegisterCattle_SuccessPage;
import com.nitara.PageObjects.SP_BasicCattleProfilePage;
import com.nitara.Helper.GenerateData;
import com.nitara.PageObjects.Breeding_ActivityListPage;
import com.nitara.PageObjects.Breeding_AddInseminationPage;
import com.nitara.PageObjects.Breeding_AddPDPage;
import com.nitara.PageObjects.Breeding_SuccessPage;
import com.nitara.PageObjects.RegisterCattle_CattleTypePage;
import com.nitara.PageObjects.RegisterCattle_MilkingCattlePage;
import com.nitara.PageObjects.RegisterCattle_SearchFarmPage;
import com.nitara.PageObjects.SP_HomePage;
import com.nitara.PageObjects.SubmitData_EnterOTPPage;
import com.nitara.PageObjects.SubmitData_GenerateOTPPage;
import com.nitara.PageObjects.SubmitData_SuccessPage;

public class HelperFunctions extends GenericBase{
	
	public void Insemination_ForGivenDate(String CoopTag, String date) throws Exception {


		String nameofCurrMethod = new Throwable()
				.getStackTrace()[0]
						.getMethodName();

		String sheet = nameofCurrMethod.substring(0,nameofCurrMethod.lastIndexOf("_"));

		ExcelUtils testdata = new ExcelUtils();
		Map<String,String> data = testdata.getTestData(sheet,nameofCurrMethod);
		
		SP_HomePage home = new SP_HomePage();
		home.searchCattle(CoopTag); 

		SP_BasicCattleProfilePage obj1 = new SP_BasicCattleProfilePage();
		obj1.waitForPageLoad();
		obj1.waitForPageLoad();
		obj1.waitForPageLoad();
		obj1.waitForPageLoad();
		obj1.select_breeding();

		Breeding_ActivityListPage insemination = new Breeding_ActivityListPage();
		insemination.waitForPageLoad();
		insemination.select_ai();

		HelperFunctions gendate = new HelperFunctions();
		// Select Insemination accordingly from the list of activities and add insemination details
		Breeding_AddInseminationPage ai = new Breeding_AddInseminationPage();
		ai.enter_BullId(data.get("bullId"));
		ai.enter_InseminationDate(date);
		ai.press_SaveButton();



		Breeding_SuccessPage msg = new Breeding_SuccessPage();
		msg.waitForPageLoad();
		msg.pressSubmitButton();
	
		submitData();

		SubmitData_SuccessPage successMsg = new SubmitData_SuccessPage();
		//Go back to SP Homepage
		successMsg.goto_Homepage();

		

	}
	
	
	public void PD_ValidData(String CoopTag) throws Exception {
		
		String nameofCurrMethod = new Throwable()
				.getStackTrace()[0]
						.getMethodName();

		String sheet = nameofCurrMethod.substring(0,nameofCurrMethod.lastIndexOf("_"));

		ExcelUtils testdata = new ExcelUtils();
		Map<String,String> data = testdata.getTestData(sheet,nameofCurrMethod);


		HelperFunctions helper = new HelperFunctions();
		String coopTag = helper.RegisterCattle_Milking();
		//System.out.println("138351423492");

		/* Service Provider Home page - Enter Co-op tag in the search */
		SP_HomePage home = new SP_HomePage();
		home.searchCattle(coopTag); 

		SP_BasicCattleProfilePage obj1 = new SP_BasicCattleProfilePage();
		obj1.waitForPageLoad();
		obj1.select_breeding();

		Breeding_ActivityListPage insemination = new Breeding_ActivityListPage();
		insemination.waitForPageLoad();
		insemination.select_ai();

		
		helper.Insemination_ForGivenDate(coopTag, new GenerateData().getPastDate(30));


		home.searchCattle(coopTag);	
		obj1.select_breeding();
		Breeding_ActivityListPage pregnancyTest = new Breeding_ActivityListPage();
		pregnancyTest.waitForPageLoad();
		pregnancyTest.select_pd();

		Breeding_AddPDPage pd = new Breeding_AddPDPage();
		pd.enter_PDdate(new GenerateData().getPastDate(30-21));
		pd.select_isCattlePregnant(data.get("isCattlePregnant"));

		pd.press_SaveButton();
		

		
		Breeding_SuccessPage msg = new Breeding_SuccessPage();
		msg.waitForPageLoad();
		msg.pressSubmitButton();
		/* Submit data and assert success message */
		SubmitData_GenerateOTPPage summary = new SubmitData_GenerateOTPPage();
		summary.assert_farmerPhone(prop.getProperty("FarmerPhone"));
		//summary.assert_Summary("TREATMENT");
		summary.generateOTP();

		SubmitData_EnterOTPPage otp = new SubmitData_EnterOTPPage();
		otp.enter_otp("1111");			
		otp.pressContinueBtn();

		SubmitData_SuccessPage successMsg = new SubmitData_SuccessPage();
		successMsg.assert_cattleCount(1);
		successMsg.assert_successMsg();
//		successMsg.assert_totalRequest("1");
//		successMsg.assert_requestSubmitted("1");
		

	}
	
	
	public void submitData() {
		
		/** Submit data and assert success message */
		generateOTPPage.generateOTP();

		enterOTPPage.enter_otp("1111");			
		enterOTPPage.pressContinueBtn();

		//submitDataSuccessPage.assert_cattleCount(1);
		//submitDataSuccessPage.assert_successMsg();
//		submitDataSuccessPage.assert_totalRequest("1");
//		submitDataSuccessPage.assert_requestSubmitted("1");
		enterOTPPage.waitForPageLoad();
		submitDataSuccessPage.goto_Homepage();
		
		
	}
	
	
	public String RegisterCattle_Milking() throws Exception {


		String nameofCurrMethod = new Throwable()
				.getStackTrace()[0]
						.getMethodName();

		String sheet = nameofCurrMethod.substring(0,nameofCurrMethod.lastIndexOf("_"));

		ExcelUtils testdata = new ExcelUtils();
		Map<String,String> data = testdata.getTestData(sheet,nameofCurrMethod);
		
		GenerateData numb = new GenerateData();

		String phone = prop.getProperty("FarmerPhone");

		String tagNumber = numb.generateRandomNumber(7);
		String cooptagNumber = numb.generateRandomNumber(12);

		//Service Provider Home page - Select Register Cattle
		SP_HomePage obj = new SP_HomePage();
		Thread.sleep(4000);
		obj.pressRegisterCattleButton();
	
		//Search for farm
		RegisterCattle_SearchFarmPage farmSearch = new RegisterCattle_SearchFarmPage();
		farmSearch.enterPhoneNumber(phone);
		farmSearch.pressSearchButton();
		Thread.sleep(7000);
		farmSearch.select_farm(phone);
		
		
		RegisterCattle_CattleTypePage cattleType = new RegisterCattle_CattleTypePage();
		cattleType.select_cattleType("MILKING AND DRY CATTLE");


		RegisterCattle_MilkingCattlePage reg = new RegisterCattle_MilkingCattlePage();
		reg.assert_CattleType();
		reg.assert_Phone_Number(phone);
		reg.enter_TagNumber(tagNumber);
		reg.enter_CoopTagNumber(cooptagNumber);
		
		
//		reg.select_cattleType(data.get("cattleType"));
//		reg.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			reg.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}

		reg.select_Lactation(data.get("currentLactation"));
		reg.enter_Calvingdate(data.get("lastCalvingDate"));
//		reg.enter_CalfCount(data.get("calfCount"));
//		reg.enter_Calf1Gender(data.get("calf1Gender"));
//
//		if(data.get("calfCount").equalsIgnoreCase("twins")) {
//			reg.enter_Calf2Gender(data.get("calf2Gender"));
//		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if(data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				reg.isCattlePregnant(data.get("pregnantSince"));
				reg.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));
			}
			else{
				reg.isCattlePregnant(data.get("pregnantSince"));
				reg.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural Insemination
		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				reg.isCattleInseminated();
				reg.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}

			else{
				reg.isCattleInseminated();
				reg.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}
		
		if(data.get("isCattleDry").equalsIgnoreCase("true")) {
			reg.cattleIsDry();
			reg.enter_DryPeriodDate(data.get("dryPeriodDate"));
		}

		reg.press_SaveButton();
		
		//Cattle Registration Success page
		RegisterCattle_SuccessPage msg = new RegisterCattle_SuccessPage();
		msg.assertCattleTag(tagNumber);
		msg.assertSuccessMsg("Registration has been saved successfully for");
		msg.pressSubmitButton();
	
		//Submit Data
		SubmitData_GenerateOTPPage summary = new SubmitData_GenerateOTPPage();
		summary.assert_farmerPhone(phone);
		//summary.assert_Summary("MILKING CATTLE REGISTRATION");
		//summary.assert_tagNumber(tagNumber);
		summary.generateOTP();
		
		SubmitData_EnterOTPPage otp = new SubmitData_EnterOTPPage();
		otp.enter_otp("1111");			
		otp.pressContinueBtn();
		
		SubmitData_SuccessPage successMsg = new SubmitData_SuccessPage();
//		successMsg.assert_cattleCount(1);
//		successMsg.assert_successMsg();
//		Thread.sleep(5000);
//		successMsg.assert_totalRequest("1");
//		successMsg.assert_requestSubmitted("1");
		successMsg.waitForPageLoad();
		successMsg.goto_Homepage();
		
		return(cooptagNumber);
}
}