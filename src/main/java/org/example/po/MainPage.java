package org.example.po;

import org.example.DriverPool;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver = DriverPool.getWebDriver();

    @FindBy(css = "a[title^='Sign']")
    private WebElement linkSign;

    @FindBy(css = "input[id='username-pulldown']")
    private WebElement inputUsername;

    @FindBy(css = "input[id='password-pulldown']")
    private WebElement inputPassword;

    @FindBy(css = "input[id='login-pulldown']")
    private WebElement loginButton;

    @FindBy(css = "a[icon='overridden-by-avatar']")
    private WebElement linkOpenUserManage;

    @FindBy(css = "a[class^='administration-menu-item']")
    private WebElement administrationLink;

    @FindBy(css = "a[class^='my-account-menu-item']")
    private WebElement myAccountDataLink;

    @FindBy(css = "a[class*='op-quick-add-menu--button']")
    private WebElement linkOpenQuickAddMenu;

    @FindBy(css = "a[class^='new-project-menu-item']")
    public WebElement newProjectLink;

    
    
    public MainPage(){
        PageFactory.initElements(driver, this);
    }

    public MainPage openLogin(){
        linkSign.click();
        return this;
    }

    public MainPage setUsername(String username){
        inputUsername.sendKeys(username);
        return this;
    }

    public MainPage setPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public void login(){
        loginButton.click();
    }

    public MainPage openUserManage(){
        linkOpenUserManage.click();
        return this;
    }

    public AdminPage openAdministrationPage(){
        administrationLink.click();
        return new AdminPage();
    }

    public MyAccountPage openMyAccountPage(){
        myAccountDataLink.click();
        return new MyAccountPage();
    }

    public MainPage openQuickAccessMenu(){
        linkOpenQuickAddMenu.click();
        return this;
    }

    public ProjectsNewPage openProjectCreationPage(){
        newProjectLink.click();
        return new ProjectsNewPage();
    }

}
