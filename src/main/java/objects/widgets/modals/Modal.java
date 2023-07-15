package objects.widgets.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Modal {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    final By ModalBox = By.cssSelector(".modal.fade.show");
    final By CloseButton = By.xpath("//button[contains(text(),'Close')]");

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
}
