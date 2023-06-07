package org.example.po;

import org.example.DriverPool;
import org.example.wrapper.Decorator;
import org.example.wrapper.LateElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {
    private static WebDriver driver = DriverPool.getWebDriver();

    @FindBy(xpath = "//a[@title='Boards']")
    private LateElement linkProjectBoards;

    public ProjectPage() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    public ProjectBoardsPage openProjectBoardPage() {
        linkProjectBoards.waitForVisible().getWebElement().click();
        return new ProjectBoardsPage();
    }
}
