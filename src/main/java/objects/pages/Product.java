package objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Product extends Page{
    final By ADD_TO_CART = By.linkText("Add to cart");
    final By productName = By.tagName("h2");
    final String productedAdded = "Product added";

    public void addToCart(){
        driver.findElement(ADD_TO_CART).click();
    }

    public boolean productAddedToCart(){
        wait.until(ExpectedConditions.alertIsPresent());
       return driver.switchTo().alert().getText().equals(productedAdded);
    }

    public String getProdcutName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        return driver.findElement(productName).getText();
    }
}
