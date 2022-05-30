package com.nitara.PageObjects;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nitara.utils.DriverManager;
import com.nitara.utils.TestUtils;

public class BasePage {

	public AndroidDriver<MobileElement> driver;
	TestUtils utils = new TestUtils();

	public BasePage() {
		this.driver = (AndroidDriver<MobileElement>) new DriverManager().getDriver();
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	public void captureScreenshots(String functionality) {
		File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("Screenshots/"+functionality+"_Screenshot.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void waitForPageLoad(MobileElement locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
		wait.until(ExpectedConditions.invisibilityOf(locator));
	}
	
	public void waitForPageLoad(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterDate(String date) {
		// TODO Auto-generated method stub
		System.out.println(date);
		driver.findElementByAccessibilityId(date).click();
		
	}

	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void waitVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, TestUtils.OTP_WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
//	public void findElements(String classname) {
//		WebElement elements = (WebElement) driver.findElements(By.className(classname));
//		elements.get(1);
//		elements.click();
//	}

	public void clear(MobileElement e) {
//		waitForVisibility(e);
//		e.clear();
		driver.getKeyboard().sendKeys(Keys.DELETE);
	}

	public void click(MobileElement e) {
		e.click();
	}

	public void click(MobileElement e, String msg) {
		waitForVisibility(e);
		// utils.log().info(msg);
		e.click();
	}

	public void sendKeys(MobileElement e, int txt) {
		waitForVisibility(e);
		// utils.log().info(msg);
		e.sendKeys(String.valueOf(txt));
	}
	

	public void sendKeys(MobileElement e, String txt) {
		e.sendKeys(txt);
	}

	public String getAttribute(MobileElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}

	public String getText(MobileElement e) {
		String txt;
		txt = getAttribute(e, "text");
		return txt;
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void closeApp() {
		((InteractsWithApps) driver).closeApp();
	}

	public void launchApp() {
		((InteractsWithApps) driver).launchApp();
	}


	public boolean find(final MobileElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					if (element.isDisplayed()) {
						return true;
					}
					return false;
				}
			});
		} catch (Exception e) {
			return false;
		}
	}

	public boolean find(final By element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					if (driver.findElement(element).isDisplayed()) {
						return true;
					}
					return false;
				}
			});
		} catch (Exception e) {
			return false;
		}
	}


	public String captureToast() {
		WebDriverWait waitForToast = new WebDriverWait(driver,25);
		waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		String toastMessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
		return toastMessage;
	}
	
	public void select_dropdown(String value) {
		driver.findElement(By.xpath("//*[@text='" + value + "']")).click();
	}
	
	public void findElement(String text) {
		waitForPageLoad();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+text+"\")").click();
	}
	

	public void scrollfindElement(String myText) {
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(textContains(\""+myText+"\"))").click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
    ".scrollIntoView(new UiSelector().textContains(\""+myText+"\"))");
	}
	public void scrollTofindElement(String id) {
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).resourceId(\""+myText+"\"))").click();
		MobileElement el = (MobileElement) driver.findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().resourceIdMatches(\"" +id+ "\"));");
		el.click();
	}
	
	public void hideKeyboard() {
		driver.hideKeyboard();
	}
	
	
	    public void CalendarDateSelection(MobileElement leftarrow,MobileElement RightArrow){
	    	
	    	SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	    	Date date = new Date();
	    	System.out.println(date);
	    	
	    	long months =
	   	         ChronoUnit.MONTHS.between(
	   	        	     YearMonth.from(LocalDate.parse("2021-10-24")), 
	   	        	     YearMonth.from(LocalDate.parse("2020-08-24")));
	    	
	    	 MobileElement leftArrow = (MobileElement) driver.findElement(By.id("android:id/prev"));
			//MobileElement rightArrow = (MobileElement) driver.findElement(By.id("android:id/prev"));
	    	 
	         for(int i = 0; i < Math.abs(months); i++){
	             leftArrow.click();
	         }
	         
	    }
}



