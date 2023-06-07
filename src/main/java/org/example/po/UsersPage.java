package org.example.po;

import org.example.DriverPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
    private static WebDriver driver = DriverPool.getWebDriver();

    @FindBy(css = "a[class$='-alt-highlight']")
    private WebElement linkNewUser;

    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    public UsersNewPage openUserNewPage(){
        linkNewUser.click();
        return new UsersNewPage();
    }
}
