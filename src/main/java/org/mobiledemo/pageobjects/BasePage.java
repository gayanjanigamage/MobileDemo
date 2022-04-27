package org.mobiledemo.pageobjects;

import org.mobiledemo.common.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage extends Base {

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void hoverOnElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element);

    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public abstract void proceedOnCheckout();

    public String getText(WebElement element){
        return element.getText();
    }

    public void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

}
