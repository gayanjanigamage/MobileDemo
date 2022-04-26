package Tests;

import org.mobiledemo.common.Base;
import org.mobiledemo.pageobjects.HomePage;
import org.mobiledemo.pageobjects.LoginPage;
import org.testng.annotations.Test;

public class oneProduct extends Base {

    @Test
    public void navigateToHomePage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        
       homePage.search("t shirt");

    }
}
