package com.saucedemo.pages;

import com.saucedemo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.security.util.Password;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

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

