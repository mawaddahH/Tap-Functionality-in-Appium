package ass3W12D5.TapFunctionalityinAppium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private AndroidDriver driver;

	@BeforeSuite
	public void setUp() throws MalformedURLException, InterruptedException {

		// Setting up desire caps using DesireCapabilities class
		// Create an object for Desired Capabilities
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		// Set capabilities
		desiredCapabilities.setCapability("appium:app",
				"C:\\Users\\lo0ol\\Downloads\\QA_class_app_resources.zip, attachment\\QA class app resources\\ApiDemos-debug.apk");
		desiredCapabilities.setCapability("appium:deviceName", "23b9cb400c1c7ece");
		desiredCapabilities.setCapability("appium:platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "10");
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
		desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
		// Java package of the Android app you want to run
		desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
		// Activity name for the Android activity you want to launch from your package
		desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

		System.out.println("Finshed: desiredCapabilities");

		// Initialize the driver object with the URL to Appium Server and
		// passing the capabilities
		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		System.out.println("Finshed: driver");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	/**
	 * Test Tap / Drag and Drop
	 */
	@Test(priority = 1)
	public void TestTap() throws InterruptedException {
		// Perform the action on the element
		// click on "View" (tap)
		action_clickOnPosition(113,1680);
		System.out.println("Finshed: Views");
		Thread.sleep(2000);

		// click on "Drag and Drop" using Actions
		WebElement elementDragandDrop = driver.findElement(AppiumBy.accessibilityId("Drag and Drop"));
		Actions action = new Actions(driver);
		action.moveToElement(elementDragandDrop).click().build().perform();
		System.out.println("Finshed: Gallery action");
		Thread.sleep(2000);

		// drag and drop
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("startX", 212, "startY", 552, "endX", 615, "endY", 556));

		System.out.println("Finshed: dragAndDrop");
		Thread.sleep(15000);

		if (driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).isDisplayed() == true) {
			System.out.println("Finshed: isDisplayed");
		}

		// back to "View" Page
		Navigation navigate = driver.navigate();
		navigate.back();
		System.out.println("Finshed: back to \"My account\" Page");
		Thread.sleep(3000);

	}

	public void action_clickOnPosition(int pointA_X, int pointA_Y) {
		PointerInput finger = new PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger");
		org.openqa.selenium.interactions.Sequence clickPosition = new org.openqa.selenium.interactions.Sequence(finger,
				1);
		clickPosition.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), pointA_X, pointA_Y))
				.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()))
				.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(clickPosition));
	}
}
