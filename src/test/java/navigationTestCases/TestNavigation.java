package navigationTestCases;


import objects.pages.Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestInit;

public class TestNavigation extends TestInit {
    private Page page;
    @Test
    public void navigateFromHomeToCart(){
        page = homePage.getNavBar().navToCart();
        Assert.assertEquals(getCurrentURL(), page.getUrl());
    }
}
