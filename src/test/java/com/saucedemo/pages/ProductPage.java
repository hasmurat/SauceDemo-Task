package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage {

    @FindBy(className = "title")
    public WebElement subTitleLocator;

    public boolean isSubTitleDisplayed(){
        return subTitleLocator.isDisplayed();
    }

}
