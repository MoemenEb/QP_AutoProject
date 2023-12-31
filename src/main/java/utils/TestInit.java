package utils;

import objects.pages.HomePage;
import objects.pages.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;


public class TestInit {
    protected static Page homePage;
    private static WebDriver webDriver;
    protected static SoftAssert softAssert;
    protected static Logger logger;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        logger = LogManager.getLogger(TestInit.class);
        logger.info("Before Suite ");
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        webDriver.get(homePage.getUrl());
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void testFinish(){
        logger.info("Quit Chrome");
        webDriver.quit();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static Page getPage() {
        return homePage;
    }

    public String getCurrentURL(){
        return webDriver.getCurrentUrl();
    }

    public static Logger getLogger() {
        return logger;
    }
}
