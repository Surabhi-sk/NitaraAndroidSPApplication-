package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SubmitData_GenerateOTPPage extends BasePage{

	@AndroidFindBy(id = "phone_number") 
	private MobileElement phone_number;

	@AndroidFindBy(id = "textView51") 
	private MobileElement go_back;

	@AndroidFindBy(id = "infoTv") 
	private MobileElement info_text;

	@AndroidFindBy(id = "summary_id") 
	private MobileElement summary;

	@AndroidFindBy(id = "cattle_ids") 
	private MobileElement cattle_tag;

	@AndroidFindBy(id = "instruction_tv") 
	private MobileElement instruction_text;

	@AndroidFindBy(id = "request_otp_gen_btn") 
	private MobileElement generateOTP_btn;

	@AndroidFindBy(id = "textView58") 
	private MobileElement phoneNumber_text;


	public void assert_Summary(String text) {
		waitVisibility(summary);
	//	Assert.assertEquals(summary.getText(), text);
	}

	public void assert_tagNumber(String tag) {
		waitVisibility(cattle_tag);
		Assert.assertEquals(cattle_tag.getText(), tag);

	}

	public void assert_farmerPhone(String phone) {
		waitVisibility(phone_number);
		//Assert.assertEquals(phone_number.getText(), "+91 "+phone);

	}

	public void generateOTP() {
		click(generateOTP_btn);	
	}

}
