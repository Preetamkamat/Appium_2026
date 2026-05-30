package com.qa.appium.appiumbasics;

import com.qa.appium.base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import java.util.Map;

public class MiscellaneousTest extends BaseTest {

    @Test
    public void deviceRotationTest() throws InterruptedException {

        // adb shell dumpsys window | find "mCurrentFocus"
        //App package and activity
        startActivityApp("io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies");
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        DeviceRotation landscape = new DeviceRotation(0, 0, 90);
        driver.rotate(landscape);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)")).click();
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Preetam");
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
