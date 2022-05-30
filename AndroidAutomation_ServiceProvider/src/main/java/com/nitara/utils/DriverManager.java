package com.nitara.utils;


import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


@SuppressWarnings("rawtypes")



public class DriverManager {
	
	

	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
	TestUtils utils = new TestUtils();

	public AppiumDriver getDriver(){
		return driver.get();
	}

	public void setDriver(AppiumDriver driver2){
		driver.set(driver2);
	}

	public void initializeDriver() throws Exception {
		
		Properties props = new PropertyManager().getProps();
		AppiumDriver driver = null;

		if(driver == null){
			try{
				utils.log().info("initializing Appium driver");

				driver = new AndroidDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
				//driver = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), new CapabilitiesManager().getCaps());
				
				utils.log().info("Driver is initialized");
				this.driver.set(driver);
			} catch (IOException e) {
				e.printStackTrace();
				utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
				throw e;
			}
		}

	}

}