package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class PayBillsStepDefs {
    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        new LoginPage().login();
        new AccountSummaryPage().payBills.click();
        new PayBillsPage().addNewPayee.click();
        BrowserUtils.waitFor(2);

    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> information) {
        new AddNewPayeePage().payeeName.sendKeys(information.get("Payee Name"));
        new AddNewPayeePage().payeeAddress.sendKeys(information.get("Payee Address"));
        new AddNewPayeePage().payeeAccount.sendKeys(information.get("Account"));
        new AddNewPayeePage().payeeDetails.sendKeys(information.get("Payee Details"));
        BrowserUtils.waitFor(2);
        new AddNewPayeePage().addButton.click();


    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        BrowserUtils.waitFor(2);
        Assert.assertEquals(expectedMessage,new PayBillsPage().theMessage.getText());
    }


    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new LoginPage().login();
        new AccountSummaryPage().payBills.click();
        new PayBillsPage().purchaseForeignCurrency.click();
        BrowserUtils.waitFor(2);


    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencyOptions) {
        Select select=new Select(new PurchaseForeignCurrencyPage().currencyDropdown);
        List<String> actualCurrencyOptions = BrowserUtils.getElementsText(select.getOptions());

        Assert.assertTrue(actualCurrencyOptions.containsAll(expectedCurrencyOptions));



    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        new PurchaseForeignCurrencyPage().amount.sendKeys("45");
        new PurchaseForeignCurrencyPage().selectedCurrency.click();
        new PurchaseForeignCurrencyPage().calculateButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        Alert alert= Driver.get().switchTo().alert();
        Assert.assertFalse(alert.getText().isEmpty());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Select select=new Select(new PurchaseForeignCurrencyPage().currencyDropdown);
        select.selectByIndex(10);
        new PurchaseForeignCurrencyPage().selectedCurrency.click();
        new PurchaseForeignCurrencyPage().calculateButton.click();
    }



}
