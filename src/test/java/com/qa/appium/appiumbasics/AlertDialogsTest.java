package com.qa.appium.appiumbasics;

import com.qa.appium.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertDialogsTest extends BaseTest {
    @Test
    public void alertPopUpTest1() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
        String actualTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(actualTitle, "Lorem ipsum dolor sit aie consectetur adipiscing\n" +
                "Plloaso mako nuto siwuf cakso dodtos anr koop.", "Text is matching");
//        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        Thread.sleep(10000);
    }

    @Test
    public void alertPopUpTest2() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
        String actualTitle = driver.findElement(By.id("android:id/message")).getText();
        Assert.assertEquals(actualTitle, "Plloaso mako nuto siwuf cakso dodtos anr koop a cupy uf cak vux noaw yerw phuno. Whag schengos, uf efed, quiel ba mada su otrenzr.\n" +
                        "\n" +
                        "Swipontgwook proudgs hus yag su ba dagarmidad. Plasa maku noga wipont trenzsa schengos ent kaap zux comy.\n" +
                        "\n" +
                        "Wipont trenz kipg naar mixent phona. Cak pwico siructiun ruous nust apoply tyu cak Uhex sisulutiun munityuw uw dseg",
                "Text is matching");
//        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        Thread.sleep(10000);
    }
}
