package objects.widgets.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Modal {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    final By ModalBox = By.cssSelector(".modal.fade.show");

    public Modal(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
    }


    public boolean isModalVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModalBox));
        return webDriver.findElement(ModalBox).isDisplayed();
    }


    public String alertText(){
        wait.until(ExpectedConditions.alertIsPresent());
        return webDriver.switchTo().alert().getText();
    }

    public void closeModal(){
        webDriver.findElement(ModalBox).sendKeys(Keys.ESCAPE);
    }

    public void closeAlert(){
        webDriver.switchTo().alert().accept();
    }
}
