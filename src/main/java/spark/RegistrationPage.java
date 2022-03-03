package spark;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegistrationPage {
	
	public RegistrationPage(AppiumDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button/android.widget.ImageView")
	public WebElement nextbutton;
	

}
