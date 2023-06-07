package org.example.wrapper;

import org.example.DriverPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LateElement {
    private WebElement webElement;
    private final WebDriver driver = DriverPool.getWebDriver();

    public LateElement(WebElement webElement){
        this.webElement = webElement;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public LateElement waitForVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return this;
    }

    public LateElement waitForClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return this;
    }
}
