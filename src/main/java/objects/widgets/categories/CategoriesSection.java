package objects.widgets.categories;

import objects.pages.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoriesSection {
    private WebDriver driver;
    final By SectionDIV = By.id("tbodyid");
    final By ItemDiv = By.cssSelector(".col-lg-4.col-md-6.mb-4");
    final By Card = By.className("card-block");
    private WebDriverWait wait;



    public CategoriesSection(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public int countItems(){
        return listItems().size();
    }

    public WebElement findCardObject(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Card));
        return listItems().get(index).findElement(Card);
    }

    public Card getCard(int index){
        return new Card(findCardObject(index),driver);
    }



    public List<WebElement> listItems(){
        WebElement parent = driver.findElement(SectionDIV);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ItemDiv));
        return parent.findElements(ItemDiv);
    }

    public Product openProduct(int index){
        findCardObject(index).findElement(By.tagName("h4")).click();
        return new Product();
    }
}

