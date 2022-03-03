package spark;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Baseclasss {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		String appname="SPARK_LAS_V1.8.5.apk";
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
		RegistrationPage rp=new RegistrationPage(driver);
		
	}

}
