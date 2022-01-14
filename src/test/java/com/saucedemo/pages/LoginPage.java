package com.saucedemo.pages;

import com.saucedemo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    public WebElement usernameInputLocator;

    @FindBy(id = "password")
    public WebElement passwordInputLocator;

    @FindBy(id = "login-button")
    public WebElement loginButtonLocator;


    public String warningMessage(String warning){
            WebElement message = Driver.get().findElement(By.xpath("//h3[text()='"+warning+"']"));
            return message.getText();
    }

}

