package org.example.listener;

import io.qameta.allure.Attachment;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.example.DriverPool;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class UITestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        DriverPool.getWebDriver().manage().deleteAllCookies();
        DriverPool.getWebDriver().get("http://localhost:8080/");
        System.out.println("Test " + result.getTestName() + " started");;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        takeScreenshot();
        savePage();
        System.out.println("Test " + result.getTestName() + " finished successfully");;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
        savePage();
        System.out.println("Test " + result.getTestName() + " failed");;
    }

    @Override
    public void onStart(ITestContext context) {
        DriverPool.getWebDriver().manage().window().maximize();
    }

    @Override
    public void onFinish(ITestContext context) {
        DriverPool.getWebDriver().close();
        System.out.println(context.getName() + " finished");;
    }

    @Attachment(value = "Page screen", type = "image/png")
    private byte[] takeScreenshot(){
        System.out.println("Taking screenshot");;

        return ((TakesScreenshot) DriverPool.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page html", type = "text/html")
    private String savePage(){
        System.out.println("Saving page source");;
        return DriverPool.getWebDriver().getPageSource();
    }
}
