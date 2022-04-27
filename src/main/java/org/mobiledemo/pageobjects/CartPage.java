package org.mobiledemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class CartPage extends BasePage {

    private WebDriver driver;

    @FindBy(css = "[title='Faded Short Sleeve T-shirts'] :nth-of-type(1)")
    private WebElement TSHIRT;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    private WebElement BTN_ADDTO_CART;

    @FindBy(css = "[title='Proceed to checkout']")
    private WebElement BTN_PROCEED;

    @FindBy(css = "[title='View my shopping cart']")
    private WebElement MY_CART;

    @FindBy(css = "#button_order_cart > span")
    private WebElement GO_TO_CHECKOUT;

    @FindBy(css = ".remove_link")
    private List<WebElement> REMOVE ;

    @FindBy(css = ".ajax_cart_no_product")
    private WebElement EMPTY_MSG ;

    @FindBy(id = "cart_title")
    private WebElement CART_TITLE ;

    @FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
    private WebElement PROCEED_CHKOUT ;


    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart(){
        hoverOnElement(TSHIRT);
        waitForElement(BTN_ADDTO_CART);
        BTN_ADDTO_CART.click();
        scrollToElement(BTN_PROCEED);
        BTN_PROCEED.click();
    }

    public void goToCheckoutPage(){
       clickByJS(MY_CART);
       clickByJS(GO_TO_CHECKOUT);
    }

    public boolean onCartPage(){
        waitForElement(CART_TITLE);
        scrollToElement(CART_TITLE);
        return CART_TITLE.isDisplayed();
    }

    public void emptyCart(){
        if(EMPTY_MSG.isDisplayed()){
            System.out.println("Cart is empty");
        }else{
            hoverOnElement(MY_CART);
            for(WebElement element : REMOVE){
                element.click();
            }
        }
    }

    @Override
    public void proceedOnCheckout(){
        scrollToElement(PROCEED_CHKOUT);
        PROCEED_CHKOUT.click();
    }

}
