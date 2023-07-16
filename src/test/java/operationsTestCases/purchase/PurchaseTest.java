package operationsTestCases.purchase;

import objects.pages.CartPage;
import objects.pages.HomePage;
import objects.pages.Product;
import objects.widgets.NavBar;
import objects.widgets.modals.PlaceOrder;
import org.testng.annotations.Test;
import utils.TestInit;

public class PurchaseTest extends TestInit {

    private HomePage home;
    private CartPage cartPage;
    private Product productPage;
    private NavBar navBar;
    private PlaceOrder placeOrderForm;
    final int FIRST_ITEM = 0;

    @Test
    public void fullPurchaseCycle(){
        home = new HomePage(getWebDriver());
        home.getCategoriesList().listPhones();
        productPage = home.getCategoriesSection().openProduct(FIRST_ITEM);
        String productName = productPage.getProdcutName();
        productPage.addToCart();
        softAssert.assertTrue(productPage.productAddedToCart());
        productPage.closeAlert();
        cartPage = homePage.getNavBar().navToCart();
        softAssert.assertTrue(productName.equals(cartPage.getCartItemName(FIRST_ITEM)));
        placeOrderForm = cartPage.placeOrder();
        placeOrderForm.isModalVisible();
        placeOrderForm.setName("test");
        placeOrderForm.setCard("123");
        placeOrderForm.doPurchase();
        softAssert.assertTrue(placeOrderForm.getPurchaseAlertHeader().equals(placeOrderForm.getPurchaseDone()));
        softAssert.assertAll();
    }
}
