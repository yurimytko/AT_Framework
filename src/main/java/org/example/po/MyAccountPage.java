package org.example.po;

import org.example.DriverPool;
import org.example.wrapper.Decorator;
import org.example.wrapper.LateElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private static WebDriver driver = DriverPool.getWebDriver();
    private static String URL = "http://127.0.0.1:8080/my/account";

    @FindBy(css = "input[id$='firstname']")
    private WebElement inputUserFirstname;

    @FindBy(css = "input[id$='lastname']")
    private WebElement inputUserLastname;

    @FindBy(css = "input[id='user_mail']")
    private WebElement inputUserMail;

    @FindBy(css = "button[class^='-highlight']")
    private WebElement buttonSave;

    @FindBy(css = "button[data-qa-selector='confirmation-modal--confirmed']")
    private LateElement buttonConfirm;

    @FindBy(xpath = "//*[@id='request_for_confirmation_password']")
    private LateElement inputRequestForConfirmationPassword;

    public MyAccountPage() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    public LoginPage openPageByLink(){
        driver.get(URL);
        return new LoginPage();
    }

    public MyAccountPage setFirstName(String firstName){
        inputUserFirstname.clear();
        inputUserFirstname.sendKeys(firstName);
        return this;
    }

    public MyAccountPage setLastName(String lastName){
        inputUserLastname.clear();
        inputUserLastname.sendKeys(lastName);
        return this;
    }

    public MyAccountPage setEmail(String email){
        inputUserMail.clear();
        inputUserMail.sendKeys(email);
        return this;
    }

    public MyAccountPage save(){
        buttonSave.click();
        return this;
    }

    public MyAccountPage setConfirmationPassword(String password){
        inputRequestForConfirmationPassword.waitForVisible().getWebElement().sendKeys(password);
        return this;
    }

    public MyAccountPage confirm(){
        buttonConfirm.waitForVisible().waitForClickable().getWebElement().click();
        return this;
    }

    public String getFirstName(){
        return inputUserFirstname.getAttribute("value");
    }

    public String getLastName(){
        return inputUserLastname.getAttribute("value");
    }

    public String getEmail(){
        return inputUserMail.getAttribute("value");
    }
}
