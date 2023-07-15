package objects.pages;

import objects.widgets.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    private String url;
    protected NavBar navBar;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public Page(){}
    public Page(WebDriver webDriver){
        driver = webDriver;
        navBar = new NavBar(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String getUrl(){return url;}

    public NavBar getNavBar() {
        return navBar;
    }

    public void closeAlert(){
        driver.switchTo().alert().accept();
    }

}
