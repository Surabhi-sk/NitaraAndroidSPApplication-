package appCommonClasses;

import com.nitara.Helper.GenerateData;
import com.nitara.PageObjects.Breeding_ActivityListPage;
import com.nitara.PageObjects.Breeding_AddCalvingPage;
import com.nitara.PageObjects.Breeding_AddDryPage;
import com.nitara.PageObjects.Breeding_AddHeatPage;
import com.nitara.PageObjects.Breeding_AddInseminationPage;
import com.nitara.PageObjects.Breeding_AddPDPage;
import com.nitara.PageObjects.Breeding_SuccessPage;
import com.nitara.PageObjects.Breeding_TimelinePage;
import com.nitara.PageObjects.CattleProfilePage;
import com.nitara.PageObjects.ChooseLanguagePage;
import com.nitara.PageObjects.CreateAccount_SuccessPage;
import com.nitara.PageObjects.CreatePasswordPage;
import com.nitara.PageObjects.EnterOTPpage;
import com.nitara.PageObjects.EnterPhoneNoPage;
import com.nitara.PageObjects.EnterPinPage;
import com.nitara.PageObjects.EnterUsername;
import com.nitara.PageObjects.Health_ActivityListPage;
import com.nitara.PageObjects.Health_AddDewormingPage;
import com.nitara.PageObjects.Health_AddFollowUpPage;
import com.nitara.PageObjects.Health_AddTreatmentPage;
import com.nitara.PageObjects.Health_AddVaccinationPage;
import com.nitara.PageObjects.Health_FollowUpOptionsPage;
import com.nitara.PageObjects.Health_SuccessPage;
import com.nitara.PageObjects.Health_TreatmentSymptomsPage;
import com.nitara.PageObjects.Health_ViewDewormingPage;
import com.nitara.PageObjects.Health_ViewTreatmentPage;
import com.nitara.PageObjects.Health_ViewVaccinationPage;
import com.nitara.PageObjects.RegisterCattle_BullPage;
import com.nitara.PageObjects.RegisterCattle_CalfPage;
import com.nitara.PageObjects.RegisterCattle_CattleTypePage;
import com.nitara.PageObjects.RegisterCattle_InseminatedHeiferPage;
import com.nitara.PageObjects.RegisterCattle_MilkingCattlePage;
import com.nitara.PageObjects.RegisterCattle_SearchFarmPage;
import com.nitara.PageObjects.RegisterCattle_SuccessPage;

import com.nitara.PageObjects.RegisterFarm_EnterDetailsPage;
import com.nitara.PageObjects.RegisterFarm_EnterPhonePage;
import com.nitara.PageObjects.SP_BasicCattleProfilePage;
import com.nitara.PageObjects.SP_HomePage;
import com.nitara.PageObjects.Settings;
import com.nitara.PageObjects.SubmitData_EnterOTPPage;
import com.nitara.PageObjects.SubmitData_GenerateOTPPage;
import com.nitara.PageObjects.SubmitData_SuccessPage;
import com.nitara.PageObjects.Weight_AddWeightPage;
import com.nitara.PageObjects.Weight_RecordSuccessPage;


public class PageInitialiser {
	

