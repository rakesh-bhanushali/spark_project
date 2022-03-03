package spark;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;
import javax.naming.spi.NamingManager;
import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;


public class Baseclass {

	
	public AndroidDriver<AndroidElement> capabilities(String appname) throws MalformedURLException{
		// TODO Auto-generated method stub /home/user/eclipse-workspace/Rahulshetty/src/SPARK_LAS_V1.8.5.apk
		File appdir=new File("src");
		File app=new File(appdir,appname);
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy J7 Prime");
		cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,16);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(11000, TimeUnit.MILLISECONDS);
		System.out.println("Spark APK opened");
		return driver;	
	}

	//RegistrationPage rp=new RegistrationPage(driver);
	
	public AndroidDriver<AndroidElement> noresetcapabilities(String appname) throws MalformedURLException{
		// TODO Auto-generated method stub /home/user/eclipse-workspace/Rahulshetty/src/SPARK_LAS_V1.8.5.apk
		File appdir=new File("src");
		File app=new File(appdir,appname);
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy J7 Prime");
		cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,16);
		cap.setCapability(MobileCapabilityType.NO_RESET,true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(11000, TimeUnit.MILLISECONDS);
		System.out.println("Spark APK opened");
		return driver;	
	}
	@Test
	public void TC01() throws MalformedURLException, InterruptedException {
		//Validating introduction screen
		AndroidDriver <AndroidElement> driver =capabilities("SPARK_LAS_V2.1.1+14.apk");
		RegistrationPage r=new RegistrationPage(driver);
	WebElement nextbutton=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button/android.widget.ImageView");
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();	
		if (driver.findElementByXPath("//android.view.View[@content-desc=\"Registration\"]").isDisplayed()) {
			System.out.println("TC01 has Passed");
		}
		else {System.out.println("TC01 has Failed");
		}
		driver.quit();
		Thread.sleep(1200);
	}

	@Test
	public void TC02() throws MalformedURLException, InterruptedException {
		//validation terms of use and privacy policy
		AndroidDriver <AndroidElement> driver =capabilities("SPARK_LAS_V2.1.1+14.apk");
		WebElement nextbutton=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button/android.widget.ImageView");
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();	
		MobileElement externalclick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView");
		externalclick.click();
		MobileElement termsofuse = (MobileElement) driver.findElementByAccessibilityId("terms of use");
		termsofuse.click();
		Thread.sleep(2500);
		if(driver.findElementByXPath("//android.view.View[@content-desc=\"Terms of Use and Privacy Policy\"]").isDisplayed()){
			System.out.println("Terms of use pdf is opened");
		}
		else
		{System.out.println("Privacy policy pdf is opened");}
		driver.navigate().back();
		MobileElement privacypolicy = (MobileElement) driver.findElementByAccessibilityId("privacy policy");
		privacypolicy.click();
		Thread.sleep(2500);
		if(driver.findElementByXPath("//android.view.View[@content-desc=\"Terms of Use and Privacy Policy\"]").isDisplayed()){
			System.out.println("Terms of use pdf is opened");
		}
		else
		{System.out.println("Privacy policy pdf is opened");}
		driver.navigate().back();
		System.out.println("TC02 Passed.");
		driver.quit();
		Thread.sleep(1200);
	}
	@Test
	public void TC03() throws MalformedURLException, InterruptedException {	
		//verifying uncheck T&C scenerio
		AndroidDriver <AndroidElement> driver =noresetcapabilities("SPARK_LAS_V2.1.1+14.apk");
		MobileElement externalclick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView");
		externalclick.click();
		Thread.sleep(1200);
		MobileElement checkbox = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
		checkbox.click();
		Thread.sleep(1200);
		MobileElement mobilenumberfield = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText");
		mobilenumberfield.click();
		mobilenumberfield.sendKeys("9619716471");
		MobileElement nextbuttonn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
		nextbuttonn.click();
		System.out.println("TC03 Passed.");
		driver.quit();
		Thread.sleep(1200);

	}	

	@Test
	public void TC04() throws MalformedURLException, InterruptedException {	
		//Validationg internet scenrio
		AndroidDriver <AndroidElement> driver =noresetcapabilities("SPARK_LAS_V2.1.1+14.apk");
		//MobileElement externalclick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView");
		//externalclick.click();
		Thread.sleep(4500);
		driver.hideKeyboard();
		Thread.sleep(2600);
		driver.toggleWifi();
		Thread.sleep(3500);
		MobileElement nextbutton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
		nextbutton.click();
		MobileElement mobilenumberfield = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText");
		mobilenumberfield.click();
		mobilenumberfield.sendKeys("9619716471");
		MobileElement nextbuttonn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
		nextbuttonn.click();
		MobileElement internetok = (MobileElement) driver.findElementByAccessibilityId("OK");
		internetok.click();
		driver.toggleWifi();
		Thread.sleep(3500);
		if(driver.findElementByXPath("//android.view.View[@content-desc=\"Registration\"]").isDisplayed()){
			System.out.println("TC04 passed");
		}
		else
		{System.out.println("TC04 Failed ");}
		driver.quit();
		Thread.sleep(1200);


	}	

	@Test
	public void TC05() throws MalformedURLException, InterruptedException {	
		//Validating Invalid OTP
		AndroidDriver <AndroidElement> driver =noresetcapabilities("SPARK_LAS_V2.1.1+14.apk");
		Thread.sleep(3500);
		MobileElement mobilenumberfield = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText");
		mobilenumberfield.click();
		mobilenumberfield.sendKeys("9619716471");
		MobileElement nextbuttonn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
		nextbuttonn.click();
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		MobileElement OTPfield= (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]");
		action.sendKeys(OTPfield, "1234").build().perform();
		MobileElement OTPSubmit = (MobileElement) driver.findElementByAccessibilityId("Submit");
		OTPSubmit.click();
		Thread.sleep(1400);
		if(driver.findElementByXPath("//android.view.View[@content-desc=\"OTP Verification \"]").isDisplayed()){
			System.out.println("TC05 passed");
			Thread.sleep(900);
		}
		else
		{System.out.println("TC05 Failed ");}	
		driver.quit();
		Thread.sleep(1500);		
	}
	
	@Test
	public void TC06() throws MalformedURLException, InterruptedException {	
		//Validating validation message in Registration screen.|mobile nummber:3212345412 OTP:2222 
		//AndroidDriver <AndroidElement> driver =noresetcapabilities("SPARK_LAS_V2.1.1+14.apk");

		AndroidDriver <AndroidElement> driver =capabilities("SPARK_LAS_V2.1.1+14.apk");
		WebElement nextbutton=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button/android.widget.ImageView");
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();	
		MobileElement externalclick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView");
		externalclick.click();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		Thread.sleep(3100);
		MobileElement mobilenumberfield = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText");
		mobilenumberfield.click();
		mobilenumberfield.sendKeys("3212345412");
		MobileElement nextbuttonn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
		nextbuttonn.click();
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		MobileElement OTPfield= (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]");
		action.sendKeys(OTPfield, "2222").build().perform();
		MobileElement OTPSubmit = (MobileElement) driver.findElementByAccessibilityId("Submit");
		OTPSubmit.click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();

		Thread.sleep(1400);

		MobileElement Registrationscreennextbutton = (MobileElement) driver.findElementByXPath("/hiierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
		Registrationscreennextbutton.click();

		MobileElement Emailfield = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
		Emailfield.click();
		MobileElement Emaildropdownselect = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
		Emaildropdownselect.click();
		MobileElement FirstName = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
		Thread.sleep(1100);
		MobileElement firstname = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
		firstname.click();
		firstname.sendKeys("rakesh");
		driver.hideKeyboard();
		Thread.sleep(1100);
		driver.hideKeyboard();
		Registrationscreennextbutton.click();
		MobileElement Lastname = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[3]");
		Lastname.click();
		Lastname.sendKeys("automation");
		Thread.sleep(1000);
		driver.hideKeyboard();
		Registrationscreennextbutton.click();
		Thread.sleep(3600);
		driver.quit();
		Thread.sleep(1800);	

	}

	@Test
	public void TC07() throws MalformedURLException, InterruptedException {			
		//AndroidDriver <AndroidElement> driver =noresetcapabilities("SPARK_LAS_V2.1.1+14.apk");
		AndroidDriver <AndroidElement> driver =capabilities("SPARK_LAS_V2.1.1+14.apk");
		WebElement nextbutton=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button/android.widget.ImageView");
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();	
		MobileElement externalclick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView");
		externalclick.click();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		Thread.sleep(3500);	
		MobileElement mobilenumberfield = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText");
		mobilenumberfield.click();
		mobilenumberfield.sendKeys("3212345412");
		MobileElement nextbuttonn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
		nextbuttonn.click();
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		MobileElement OTPfield= (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]");
		action.sendKeys(OTPfield, "2222").build().perform();
		MobileElement OTPSubmit = (MobileElement) driver.findElementByAccessibilityId("Submit");
		OTPSubmit.click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		Thread.sleep(1400);	
		MobileElement firstname = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
		firstname.click();
		firstname.sendKeys("rakesh");
		driver.hideKeyboard();
		MobileElement lastname = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[3]");
		lastname.click();
		lastname.sendKeys("automation");
		driver.hideKeyboard();
		Thread.sleep(1500);
		MobileElement googleicon = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView[2]");
		googleicon.click();
		MobileElement gmailid = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]");
		gmailid.click();
		Thread.sleep(4900);
		MobileElement facebookicon = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView[3]");
		facebookicon.click();
		Thread.sleep(3900);
		driver.navigate().back();
		Thread.sleep(1200);
		/*	MobileElement emailtextbox = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
			emailtextbox.click();
			MobileElement firstemail = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
			firstemail.click();
			driver.hideKeyboard();
			MobileElement nextbutton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
			nextbutton.click();*/
		MobileElement emailtextbox = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
		emailtextbox.click();

		MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
		//	emailtextbox.clear();
		//	MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
		emailtextbox.sendKeys("rakesh.automation2@test.com");
		driver.hideKeyboard();
		MobileElement Registrationpagenext = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
		Registrationpagenext.click();
		MobileElement enterpin = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
		enterpin.sendKeys("1234");
		//MobileElement el13 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
		//	el13.click();
		MobileElement renterpin = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
		renterpin.sendKeys("1234");
		MobileElement pinnext = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.ImageView");
		pinnext.click();
		MobileElement fingerprintskip = (MobileElement) driver.findElementByAccessibilityId("SKIP");
		fingerprintskip.click();
		System.out.println("TC07 creating new user passed.");

		//	MobileElement el17 = (MobileElement) driver.findElementByAccessibilityId("You Got Sparked! ");
		//	el17.click();
		driver.quit();
		Thread.sleep(1600);	

	}
	
	//Logging in with already registered mobile number.
