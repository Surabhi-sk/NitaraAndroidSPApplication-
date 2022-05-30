package com.nitara.PageObjects;

import java.util.List;

import org.json.JSONObject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterCattle_CattleTypePage extends BasePage{

	@AndroidFindBy(id = "backButtonText") 
	private MobileElement backButtonText;
	
	@AndroidFindBy(id = "textView55") 
	private MobileElement farmer;
	
	@AndroidFindBy(id = "textView58") 
	private MobileElement phone;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]") 
	private MobileElement MilkingDry_Cattle;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]") 
	private MobileElement  MilkingDry_Details;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]") 
	private MobileElement heifer_Cattle;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]") 
	private MobileElement  heifer_Details;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]") 
	private MobileElement Calf_Cattle;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]") 
	private MobileElement  Calf_Details;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]") 
	private MobileElement Bull_Cattle;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]") 
	private MobileElement  Bull_Details;
	
	
	public void select_cattleType(String cattleType) {
		List<MobileElement> cattleTypes = (List<MobileElement>) driver.findElementsById("cattle_container");
		List<MobileElement> actList = (List<MobileElement>) driver.findElementsById("title");//{ "Vaccination" , "Deworming" , "Treatment"};
		for(int i=0;i<actList.size();i++) {
			System.out.println(actList.get(i).getText());
			if(cattleType.contentEquals(actList.get(i).getText())) {
				cattleTypes.get(i).click();
				break;} }
		
	}
	
	
public JSONObject getPage() {
		
		JSONObject obj = new JSONObject();
		obj.put("go_back_to_farm_list", backButtonText.getText());
		obj.put("farmer",farmer.getText());
		obj.put("phone_number",phone.getText());
		obj.put("milking_and_dry_cattle",MilkingDry_Cattle.getText());
		obj.put("adult_female_animals_that_are_milking_or_in_dry_period", MilkingDry_Details.getText());
		obj.put("adult_female_animal_that_has_never_had_a_calving_before_and_has_recently_been_inseminated",heifer_Details.getText());
		obj.put("calf", Calf_Cattle.getText());
		obj.put("inseminated_heifer", heifer_Cattle.getText());
		obj.put("bull",Bull_Cattle.getText());
		obj.put("calf_is_the_offspring_of_an_animal_after_calving_occurs", Calf_Details.getText());
		obj.put("a_bull_is_an_adult_male_animal", Bull_Details.getText());
		System.out.println(obj);
		return obj;
    
	}

}
