package org.mobiledemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage{

    private WebDriver driver;

    @FindBy(css = ".login")
    private WebElement SIGN_IN_BTN;

    @FindBy(id = "email")
    private WebElement USERID_FIELD;

    @FindBy(id = "passwd")
    private WebElement PASSWORD_FIELD;

    @FindBy(id = "SubmitLogin")
    private WebElement LOGIN_BTN;

    @FindBy(css = "div.alert ol")
    private WebElement AUTH_ERROR;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String email,String password) throws InterruptedException {
        clickByJS(SIGN_IN_BTN);
        typeText(USERID_FIELD,email);
        typeText(PASSWORD_FIELD,password);
        clickByJS(LOGIN_BTN);
        Thread.sleep(6000);

    }

    public String getAuthenticationError(){
        return AUTH_ERROR.getText();
    }

    @Override
    public void proceedOnCheckout() {

    }
}