	protected static Health_ActivityListPage healthActivityListPage;
	protected static Health_SuccessPage healthRecordSuccessPage;
	protected static Health_AddVaccinationPage addVaccinationPage;
	protected static Health_AddDewormingPage addDewormingPage;
	protected static Health_AddTreatmentPage addTreatmentPage;
	protected static Health_TreatmentSymptomsPage diseaseSymptoms;
	protected static CattleProfilePage cattleProfilePage;
	protected static Health_ViewDewormingPage viewDewormingPage;
	protected static Health_ViewVaccinationPage viewVaccinationPage;
	protected static Health_ViewTreatmentPage viewTreatmentPage;
	protected static RegisterCattle_BullPage registerCattleBullPage;
	protected static RegisterCattle_SuccessPage registerCattleSuccessPage;
	protected static RegisterCattle_CalfPage registerCattleCalfPage;
	protected static RegisterCattle_InseminatedHeiferPage registerCattleInseminatedHeiferPage;
	protected static RegisterCattle_MilkingCattlePage registerMilkingCattlePage;
	protected static Breeding_ActivityListPage breedingActivityListPage;
	protected static Breeding_AddInseminationPage addAIPage;
	protected static Breeding_SuccessPage breedingSuccessPage;
	protected static Helper helper;
	protected static Breeding_AddPDPage addPDPage;
	protected static HelperFunctions helperFunctions;
	protected static Breeding_AddCalvingPage addCalvingPage;
	protected static Breeding_AddDryPage addDryPeriodPage;
	protected static Breeding_AddHeatPage addHeatPage;
	protected static Breeding_TimelinePage breedingTimelinePage;
	protected static SP_HomePage SPHomePage;
	protected static SP_BasicCattleProfilePage basicCattleProfilePage;
	protected static SubmitData_GenerateOTPPage generateOTPPage;
	protected static SubmitData_EnterOTPPage enterOTPPage;
	protected static SubmitData_SuccessPage submitDataSuccessPage;
	protected static GenerateData generateData;
	protected static RegisterCattle_SearchFarmPage searchFarmPage;
	protected static RegisterCattle_CattleTypePage cattleTypePage;
	protected static RegisterFarm_EnterPhonePage enterPhonePage;
	protected static Health_FollowUpOptionsPage followUpOptionsPage;
	protected static Health_AddFollowUpPage addFollowUpPage;
	protected static EnterPhoneNoPage enterPhoneNoPage;
	protected static EnterOTPpage enterOTPpage;
	protected static CreatePasswordPage createPasswordPage;
	protected static CreateAccount_SuccessPage createAccountSuccessPage;
	protected static EnterPinPage enterPinPage;
	protected static EnterUsername enterUsername;
	protected static RegisterFarm_EnterDetailsPage farmerEnterDetailsPage;
	protected static Weight_AddWeightPage addWeightPage;
	protected static Weight_RecordSuccessPage weightSuccessPage;
	protected static ChooseLanguagePage chooseLanguagePage;
	protected static Settings settingsPage;
	protected static WarningPage WarningPage;
	
	public static void initializeAllPages() {
		
		// create instances of all pages and assign them to the variables
		healthActivityListPage = new Health_ActivityListPage();
		healthRecordSuccessPage = new Health_SuccessPage();
		addVaccinationPage = new Health_AddVaccinationPage();
		addDewormingPage = new Health_AddDewormingPage();
		addTreatmentPage = new Health_AddTreatmentPage();
		diseaseSymptoms = new Health_TreatmentSymptomsPage();
		cattleProfilePage = new CattleProfilePage();
		viewDewormingPage = new Health_ViewDewormingPage();
		viewVaccinationPage = new Health_ViewVaccinationPage();
		viewTreatmentPage = new Health_ViewTreatmentPage();
		registerCattleBullPage = new RegisterCattle_BullPage();
		registerCattleSuccessPage = new RegisterCattle_SuccessPage();
		WarningPage = new WarningPage();
		registerCattleCalfPage = new RegisterCattle_CalfPage();
		registerCattleInseminatedHeiferPage = new RegisterCattle_InseminatedHeiferPage();
		registerMilkingCattlePage = new RegisterCattle_MilkingCattlePage();
		breedingActivityListPage = new Breeding_ActivityListPage();
		breedingSuccessPage = new Breeding_SuccessPage();
		helper = new Helper();
		addPDPage = new Breeding_AddPDPage();
		addCalvingPage = new Breeding_AddCalvingPage();
		addHeatPage = new Breeding_AddHeatPage();
		breedingTimelinePage = new Breeding_TimelinePage();
		SPHomePage = new SP_HomePage();
		basicCattleProfilePage = new SP_BasicCattleProfilePage ();
		generateOTPPage = new SubmitData_GenerateOTPPage();
		enterOTPPage = new SubmitData_EnterOTPPage();
		submitDataSuccessPage = new SubmitData_SuccessPage();
		addDryPeriodPage= new Breeding_AddDryPage();
		helperFunctions = new HelperFunctions();
		addAIPage = new Breeding_AddInseminationPage();
		generateData = new GenerateData();
		searchFarmPage = new RegisterCattle_SearchFarmPage();
		cattleTypePage = new RegisterCattle_CattleTypePage();
		enterPhonePage= new RegisterFarm_EnterPhonePage();
		followUpOptionsPage = new Health_FollowUpOptionsPage();
		addFollowUpPage = new Health_AddFollowUpPage();
		enterPhoneNoPage = new EnterPhoneNoPage();
		enterOTPpage = new EnterOTPpage();
		createPasswordPage = new CreatePasswordPage();
		enterUsername = new EnterUsername();
		createAccountSuccessPage= new CreateAccount_SuccessPage();
		enterPinPage= new EnterPinPage();
		farmerEnterDetailsPage = new RegisterFarm_EnterDetailsPage();
		addWeightPage = new Weight_AddWeightPage();
		weightSuccessPage = new Weight_RecordSuccessPage();
		chooseLanguagePage = new ChooseLanguagePage();
		settingsPage = new Settings();
		
	}

}
