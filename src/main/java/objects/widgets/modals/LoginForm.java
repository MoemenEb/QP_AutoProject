package objects.widgets.modals;

import objects.widgets.NavBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginForm extends Modal{
    final By LoginUserName = By.id("loginusername");
    final By LoginPass = By.id("loginpassword");
    final By LoginSubmit = By.xpath(".//button[contains(text(),'Log in')]");
    final String LoginFail = "Wrong password.";

    final String successfullLogin = "";
    public LoginForm(WebDriver driver){
        super(driver);
    }

    public void addToLogin(By by, String textToAdd){
        webDriver.findElement(by).sendKeys(textToAdd);
    }

    public void login(){
        webDriver.findElement(LoginSubmit).click();
    }

    public By getLoginUserName() {
        return LoginUserName;
    }

    public By getLoginPass() {
        return LoginPass;
    }

    public String getLoginFail() {
        return LoginFail;
    }

    public boolean isLogginFail(){
        return alertText().equals(LoginFail);
    }
}
