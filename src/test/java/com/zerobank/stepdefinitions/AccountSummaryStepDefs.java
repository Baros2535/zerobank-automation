package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {


    @Then("Account summary page should have to following account types")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedAccountTypes) {

    Assert.assertEquals(expectedAccountTypes, BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes));

    }

    @Then("The user should see the columns under the Credit Accounts table")
    public void the_user_should_see_the_columns_under_the_Credit_Accounts_table(List<String> expectedCreditAccountColumns) {
      Assert.assertEquals(expectedCreditAccountColumns,BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountTableColumns));
    }




}
