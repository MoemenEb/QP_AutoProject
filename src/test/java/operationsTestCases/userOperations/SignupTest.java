package operationsTestCases.userOperations;

import objects.widgets.modals.SignupForm;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestInit;

public class SignupTest extends TestInit {
    private SignupForm signupForm;
    long currentTimestamp = System.currentTimeMillis();

    @BeforeMethod
    public void prep(){
        getWebDriver().get(homePage.getUrl());
        signupForm = homePage.getNavBar().navToSignup();
        signupForm.clearForm();
    }
    @Test
    public void SignupCorrectly()  {
        String userName = "mon_"+currentTimestamp;
        String pass = "mon121213";
        signupForm.addUserName(userName);
        signupForm.addPassword(pass);
        signupForm.signUp();
        softAssert.assertTrue(signupForm.isSignUpSuccess());
        signupForm.closeAlert();
        softAssert.assertAll();
    }

    @Test
    public void SignupwithExistingData()  {
        String userName = "mon_mon_mon";
        String pass = "mon121213";
        signupForm.addUserName(userName);
        signupForm.addPassword(pass);
        signupForm.signUp();
        softAssert.assertFalse(signupForm.isSignUpSuccess());
        signupForm.closeAlert();
        signupForm.closeModal();
        softAssert.assertAll();
    }
}
