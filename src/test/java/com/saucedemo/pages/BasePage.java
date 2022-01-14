package com.saucedemo.pages;

import com.saucedemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage () {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement generalMenuIcons;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logOutLocator;




}
