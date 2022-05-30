package com.nitara.utils;

import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;


import java.io.File;
import java.util.Properties;

public class CapabilitiesManager {

	TestUtils utils = new TestUtils();

	public DesiredCapabilities getCaps() throws Exception {

		GlobalParams params = new GlobalParams();
		Properties props = new PropertyManager().getProps();

		try{
			utils.log().info("getting capabilities");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
			caps.setCapability(MobileCapabilityType.UDID, params.getUdid());
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

			//Android
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
			//caps.setCapability("noReset", true);
			caps.setCapability("autoGrantPermissions", "true");
			caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
			caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
			caps.setCapability("systemPort", params.getSystemPort());
			caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
			String appName = props.getProperty("AndroidApplication");
			String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "apps" + File.separator + appName;

			caps.setCapability("app",androidAppUrl);
			
			/*DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("pCloudy_Username", "sk@gormalone.com");
			capabilities.setCapability("pCloudy_ApiKey", "86n8j92n2t463gcpj78dqvr3");
			capabilities.setCapability("pCloudy_ApplicationName", "nitara_sahayak.apk");
			capabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
			capabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
			capabilities.setCapability("pCloudy_DurationInMinutes", 5);
			//capabilities.setCapability("pCloudy_DeviceFullName", "ONEPLUS_8_Android_11.0.0");
			capabilities.setCapability("pCloudy_DeviceManafacturer", "SAMSUNG");
			capabilities.setCapability("pCloudy_DeviceVersion", "11.0.0");*/
			

			return caps;
		} catch(Exception e){
			e.printStackTrace();
			utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
			throw e;
		}
	}
}
