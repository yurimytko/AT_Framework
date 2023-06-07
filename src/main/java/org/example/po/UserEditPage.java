package org.example.po;

import org.example.DriverPool;
import org.example.wrapper.Decorator;
import org.example.wrapper.LateElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserEditPage {
    private static WebDriver driver = DriverPool.getWebDriver();

    @FindBy(xpath = "/html/body/div[2]/div[1]/main/div[2]/div[2]/section/div/div/span/span")
    private LateElement status;

    @FindBy(css = "input[id$='firstname']")
    private WebElement inputUserFirstname;

    @FindBy(css = "input[id$='lastname']")
    private WebElement inputUserLastname;

    @FindBy(css = "input[id='user_mail']")
    private WebElement inputUserMail;

    public UserEditPage() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    public String getStatus(){
        return status.waitForVisible().getWebElement().getText();
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
