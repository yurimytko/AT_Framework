package org.example;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverPool {
    private static WebDriver DRIVER = null;

    public static WebDriver setupFirefoxDriver() {
        if(DRIVER == null) {
            FirefoxDriverManager.getInstance().setup();
            DRIVER = new FirefoxDriver(new FirefoxOptions().addPreference("intl.accept_languages","en-US"));
        }
        return DRIVER;
    }

    public static WebDriver setupChromeDriver() {
        if(DRIVER == null) {
            ChromeDriverManager.getInstance().setup();
            DRIVER = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        }
        return DRIVER;
    }

    public static WebDriver getWebDriver() {
        if(DRIVER == null) {
            throw new WebDriverException();
        }
        return DRIVER;
    }
}
