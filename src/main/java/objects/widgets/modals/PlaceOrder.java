package objects.widgets.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaceOrder extends Modal{

    final By Total = By.id("totalm");
    final By Name = By.id("name");
    final By Credit = By.id("card");
    final By PurchaseButton = By.xpath(".//button[contains(text(),'Purchase')]");

    final By SweetAlert = By.cssSelector(".sweet-alert.showSweetAlert.visible");
    private WebElement purchaseAlert;
    final String purchaseDone = "Thank you for your purchase!";



    public PlaceOrder(WebDriver webDriver){super(webDriver);}

    public void setName(String name){
        webDriver.findElement(Name).sendKeys(name);
    }

    public void setCard(String card){
        webDriver.findElement(Credit).sendKeys(card);
    }

    public void doPurchase(){
        webDriver.findElement(PurchaseButton).click();
    }

    private void checkPurchase(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SweetAlert));
        this.purchaseAlert = webDriver.findElement(SweetAlert);
    }

    public String  getPurchaseAlertHeader(){
        checkPurchase();
        return this.purchaseAlert.findElement(By.tagName("h2")).getText();
    }

    public String getPurchaseDone() {
        return purchaseDone;
    }
}
