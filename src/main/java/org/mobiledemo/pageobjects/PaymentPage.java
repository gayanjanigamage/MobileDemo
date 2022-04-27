package org.mobiledemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PaymentPage extends BasePage {

    @FindBy(className = "bankwire")
    private WebElement BANK_WIRE;

    @FindBy(className = "cheque")
    private WebElement CHEQUE;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void proceedOnCheckout() {
    }

    public List<String> verifyPaymentMethods(){
        List<String> payments = new ArrayList<String>();
        payments.add(getText(BANK_WIRE));
        payments.add(getText(CHEQUE));
       return payments;
    }
}
