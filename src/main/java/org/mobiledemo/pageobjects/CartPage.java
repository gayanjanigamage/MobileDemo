package org.mobiledemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    @FindBy(css = "[title='Continue shopping']")
    private WebElement CONTINUE_SHOP ;

    @FindBy(css = "a[title='Women']")
    private WebElement WOMEN_MENU ;

    @FindBy(css = "h1 span.cat-name")
    private WebElement WOMEN_CAT ;

    @FindBy(className = "cat-title")
    private WebElement CAT_TITLE ;

    @FindBy(className = "cart_item")
    private List <WebElement> CART_ITEMS ;


    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart(){
        hoverOnElement(TSHIRT);
        clickByJS(BTN_ADDTO_CART);
        clickByJS(BTN_PROCEED);

    }

    public void addtwoProductsToCart(String product1,String product2){

        List<String> list = new ArrayList<String>(Arrays.asList(product1,product2)) ;
        for (String s: list) {
            WebElement element = driver.findElement(By.cssSelector("[data-id-product='"+s+"'] span"));
            WebElement product = driver.findElement(By.cssSelector("ul.product_list > li:nth-child("+s+")"));
            hoverOnElement(product);
            clickByJS(element);
            clickByJS(CONTINUE_SHOP);
        }

    }

    public void goToWomenMenu(){
        clickByJS(CAT_TITLE);
        clickByJS(WOMEN_MENU);
        waitForElement(WOMEN_CAT);
    }

    public void goToCheckoutPage(){
        waitForElementAndClick(MY_CART);
        waitForElementAndClick(GO_TO_CHECKOUT);
    }

    public boolean onCartPage(){
        scrollToElement(CART_TITLE);
        return CART_TITLE.isDisplayed();
    }

    public void emptyCart(){
        if(EMPTY_MSG.isDisplayed()){
            System.out.println("Cart is empty");
        }else{
            hoverOnElement(MY_CART);
            for(WebElement element : REMOVE){
                clickByJS(element);
            }
        }
    }

    @Override
    public void proceedOnCheckout(){
        clickByJS(PROCEED_CHKOUT);
    }

    public int getNumberOfCartItems(){
        return CART_ITEMS.size();
    }

}
