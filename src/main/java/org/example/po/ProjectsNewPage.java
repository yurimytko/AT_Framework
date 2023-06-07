package org.example.po;

import org.example.DriverPool;
import org.example.wrapper.Decorator;
import org.example.wrapper.LateElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsNewPage {
    private static WebDriver driver = DriverPool.getWebDriver();

    @FindBy(xpath = "//*[@id='formly_3_textInput_name_0']")
    private LateElement inputProjectName;

    @FindBy(xpath = "//button[@type='submit']")
    private LateElement buttonSave;

    public ProjectsNewPage() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    public ProjectsNewPage setProjectName(String name){
        inputProjectName.waitForVisible().getWebElement().sendKeys(name);
        return this;
    }

    public ProjectPage submit(){
        buttonSave.waitForVisible().getWebElement().click();
        return new ProjectPage();
    }
}
