package org.example.po;

import org.example.DriverPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static WebDriver driver = DriverPool.getWebDriver();

    @FindBy(css = "input[id='username']")
    private WebElement inputUsername;

    @FindBy(css = "input[id='password']")
    private WebElement inputPassword;

    @FindBy(css = "input[data-disable-with='Loading...']")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUsername(String username){
        inputUsername.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public void submit(){
        loginButton.click();
    }
}
