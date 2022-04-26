package org.mobiledemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    private WebDriver driver;

    @FindBy(css = ".login")
    private WebElement SIGN_IN_BTN;

    @FindBy(id = "email")
    private WebElement USERID_FIELD;

    @FindBy(id = "passwd")
    private WebElement PASSWORD_FIELD;

    @FindBy(id = "SubmitLogin")
    private WebElement LOGIN_BTN;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        SIGN_IN_BTN.click();
        USERID_FIELD.clear();
        USERID_FIELD.sendKeys("gayanjanigamage@gmail.com");
        PASSWORD_FIELD.clear();
        PASSWORD_FIELD.sendKeys("Password1234");
        LOGIN_BTN.click();

    }
}
