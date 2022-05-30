package com.nitara.PageObjects;

import org.json.JSONObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SubmitData_EnterOTPPage extends BasePage{

	@AndroidFindBy(id = "textView4") 
	private MobileElement verificationCode_txt;
	
	@AndroidFindBy(id = "instruction_and_phone") 
	private MobileElement message;
	
	@AndroidFindBy(id = "resent_sms_btn") 
	private MobileElement resent_sms_btn;
	
	@AndroidFindBy(id = "send_otp_call_btn") 
	private MobileElement send_otp_call_btn;
	
	@AndroidFindBy(id = "continue_button") 
	private MobileElement continue_btn;
	
	@AndroidFindBy(id = "otp_txt1") 
	private MobileElement otp_txt1;

	@AndroidFindBy(id = "otp_txt2") 
	private MobileElement otp_txt2;

	@AndroidFindBy(id = "otp_txt3") 
	private MobileElement otp_txt3;

	@AndroidFindBy(id = "otp_txt4") 
	private MobileElement otp_txt4;
	
	public void enter_otp(String otp) {

		MobileElement[] arr = {otp_txt1, otp_txt2,otp_txt3,otp_txt4};
		int j =0;
		for (MobileElement i : arr) {
			char c = otp.charAt(j++);
			int digit = c - '0';
			sendKeys(i,digit);	
		}
	}
	
	public void pressContinueBtn() {
		click(continue_btn);

	}
	
	public JSONObject getPage() {
		
		JSONObject obj = new JSONObject();
		obj.put("verification_code", verificationCode_txt.getText());
		String msg = message.getText().substring(0,message.getText().lastIndexOf(" +"));
		obj.put("please_enter_the_verification_code_sent_to_your_mobile",msg);
		String sms = resent_sms_btn.getText().substring(0,resent_sms_btn.getText().lastIndexOf(" "));
		obj.put("please_enter_the_verification_code_sent_to_your_mobile",msg);
		obj.put("resend_otp_via_sms_in",sms );
		String call = send_otp_call_btn.getText().substring(0,send_otp_call_btn.getText().lastIndexOf(" "));
		obj.put("get_otp_via_call_in",call);
		obj.put("continue", continue_btn.getText());
		System.out.println(obj);

		
		return obj;
    
	}

}
