package org.example.po;

import org.example.DriverPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersNewPage {
    private static WebDriver driver = DriverPool.getWebDriver();

    @FindBy(css = "input[id$='firstname']")
    private WebElement inputUserFirstname;

    @FindBy(css = "input[id$='lastname']")
    private WebElement inputUserLastname;

    @FindBy(css = "input[id='user_mail']")
    private WebElement inputUserMail;

    @FindBy(css = "button[name='button']")
    private WebElement buttonCreate;

    public UsersNewPage() {
        PageFactory.initElements(driver, this);
    }

    public UsersNewPage setFirstName(String firstName){
        inputUserFirstname.sendKeys(firstName);
        return this;
    }

    public UsersNewPage setLastName(String lastName){
        inputUserLastname.sendKeys(lastName);
        return this;
    }

    public UsersNewPage setEmail(String email){
        inputUserMail.sendKeys(email);
        return this;
    }

    public UserEditPage submitCreation(){
        buttonCreate.click();
        return new UserEditPage();
    }
}
