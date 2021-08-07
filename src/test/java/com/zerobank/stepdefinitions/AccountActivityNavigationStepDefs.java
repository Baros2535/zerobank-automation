package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationStepDefs {

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountsLabel) {
       switch (accountsLabel){
           case "Savings":
               new AccountSummaryPage().savings.click();
               break;
           case "Loan":
               new AccountSummaryPage().loan.click();
               break;
           case "Credit Card":
               new AccountSummaryPage().creditCard.click();
               break;
           case "Brokerage":
               new AccountSummaryPage().brokerage.click();
               break;
           case "Checking":
               new AccountSummaryPage().checking.click();
               break;

       }
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        Assert.assertTrue(Driver.get().getTitle().contains("Account Activity"));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String dropDownExpected) {

        Select select=new Select(new AccountActivityPage().accountDropdown);
       Assert.assertEquals(dropDownExpected,select.getFirstSelectedOption().getText());

    }


}
