package com.saucedemo.step_definitions;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.utilities.BrowserUtils;
import com.saucedemo.utilities.ConfigurationReader;
import com.saucedemo.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public class LoginStepDefs extends LoginPage {
    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("User enters {string} into username input")
    public void user_enters_into_username_input(String string) {
        usernameInputLocator.sendKeys(string);
    }

    @When("User enters {string} into password input")
    public void user_enters_into_password_input(String string) {
        passwordInputLocator.sendKeys(string);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginButtonLocator.click();
    }

    @Then("User can see Product Page")
    public void user_can_see_Product_Page() {
        boolean isPassed=false;
        try{
            BrowserUtils.waitForVisibility(new ProductPage().subTitleLocator, 7);
            isPassed=new ProductPage().isSubTitleDisplayed();
            Assert.assertTrue(isPassed);
        }catch (TimeoutException e){
            Assert.assertTrue(isPassed);
        }
    }

    @Then("User can see warning message {string}")
    public void user_can_see_warning_message(String string) {
        Assert.assertEquals(string,warningMessage(string));
    }

    @And("User hits Enter Button on keyword")
    public void userHitsEnterButtonOnKeyword() {
        passwordInputLocator.sendKeys(Keys.ENTER);
    }

    @Then("User can not login")
    public void userCanNotLogin() {
        boolean isPassed=false;
        try {
            isPassed = new ProductPage().isSubTitleDisplayed();
            Assert.assertFalse(isPassed);
        }catch (NoSuchElementException e){
            Assert.assertFalse(isPassed);
        }
    }

    @When("User clicks on general menu icon")
    public void user_clicks_on_general_menu_icon() {
        BrowserUtils.jseClick(generalMenuIcons);
    }

    @When("User logouts")
    public void user_logouts() {
        logOutLocator.click();
    }

    @When("User navigates back")
    public void user_navigates_back() throws InterruptedException {
        Driver.get().navigate().back();
        Thread.sleep(2000);
    }

    @Then("User can not go back product page")
    public void user_can_not_go_back_product_page() {
       userCanNotLogin();
    }

}
