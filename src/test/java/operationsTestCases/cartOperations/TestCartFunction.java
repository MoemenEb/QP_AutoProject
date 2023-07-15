package operationsTestCases.cartOperations;

import objects.pages.CartPage;
import objects.pages.HomePage;
import objects.pages.Product;
import objects.widgets.NavBar;
import org.testng.annotations.Test;
import utils.TestInit;

public class TestCartFunction extends TestInit {
    private HomePage home;
    private CartPage cartPage;
    private Product productPage;
    private NavBar navBar;
    final int FIRST_ITEM = 0;


    @Test
    public void addItemToCart(){
        home = new HomePage(getWebDriver());
        home.getCategoriesList().listPhones();
        productPage = home.getCategoriesSection().openProduct(FIRST_ITEM);
        String productName = productPage.getProdcutName();
        productPage.addToCart();
        softAssert.assertTrue(productPage.productAddedToCart());
        productPage.closeAlert();
        cartPage = homePage.getNavBar().navToCart();
        softAssert.assertTrue(productName.equals(cartPage.getCartItemName(FIRST_ITEM)));
        softAssert.assertAll();
    }

    @Test
    public void removeItemFromCart(){
        home = new HomePage(getWebDriver());
        home.getCategoriesList().listPhones();
        productPage = home.getCategoriesSection().openProduct(FIRST_ITEM);
        String productName = productPage.getProdcutName();
        productPage.addToCart();
        softAssert.assertTrue(productPage.productAddedToCart());
        productPage.closeAlert();
        cartPage = homePage.getNavBar().navToCart();
        softAssert.assertTrue(productName.equals(cartPage.getCartItemName(FIRST_ITEM)));
        cartPage.deleteItemFromCart(FIRST_ITEM);
        softAssert.assertTrue(cartPage.isCartPageEmpty());
        softAssert.assertAll();
    }





}
