package org.mobiledemo.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "search_query_top")
    private WebElement SEARCH_FIELD;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String searchText) throws InterruptedException {
        SEARCH_FIELD.clear();
        SEARCH_FIELD.sendKeys(searchText);
        Thread.sleep(10);
//        Assert.assertEquals(driver.getTitle(),"My Store");
    }
}
