package operationsTestCases.userOperations;

import objects.widgets.modals.SignupForm;
import org.testng.annotations.Test;
import utils.TestInit;

public class SignupTestCases extends TestInit {
    private SignupForm signupForm;
    long currentTimestamp = System.currentTimeMillis();

    @Test
    public void SignupCorrectly()  {
        String userName = "mon_"+currentTimestamp;
        String pass = "mon121213";
        signupForm = homePage.getNavBar().navToSignup();
        signupForm.addUserName(userName);
        signupForm.addPassword(pass);
        signupForm.signUp();
        softAssert.assertTrue(signupForm.isSignUpSuccess());
        softAssert.assertAll();
    }

    @Test
    public void SignupwithExistingData()  {
        String userName = "mon_mon_mon";
        String pass = "mon121213";
        signupForm = homePage.getNavBar().navToSignup();
        signupForm.addUserName(userName);
        signupForm.addPassword(pass);
        signupForm.signUp();
        softAssert.assertFalse(signupForm.isSignUpSuccess());
        softAssert.assertAll();
    }
}
