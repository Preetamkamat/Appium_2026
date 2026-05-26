package com.qa.appium.appiumbasics;

import com.qa.appium.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPressGesture extends BaseTest {

    @Test
    public void longPressGesture() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement longPress = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(longPress);
        String getActualTitle = driver.findElement(AppiumBy.id("android:id/title")).getText();
        Assert.assertEquals(getActualTitle, "Sample menu", "title matched");
    }

    @Test
    public void scrollGestureTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

    }

    @Test
    public void swipeDemoTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement swipeElement = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]"))
                .getAttribute("focusable"), "true");
        swipeAction(swipeElement, "left");
    }

    @Test
    public void dragAndDropTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        dragGestureAction(source, 630, 630);
       String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
       Assert.assertEquals(result, "Dropped!", "drag result text matched");
    }
}

