package org.mobiledemo.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Base {

    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone64_x86_64");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, capabilities);

        driver.get("http://automationpractice.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }


}
