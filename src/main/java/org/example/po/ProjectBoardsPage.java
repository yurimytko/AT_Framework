package org.example.po;

import org.example.DriverPool;
import org.example.wrapper.Decorator;
import org.example.wrapper.LateElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectBoardsPage {
    private static WebDriver driver = DriverPool.getWebDriver();

    @FindBy(xpath = "//a[contains(@title, 'new')]")
    public LateElement linkCreateBoard;

    @FindBy(xpath = "//button[.//img[contains(@src, 'lists')]]")
    public LateElement buttonTileBlock;

    public ProjectBoardsPage() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    public ProjectBoardsPage openCreateBoardModal(){
        linkCreateBoard.waitForVisible().getWebElement().click();
        return this;
    }

    public void chooseBasicBoard(){
        buttonTileBlock.waitForVisible().getWebElement().click();
    }
}
