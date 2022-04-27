package tests;

import org.mobiledemo.common.Base;
import org.mobiledemo.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TwoProductsTest extends Base {


    @Test(priority = 0)
    public void verifyMultipleProductPurchase() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ShippingPage shippingPage = new ShippingPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        cartPage.goToWomenMenu();
        cartPage.addtwoProductsToCart("2","7");
        cartPage.goToCheckoutPage();
        Assert.assertEquals(cartPage.getNumberOfCartItems(),2);
        cartPage.proceedOnCheckout();
        loginPage.login("gayanjanigamage@gmail.com","Password1234");
        cartPage.goToCheckoutPage();
        Assert.assertEquals(cartPage.getNumberOfCartItems(),2);
        cartPage.proceedOnCheckout();
        Assert.assertTrue(checkoutPage.isDeliveryAddressVisible(),"Delivery Address is not visible on the page");
        Assert.assertTrue(checkoutPage.isBillingAddressVisible(),"Billing Address is not visible on the page");
        checkoutPage.proceedOnCheckout();
        shippingPage.clickTermsOnService();
        shippingPage.proceedOnCheckout();
        assertThat(paymentPage.verifyPaymentMethods())
                .contains("Pay by bank wire (order processing will be longer)",
                        "Pay by check (order processing will be longer)");
    }
}
