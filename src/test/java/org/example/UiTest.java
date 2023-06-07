package org.example;

import org.example.listener.UITestListener;
import org.example.po.MyAccountPage;
import org.example.po.ProjectBoardsPage;
import org.example.po.ProjectPage;
import org.example.po.UserEditPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({
        UITestListener.class
})
public class UiTest {
    private final WebDriver driver = DriverPool.setupFirefoxDriver();
    private final OpenProjectBO openProjectBO = new OpenProjectBO();

    private final String user = "admin";
    private final String password = "AJ9zJL@q6At9ujH";


    @DataProvider
    public Object[][] testFDataProvider() {
        return new Object[][]{
                {
                        "Test Project", "Test Board"
                }
        };
    }

    @Test(dataProvider = "testFDataProvider")
    public void fTest(String projectName, String boardName) {
        openProjectBO.loginFromMainPage(user, password);

        ProjectPage projectPage = openProjectBO.createProject(projectName);
        ProjectBoardsPage projectBoardsPage = projectPage.openProjectBoardPage();

        openProjectBO.createBasicBoard(projectBoardsPage, boardName);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(driver.getCurrentUrl().matches("(.+?)/boards/\\d+"));
    }


    @DataProvider
    public Object[][] testSDataProvider() {
        return new Object[][]{
                {
                        "Jhon", "Black", "jb21@gmail.com"
                },
                {
                        "Sam", "White", "sw21@gmail.com"
                }
        };
    }


    @Test(dataProvider = "testSDataProvider")
    public void sTest(String firstName, String lastName, String email) {
        openProjectBO.loginFromMainPage(user, password);
        UserEditPage userEditPage = openProjectBO.createUser(firstName, lastName, email);

        Assert.assertEquals(userEditPage.getStatus(), "invited");
        Assert.assertEquals(userEditPage.getFirstName(), firstName);
        Assert.assertEquals(userEditPage.getLastName(), lastName);
        Assert.assertEquals(userEditPage.getEmail(), email);
    }


    @DataProvider
    public Object[][] testTDataProvider() {
        return new Object[][]{
                {
                        "Yuriiii", "Mytko", "uri200306@gmail.com"
                }
        };
    }

    @Test(dataProvider = "testTDataProvider")
    public void tTest(String firstName, String lastName, String email) {
        openProjectBO.loginFromMainPage(user, password);
        openProjectBO.updateMyData(password, firstName, lastName, email);

        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage
                .openPageByLink()
                .setUsername(user)
                .setPassword(password)
                .submit();

        Assert.assertEquals(myAccountPage.getFirstName(), firstName);
        Assert.assertEquals(myAccountPage.getLastName(), lastName);
        Assert.assertEquals(myAccountPage.getEmail(), email);
    }
}
