package objects.pages;

import objects.widgets.modals.PlaceOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends Page{

    private String url = "https://www.demoblaze.com/cart.html";
    private By productTable = By.id("tbodyid");
    private By cartItem = By.className("success");
    private By totalPrice = By.id("totalp");
    private By PlaceOrderButton = By.xpath(".//button[contains(text(),'Place Order')]");


    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getUrl() {
        return url;
    }

    public List<WebElement> cartItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
        WebElement table = driver.findElement(productTable);
        return table.findElements(cartItem);
    }

    public String getCartItemName(int index){
       return getColumnData(index).get(1).getText();
    }

    public void deleteItemFromCart(int index){
        getColumnData(index).get(3).findElement(By.linkText("Delete")).click();
    }

    private List<WebElement> getColumnData(int row){
        List<WebElement> cartItems = cartItem();
        return cartItems.get(row).findElements(By.tagName("td"));
    }

    public boolean isCartPageEmpty(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cartItem));
        return driver.findElements(cartItem).isEmpty();
    }

    public int getTotalPrice(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        return Integer.parseInt(driver.findElement(totalPrice).getText());
    }

    public PlaceOrder placeOrder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceOrderButton));
        driver.findElement(PlaceOrderButton).click();
        return new PlaceOrder(driver);
    }
}
