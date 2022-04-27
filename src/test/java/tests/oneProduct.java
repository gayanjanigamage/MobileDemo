package tests;

import org.mobiledemo.common.Base;
import org.mobiledemo.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class oneProduct extends Base {


    @Test(priority = 0)
    public void navigateToHomePage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ShippingPage shippingPage = new ShippingPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        homePage.search("t shirt");
        cartPage.emptyCart();
        cartPage.addToCart();
        Assert.assertTrue(cartPage.onCartPage());
        cartPage.proceedOnCheckout();
        loginPage.login("gayanjanigamage@gmail.com","Password1234");
        cartPage.goToCheckoutPage();
        cartPage.proceedOnCheckout();
        Assert.assertTrue(checkoutPage.isDeliveryAddressVisible());
        Assert.assertTrue(checkoutPage.isBillingAddressVisible());
        checkoutPage.proceedOnCheckout();
        shippingPage.clickTermsOnService();
        shippingPage.proceedOnCheckout();
        assertThat(paymentPage.verifyPaymentMethods())
                .contains("Pay by bank wire (order processing will be longer)", "Pay by check (order processing will be longer)");
    }
}
