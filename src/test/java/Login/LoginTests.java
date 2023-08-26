package Login;

import Base.BaseTests;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test(priority = 0)
    public void SuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearFields();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        var homepage = loginPage.clickLoginButton();
        var HomePageUrl = homepage.getHomePageUrl();
        Assert.assertTrue(HomePageUrl.contains("https://www.saucedemo.com/inventory.html"), "Home Page URl Is not correct");
        loginPage.logOut();
    }

    @Test(priority = 1)
    public void UnsuccessfulLogin_WrongUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearFields();
        loginPage.setUserName("wrongUsername");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        var alertMessage = loginPage.getAlertMessage();
        Assert.assertTrue(alertMessage.contains("Epic sadface: Username and password do not match any user in this service"),"Incorrect Alert message");


    }

    @Test(priority = 2)
    public void UnsuccessfulLogin_WrongPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearFields();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("wrongPassword");
        loginPage.clickLoginButton();
        var alertMessage = loginPage.getAlertMessage();
        Assert.assertTrue(alertMessage.contains("Epic sadface: Username and password do not match any user in this service"),"Incorrect Alert message");

    }
}
