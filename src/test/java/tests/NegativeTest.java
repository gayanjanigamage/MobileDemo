package tests;

import org.mobiledemo.common.Base;
import org.mobiledemo.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends Base {

    @Test(priority = 1)
    public void invalidLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tg@hl.com","12345");
        Assert.assertEquals(loginPage.getAuthenticationError(),"Authentication failed.");
    }
}
