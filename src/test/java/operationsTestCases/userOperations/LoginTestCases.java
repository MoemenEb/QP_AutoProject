package operationsTestCases.userOperations;

import objects.widgets.modals.LoginForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestInit;


public class LoginTestCases extends TestInit {
    private LoginForm loginForm;
    private Logger logger = LogManager.getLogger(LoginTestCases.class);

    @BeforeMethod
    public void Setup(){
        loginForm = homePage.getNavBar().navToLogin();
        loginForm.clearForm();
    }
    @Test
    public void invalidLogin(){
        logger.info("Test invalid login");
        loginForm.addToLogin(loginForm.getLoginUserName(),"mon");
        loginForm.addToLogin(loginForm.getLoginPass(),"123");
        loginForm.login();
        softAssert.assertTrue(loginForm.isLogginFail());
        loginForm.closeAlert();
        loginForm.closeModal();
        softAssert.assertAll();
    }


    @Test void validLogin(){
        logger.info("Test valid login");
        loginForm.addToLogin(loginForm.getLoginUserName(),"mon1507");
        loginForm.addToLogin(loginForm.getLoginPass(),"mon1507");
        loginForm.login();
        softAssert.assertTrue(homePage.getNavBar().isLoggedin());
        softAssert.assertTrue(homePage.getNavBar().getWelcomeMsg().contains("mon1507"));
        softAssert.assertAll();
    }

}
