package com.nitara.Report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReport {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;

	@BeforeSuite
	public void reportSetup() {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String fileDate = dateFormat.format(date);
		htmlReporter = new ExtentHtmlReporter("Test_Report"+fileDate+".html");
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}
	
	public void getStatus(JSONObject status, ExtentTest test) {
		for (String key: status.keySet()){
			
			
			String value = status.getString(key);

			if(value.equals("False")) {
				test.log(Status.FAIL, key + ": " + status.get(key) );
			}
			else if(value.equals("True")){
				test.log(Status.PASS, key + ": " + status.get(key));
			}
			else {
				test.log(Status.FAIL, key + ": " + status.get(key));
			}

		}
	}

	@AfterSuite
	public void endSetup()
	{
		
		extent.flush();

	}

}
