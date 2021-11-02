package com.saf.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverUtilities {

    public static WebDriver webDriver;

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(getChromeOptions());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }

    public static ChromeOptions getChromeOptions()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("start-maximized");
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-translate");
        options.addArguments("disable-automatic-password-saving");
        options.addArguments("allow-silent-push");
        options.addArguments("disable-infobars");
        options.setCapability("useAutomationExtension", false);
        return options;

    }

}
