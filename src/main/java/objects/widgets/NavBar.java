package objects.widgets;

import objects.pages.CartPage;
import objects.pages.HomePage;
import objects.widgets.modals.LoginForm;
import objects.widgets.modals.Modal;
import objects.widgets.modals.SignupForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBar {

    private WebDriver driver;
    private Modal modal;

    final By HomePage = By.linkText("Home ");
    final By CartPage = By.linkText("Cart");

    final By Login = By.linkText("Log in");
    final By Signup = By.linkText("Sign up");
    final By WelcomeUser = By.id("nameofuser");
    private WebDriverWait wait;

    public NavBar(WebDriver webDriver){
        this.driver = webDriver;
        this.modal = new Modal(webDriver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    }


    public HomePage navToHome(){
        wait.until(ExpectedConditions.elementToBeClickable(HomePage));
        driver.findElement(HomePage).click();
        return new HomePage(driver);
    }

    public CartPage navToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(CartPage));
        driver.findElement(CartPage).click();
        return new CartPage(driver);
    }

    public SignupForm navToSignup(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Signup));
        driver.findElement(Signup).click();
        return modal.isModalVisible() ? new SignupForm(driver) : null;
    }

    public LoginForm navToLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(Login));
        driver.findElement(Login).click();
        return modal.isModalVisible() ? new LoginForm(driver) : null;
    }

    public String getWelcomeMsg(){
        return driver.findElement(WelcomeUser).getText();
    }

    public boolean isLoggedin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(WelcomeUser));
        return driver.findElement(WelcomeUser).isDisplayed();
    }
}
