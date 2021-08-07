package com.zerobank.stepdefinitions;

import com.oracle.tools.packager.Log;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        new LoginPage().login();
    }

    @Given("the user is logged in {string} and {string}")
    public void the_user_is_logged_in(String username, String password) {
        new LoginPage().login(username,password);
    }

    @Then("the user should see the title {string}")
    public void the_user_should_see_the_title(String expectedPageTitle) {
        Assert.assertEquals(expectedPageTitle,  Driver.get().getTitle());

    }

    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage,new LoginPage().errorMessage.getText());

    }



}
