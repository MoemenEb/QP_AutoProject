package objects.widgets.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesList {

    private WebDriver driver;
    final By Phones = By.linkText("Phones");
    final By Laptops = By.linkText("Laptops");
    final By Monitors = By.linkText("Monitors");

    public CategoriesList(WebDriver webDriver) {
        driver = webDriver;
    }


    public void listPhones(){
        driver.findElement(Phones).click();
    }

    public void listLaptops(){
        driver.findElement(Laptops).click();
    }

    public void listMonitors(){
        driver.findElement(Monitors).click();
    }
}
