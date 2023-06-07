package org.example;

import org.example.po.*;
import org.openqa.selenium.WebDriver;

public class OpenProjectBO {
    private WebDriver driver = DriverPool.getWebDriver();
    private MainPage mainPage = new MainPage();
    private LoginPage loginPage = new LoginPage();

    public OpenProjectBO() {
    }

    public void loginFromLoginPage(String user, String password){
        loginPage
                .setUsername(user)
                .setPassword(password)
                .submit();
    }

    public void loginFromMainPage(String user, String password) {
        mainPage
                .openLogin()
                .setUsername(user)
                .setPassword(password)
                .login();
    }

    public UserEditPage createUser(String firstName, String lastName, String email) {
        return mainPage
                .openUserManage()
                .openAdministrationPage()
                .openUsersPage()
                .openUserNewPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .submitCreation();
    }

    public void updateMyData(String password, String firstName, String lastName, String email) {
        mainPage
                .openUserManage()
                .openMyAccountPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .save()
                .setConfirmationPassword(password)
                .confirm();
    }

    public MyAccountPage openMyDataPage() {
        return mainPage
                .openUserManage()
                .openMyAccountPage();
    }

    public ProjectPage createProject(String name){
        return mainPage
                .openQuickAccessMenu()
                .openProjectCreationPage()
                .setProjectName(name)
                .submit();
    }

    public void createBasicBoard(ProjectBoardsPage projectBoardsPage, String name){
        projectBoardsPage
                .openCreateBoardModal()
                .chooseBasicBoard();
    }
}
