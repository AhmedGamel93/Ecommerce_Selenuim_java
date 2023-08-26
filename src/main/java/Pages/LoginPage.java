package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private  WebDriver driver ;

    private By usernameElement = By.id("user-name");
    private By passwordElement = By.id("password");
    private By loginButton = By.id("login-button");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutButton =By.id("logout_sidebar_link");
    private By alertMessage =  By.tagName("h3");




    public LoginPage(WebDriver driver) {this.driver =driver;
    }


    public void setUserName(String userName)
    {
        driver.findElement(usernameElement).sendKeys(userName);
    }

    public void setPassword(String password)
    {
        driver.findElement(passwordElement).sendKeys(password);
    }

    public HomePage clickLoginButton()
    {
        driver.findElement(loginButton).click();
        return new HomePage (driver);
    }

    public void logOut()
    {
        driver.findElement(menuButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logoutButton)));
        driver.findElement(logoutButton).click();

    }

  public void clearFields( )
  {
      driver.findElement(usernameElement).clear();
      driver.findElement(passwordElement).clear();
  }

  public String getAlertMessage()
  {
      return driver.findElement(alertMessage).getText();
  }

}
