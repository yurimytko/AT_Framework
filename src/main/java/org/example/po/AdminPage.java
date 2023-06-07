package org.example.po;

import org.example.DriverPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    private final WebDriver driver = DriverPool.getWebDriver();

    @FindBy(css = "html > body > div:nth-of-type(2) > div:nth-of-type(1) > main > div:nth-of-type(2) > div:nth-of-type(2) > a:nth-of-type(1)")
    private WebElement usersAndPermissionLink;

    

    public AdminPage(){
        PageFactory.initElements(driver, this);
    }

    public UsersPage openUsersPage(){
        usersAndPermissionLink.click();
        return new UsersPage();
    }
}
