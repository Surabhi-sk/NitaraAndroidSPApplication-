package appCommonClasses;



public class Helper extends PageInitialiser{
	
	public void goTo_BasicCattleProfile(String coopTag) {
		SPHomePage.searchCattle(coopTag);
		SPHomePage.waitForPageLoad();
		SPHomePage.waitForPageLoad();
		
	}
	
	public void goTo_AddBreedingActivityScreenFromBasicCP(String CoopTag, String activity) {
		
		goTo_BasicCattleProfile(CoopTag);
		
		/** In basic cattle profile - select breeding - select activity */
		basicCattleProfilePage.waitForPageLoad();
		basicCattleProfilePage.waitForPageLoad();
		basicCattleProfilePage.select_breeding();
		basicCattleProfilePage.waitForPageLoad();
		breedingActivityListPage.select_Activity(activity);
		breedingActivityListPage.waitForPageLoad();
		
		
	}
	
	public void goTo_AddWeightScreenFromBasicCP(String CoopTag) {
		
		goTo_BasicCattleProfile(CoopTag);
		
		/** In basic cattle profile - select breeding - select activity */
		basicCattleProfilePage.waitForPageLoad();
		basicCattleProfilePage.waitForPageLoad();
		basicCattleProfilePage.select_weight();
		
		
	}
	
public void goTo_AddHealthActivityScreenFromBasicCP(String CoopTag, String activity) {
		
		goTo_BasicCattleProfile(CoopTag);
		
		/** In basic cattle profile - select health - select activity */
		basicCattleProfilePage.waitForPageLoad();
		basicCattleProfilePage.waitForPageLoad();
		basicCattleProfilePage.select_health();
		basicCattleProfilePage.waitForPageLoad();
		//basicCattleProfilePage.waitForPageLoad();
		healthActivityListPage.select_activity(activity);
		healthActivityListPage.waitForPageLoad();
		
	}
	
	
	public void goTo_AddBreedingActivityScreenFromCattleProfile(String CoopTag, String activity) {
		
		goTo_CattleProfile(CoopTag) ;
		
		/** In basic cattle profile - select breeding - select activity */
		basicCattleProfilePage.waitForPageLoad();
		basicCattleProfilePage.waitForPageLoad();
		cattleProfilePage.select_Breeding();
		breedingTimelinePage.waitForPageLoad();
		//breedingTimelinePage.waitForPageLoad();
		breedingTimelinePage.click_AddActivity();
		breedingTimelinePage.waitForPageLoad();
		breedingActivityListPage.select_Activity(activity);
		breedingTimelinePage.waitForPageLoad();
		
	}
	
public void goTo_ViewHealthActivityScreenFromCattleProfile(String CoopTag, String activity) {
		
		goTo_CattleProfile(CoopTag) ;
		
		/** In basic cattle profile - select breeding - select activity */
		basicCattleProfilePage.waitForPageLoad();
		basicCattleProfilePage.waitForPageLoad();
		cattleProfilePage.select_Health();
		healthActivityListPage.waitForPageLoad();
		healthActivityListPage.select_activity(activity);
		healthActivityListPage.waitForPageLoad();
		
	}
	
	public void goTo_CattleProfile(String CoopTag) {
		
		goTo_BasicCattleProfile(CoopTag);
		basicCattleProfilePage.waitForPageLoad();
		//basicCattleProfilePage.waitForPageLoad();
		basicCattleProfilePage.select_cattleProfile();		
		cattleProfilePage.waitForPageLoad();
	}
	
	public void goTo_BreedingTimeline(String CoopTag) {
		
		goTo_CattleProfile(CoopTag);
		
		/** In basic cattle profile - select breeding */
		basicCattleProfilePage.waitForPageLoad();
		//basicCattleProfilePage.waitForPageLoad();
		cattleProfilePage.select_Breeding();
		cattleProfilePage.waitForPageLoad();
		
	}
	
	

}
