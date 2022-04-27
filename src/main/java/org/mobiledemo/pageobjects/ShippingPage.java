package org.mobiledemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BasePage{

    @FindBy(id = "cgv")
    private WebElement CHK_SHIPPING;

    @FindBy(name = "processCarrier")
    private WebElement PROCEED_CHKOUT;

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickTermsOnService(){

        CHK_SHIPPING.click();
    }

    @Override
    public void proceedOnCheckout(){

        PROCEED_CHKOUT.click();
    }
}
