package operationsTestCases.search;

import objects.pages.HomePage;
import objects.widgets.categories.CategoriesList;
import objects.widgets.categories.CategoriesSection;
import org.testng.annotations.Test;
import utils.TestInit;

public class TestCategoriesListing extends TestInit {

    private HomePage page;
    private CategoriesList list;
    private CategoriesSection itemSection;


    @Test
    public void TestPhoneCategories(){
        page = new HomePage(getWebDriver());
        list = page.getCategoriesList();
        list.listPhones();
        itemSection = page.getCategoriesSection();
        softAssert.assertTrue(itemSection.countItems() > 0);
        softAssert.assertAll();
    }


    @Test
    public void TestLaptopCategories(){
        page = new HomePage(getWebDriver());
        list = page.getCategoriesList();
        list.listLaptops();
        itemSection = page.getCategoriesSection();
        softAssert.assertTrue(itemSection.countItems() > 0);
        softAssert.assertAll();
    }


    @Test
    public void TestMonitorCategories(){
        page = new HomePage(getWebDriver());
        list = page.getCategoriesList();
        list.listMonitors();
        itemSection = page.getCategoriesSection();
        softAssert.assertTrue(itemSection.countItems() > 0);
        softAssert.assertAll();
    }
}
