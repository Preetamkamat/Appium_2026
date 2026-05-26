package com.qa.appium.appiumbasics;

import com.qa.appium.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTest {

    @Test
    public void wifiCheckboxClick() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
    }

    @Test
    public void wifiSettingTextClick() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)")).click();
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Preetam");
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }


    @Test
    public void getWifiSettingTitle() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)")).click();
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Preetam");
    }

  }

