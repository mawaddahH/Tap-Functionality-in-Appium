# Tap-Functionality-in-Appium
Assignment 3 W11D5 - SDA - Software QA Bootcamp



# Table of contents
- [Question](#question)
- [Answer](#answer)
  - [Set up](#set-up)
  - [Start Work](#start-work)
	  - [STEP 1: Start Appium Server](#step-1-start-appium-server)
	  - [STEP 2: Check your phone is connected](#step-2-check-your-phone-is-connected)
	  - [STEP 3: Start Appuim Inspector session](#step-3-start-appuim-inspector-session)
 	  - [STEP 4: Create a Maven Project and Set Dependencies](#step-4-create-a-maven-project-and-set-dependencies)
	  - [STEP 5: Create java class then set the DesiredCapabilities](#step-5-create-java-class-then-set-the-desiredcapabilities)
	  - [STEP 6: Detect Elements](#step-6-detect-elements)
- [Output Screenshots](#output-screenshots)

---
# Question
Create an Appium script to open any application on the phone and perform Touch actions

---

# Answer
Before running the code, there are some steps that need to take considered:

---
## Set up
### First:
Download and install:
- [JDK](https://www.oracle.com/java/technologies/downloads/) (Lastest)
- [Eclipse](https://www.eclipse.org/) (Lastest)
- [Android Studio](https://developer.android.com/studio) (Lastest)
- [Appium Desktop](https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4) (Lastest)
- [Appium Inspector](https://github.com/appium/appium-inspector/releases) (Lastest)
- [Node](https://nodejs.org/en/) (Lastest)



### Second:
Setup System Environment variables
- JAVA_HOME
- ANDROID_HOME
- platform tool
- Build tool
- tool
- node
- nmp

#### Check this [Reference](https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux) to know how to use the Path

#### Your system path should have as shown below

<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185808789-558650e2-2ce9-490b-823d-112a1868264e.png" width=40% height=40%>
  
</p>

#### Install and start the Appium Server via Node

To install appium v2 run this command, window users please open your terminal in admin mode
```md
npm install -g appium@next
```

#### Check setup via below commands
```md
appium -v
```

```md
node -v
```

```md
java -version
```

```md
echo %JAVA_HOME%
```

```md
echo %ANDROID_HOME%
```

```md
adb
```


<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185808882-36afbecf-8779-4d64-b59d-7c61adc9166b.png" width=60% height=60%>
  
</p>


### Third:
1. Set up the [Emulator](https://www.swtestacademy.com/how-to-run-arm-apk-on-x86-systems/) or [Hardware Device](https://developer.android.com/studio/run/device)

I used my hrdware device

<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185809066-0ea7e920-0195-4641-a4c6-7e3b1287b142.png" width=40% height=40%>
  
</p>

2. Set up the Appuim Desktop configuration
<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185809147-da67f0e8-64de-4e6f-a6cd-41fbc1965dda.png" width=60% height=60%>
  
</p>

---
# Start Work
### STEP 1: Start Appium Server

<p align="center">

https://user-images.githubusercontent.com/48597284/185941666-d6b2765e-d939-488c-99e1-53499aee81e6.mp4
  
</p>

---

### STEP 2: Check your phone is connected
I used an actual device.
write in `CMD` the following:

```md
adb devices
```

<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185943130-fc781526-23f3-4365-8cc2-8d92daddb97d.png" width=40% height=40%>
  
</p>

---

### STEP 3: Start Appuim Inspector session
Set the Following Desired Capabilities: 
- `appium:appium.app`: C:\Users\lo0ol\eclipse-workspace\ChangingcontextwithAppium\ApiDemos-debug.apk
- `appium:automationName`: UiAutomator2
- `appium:deviceName`: 23b9cb400c1c7ece
- `appium:platformName`: Android
- `appium:platformVersion`: 10
- `appium:appPackage`:  io.appium.android.apis
- `appium:appActivity`: io.appium.android.apis.ApiDemos

<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/186275642-614dbee9-3413-4dc8-a34e-d3152c0c33b0.png" width=80% height=80%>
  
</p>

Then start the session after start the Appium Server.
<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/186275942-969e707f-eaf8-4f8b-a0c7-082422e77ae0.png" width=80% height=80%>
  
</p>

---

### STEP 4: Create a Maven Project and Set Dependencies
- _Eclipse > Create project -> New maven project -> maven-archetype-quickstart (1.4)(this gives you a maven template to begin work with-> Group ID n Artifact ID is a must for maven projects  (so appium can uniquely identify your project). The group ID is like a package name and Artifact Id is like a project name_.


Open pom.xml and add latest [Java Client](https://mvnrepository.com/artifact/io.appium/java-client) dependency.
remove junit and replace it with [TestNG](https://mvnrepository.com/artifact/org.testng/testng) dependency 

The Final dependencies looks like:
```md
  <dependencies>
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.6.1</version>
</dependency>

<!-- https://mvnrepository.com/artifact/io.appium/java-client -->
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>8.1.1</version>
</dependency>
  </dependencies>
```

<p align="center">
  <img src="https://user-images.githubusercontent.com/48597284/185945115-b011148d-9932-4994-8a8f-92c58028bcb6.png" width=50% height=50%>
</p>

---

### STEP 5: Create java class then set the DesiredCapabilities

1. Create an object for Desired Capabilities
```md
DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
```

2. Set Capability as follow:

```md
desiredCapabilities.setCapability("appium:app","C:\\Users\\lo0ol\\eclipse-workspace\\ChangingcontextwithAppium\\ApiDemos-debug.apk");
desiredCapabilities.setCapability("appium:deviceName", "23b9cb400c1c7ece");
desiredCapabilities.setCapability("appium:platformName", "Android");
desiredCapabilities.setCapability("appium:platformVersion", "10");
desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
```

Note: You need to set the `appium:appPackage` and `appium:appActivity` .

>  make sure the application opened on your real phone

3. Open `CMD` and write:

```md
adb shell dumpsys window | find "mCurrentFocus"
```
<p align="center">

  <img src="https://user-images.githubusercontent.com/48597284/186276158-fa051893-e808-4d64-9d6a-a5278f140af9.png" width=80% height=80%>
  
</p>

See [How to find App Package and App Activity of your Android App](https://support.testsigma.com/support/solutions/articles/32000019977-how-to-find-app-package-and-app-activity-of-your-android-app) for more information 

4. Add Capability in the code:

Java package of the Android app you want to run
```md
desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
```

Activity name for the Android activity you want to launch from your package
```md
desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
```

----

### STEP 6: Detect Elements
Go back to the Appium inspector and detect elements, then add them in the code
> After each action you did on your real device, you must refresh the Appium inspector to detect the screen and their elements

- Create Tap by Coordinate Method
```md
public void action_clickOnPosition(int pointA_X, int pointA_Y) {
		PointerInput finger = new PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger");
		org.openqa.selenium.interactions.Sequence clickPosition = new org.openqa.selenium.interactions.Sequence(finger,
				1);
		clickPosition.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), pointA_X, pointA_Y))
				.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()))
				.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(clickPosition));
}
 ```

- Click on "View" using Tap Method
```md
action_clickOnPosition(113,1680);
 ```
<p align="center">

  <img src="https://user-images.githubusercontent.com/48597284/186276405-72bc4c47-747b-45bd-83d2-f45b7e451f3f.png" width=80% height=80%>
  
</p>


- click on "Drag and Drop" using `Actions`
```md
WebElement elementDragandDrop = driver.findElement(AppiumBy.accessibilityId("Drag and Drop"));
Actions action = new Actions(driver);
action.moveToElement(elementDragandDrop).click().build().perform();
 ```
<p align="center">

  <img src="https://user-images.githubusercontent.com/48597284/188751971-c03b5c01-37fb-4d1c-84c1-b1b02d8b3cd0.png" width=80% height=80%>
  
</p>


- Drag and drop 
```md
((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
	  "startX", 212,
		"startY",552,
		"endX", 615,
		"endY", 556
));
 ```
<p align="center">

  <img src="https://user-images.githubusercontent.com/48597284/188752244-8a0edbfe-e7ad-497b-9855-a53882721e90.png" width=80% height=80%>
  
</p>


- back to "View" Page
```md
Navigation navigate = driver.navigate();
navigate.back();
```

----

## Output Screenshots
<p align="center">




https://user-images.githubusercontent.com/48597284/188766885-4b27c1ac-16fb-46cd-9b6a-68b580250d82.mp4


  
</p>


