package objects.widgets.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginForm extends Modal{
    final By LoginUserName = By.id("loginusername");
    final By LoginPass = By.id("loginpassword");
    final By LoginSubmit = By.xpath(".//button[contains(text(),'Log in')]");
    final String LoginFail = "Wrong password.";

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

    public boolean isLogginFail(){
        wait.until(ExpectedConditions.alertIsPresent());
        return alertText().equals(LoginFail);
    }

    public void clearForm(){
        webDriver.findElement(LoginUserName).clear();
        webDriver.findElement(LoginPass).clear();
    }
}
