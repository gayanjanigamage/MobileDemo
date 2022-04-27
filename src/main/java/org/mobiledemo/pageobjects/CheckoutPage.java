package org.mobiledemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    @FindBy(id = "address_delivery")
    private WebElement DILIVERY_ADDREDD;

    @FindBy(id = "address_invoice")
    private WebElement BILLING_ADDREDD;

    @FindBy(css = "[name='processAddress']")
    private WebElement BTN_PROCEED;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDeliveryAddressVisible(){
        return DILIVERY_ADDREDD.isDisplayed();
    }

    public boolean isBillingAddressVisible(){
        return BILLING_ADDREDD.isDisplayed();
    }

    @Override
    public void proceedOnCheckout(){
        BTN_PROCEED.click();
    }
}
