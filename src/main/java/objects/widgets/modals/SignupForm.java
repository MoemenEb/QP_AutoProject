package objects.widgets.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class SignupForm extends Modal{

    final By SignUserName = By.id("sign-username");
    final By SignPass = By.id("sign-password");
    final By Submit = By.xpath(".//button[contains(text(),'Sign up')]");

    final String successfullSignUp = "Sign up successful.";

    public SignupForm(WebDriver driver) {
        super(driver);
    }


    public void addUserName(String userName){
        webDriver.findElement(SignUserName).sendKeys(userName);
    }

    public void addPassword(String pass){
        webDriver.findElement(SignPass).sendKeys(pass);
    }

    public void signUp(){
        webDriver.findElement(Submit).click();
    }

    public boolean isSignUpSuccess() {
        return alertText().equals(successfullSignUp);
    }

    public void clearForm(){
        webDriver.findElement(SignUserName).clear();
        webDriver.findElement(SignPass).clear();
    }
}
