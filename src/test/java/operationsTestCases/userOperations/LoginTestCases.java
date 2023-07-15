package operationsTestCases.userOperations;

import objects.widgets.modals.LoginForm;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestInit;


public class LoginTestCases extends TestInit {
    private LoginForm loginForm;

    @BeforeMethod
    public void Setup(){
        loginForm = homePage.getNavBar().navToLogin();
    }
    @Test
    public void invalidLogin(){
        loginForm.addToLogin(loginForm.getLoginUserName(),"mon");
        loginForm.addToLogin(loginForm.getLoginPass(),"123");
        loginForm.login();
        softAssert.assertTrue(loginForm.isLogginFail());
        softAssert.assertAll();
    }


    @Test void validLogin(){
        loginForm.addToLogin(loginForm.getLoginUserName(),"mon1507");
        loginForm.addToLogin(loginForm.getLoginPass(),"mon1507");
        loginForm.login();
        softAssert.assertTrue(homePage.getNavBar().isLoggedin());
        softAssert.assertTrue(homePage.getNavBar().getWelcomeMsg().contains("mon1507"));
        softAssert.assertAll();
    }

}