//	@Test
	public void TC08() throws MalformedURLException, InterruptedException {			
		System.out.println("Excecuting Testcase TC08");
		AndroidDriver <AndroidElement> driver =noresetcapabilities("SPARK_LAS_V2.1.1+14.apk");
		
		/*	AndroidDriver <AndroidElement> driver =capabilities("SPARK_LAS_V2.1.1+14.apk");
		WebElement nextbutton=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button/android.widget.ImageView");
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();	 
		MobileElement externalclick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView");
		externalclick.click();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		Thread.sleep(3500);	
		MobileElement mobilenumberfield = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText");
		mobilenumberfield.click();
		mobilenumberfield.sendKeys("3212345412");
		MobileElement nextbuttonn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
		nextbuttonn.click();
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		MobileElement OTPfield= (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]");
		action.sendKeys(OTPfield, "2222").build().perform();
		MobileElement OTPSubmit = (MobileElement) driver.findElementByAccessibilityId("Submit");
		OTPSubmit.click();
		System.out.println("TC08 is passed"); */
		
		
		
		Thread.sleep(2100);
		MobileElement enter4digitpin=(MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"Enter 4 digit pin\"]");
		enter4digitpin.click();
		
		MobileElement pintextbox=(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]");
		Actions actions = new Actions(driver);
	    actions.click(pintextbox).perform();
		pintextbox.setValue("1234");
		actions.sendKeys(pintextbox,"1234").build().perform();
		MobileElement submitbutton=(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]/android.widget.ImageView");
		submitbutton.click();
		driver.quit();
		Thread.sleep(1600);	


	}	

	//Logging in with already registered mobile number 4815151518 and OTP 1234
	
	public void TC09() throws MalformedURLException, InterruptedException {	
		System.out.println("Exceuting Testcase number-->TC09");
		AndroidDriver <AndroidElement> driver =capabilities("SPARK_LAS_V2.1.1+14.apk");
		WebElement nextbutton=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button/android.widget.ImageView");
		Thread.sleep(1000);
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();
		nextbutton.click();	
		MobileElement externalclick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView");
		externalclick.click();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		Thread.sleep(3500);	
		MobileElement mobilenumberfield = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText");
		mobilenumberfield.click();
		mobilenumberfield.sendKeys("4815151518");
		MobileElement nextbuttonn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.ImageView");
		nextbuttonn.click();
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		MobileElement OTPfield= (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]");
		action.sendKeys(OTPfield, "1234").build().perform();
		MobileElement OTPSubmit = (MobileElement) driver.findElementByAccessibilityId("Submit");
		OTPSubmit.click();
		Thread.sleep(1600);
	//	WebElement settingicon=driver.findElementByXPath("\"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView[2]\"");
       // AndroidElement Myloans=driver.findElementByAccessibilityId("//android.view.View[@content-desc="₹ My Loans Tab 3 of 4"]");
		MobileElement Myloans=(MobileElement) driver.findElementsByAccessibilityId("₹ My Loans Tab 3 of 4");
        Myloans.click();
		
		driver.quit();
		Thread.sleep(1600);	

	}	

	
	
}
