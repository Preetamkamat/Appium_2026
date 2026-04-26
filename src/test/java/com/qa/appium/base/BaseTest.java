package com.qa.appium.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.time.Duration;

public class BaseTest {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void configureAppium() throws InterruptedException {
    /* AppiumDriverLocalService service = new AppiumServiceBuilder()
               .withAppiumJS(new File("C:\\Users\\preet\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"))
               .withIPAddress("127.0.0.1").usingPort(4723).build();
       service.start();*/
        File nodeExe = new File("C:/Program Files/nodejs/node.exe");

        // 2. Path to your Appium main.js (matches your error path)
        File appiumJS = new File(System.getProperty("user.home") +
                "/AppData/Roaming/npm/node_modules/appium/build/lib/main.js");

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(appiumJS)
                .usingDriverExecutable(nodeExe)
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                // Fixes the "session discovery" requirement in Appium 3.0
                .withArgument(GeneralServerFlag.ALLOW_INSECURE, "adb_shell")
                .withArgument(GeneralServerFlag.RELAXED_SECURITY)
                .withLogFile(new File("appium_server_log.txt"));
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("Appium Server started at: " + service.getUrl());
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 10");
        options.setPlatformName("Android");
        options.setPlatformVersion("16");
        options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\appium\\resource\\ApiDemos-debug.apk");
        driver = new AndroidDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
