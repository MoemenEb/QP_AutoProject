package objects.widgets.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Card {
    final By CardTitle = By.className("card-title");
    final By CardPrice = By.tagName("h5");
    final By CardDescription = By.id("article");
    private WebElement card;
    private WebDriver webDriver;

    public Card(WebElement element, WebDriver driver){
        card = element;
        webDriver = driver;
    }

    public String getCardTitle(){
        return card.findElement(CardTitle).getText();
    }

    public String getCardPrice(){
        return card.findElement(CardPrice).getText();
    }

    public String getCardDesc(){
        return card.findElement(CardDescription).getText();
    }

    public void printCardDetails(){
        System.out.println("Title: " + getCardTitle());
        System.out.println("Price: " + getCardPrice());
        System.out.println("Description: " + getCardDesc());
    }

}
