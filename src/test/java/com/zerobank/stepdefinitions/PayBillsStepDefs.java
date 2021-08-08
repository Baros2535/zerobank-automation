package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.SoftAssertionsProvider;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class PayBillsStepDefs {
    SoftAssertions softAssertions=new SoftAssertions();
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

    @When("the user enters the following information")
    public void the_user_enters_the_following_information(Map<String,String> information) {
    new Select(new PayBillsPage().payeeDropdown).selectByVisibleText(information.get("Payee"));
    new Select(new PayBillsPage().accountDropdown).selectByVisibleText(information.get("Account"));
try {

    new PayBillsPage().theAmount.sendKeys(information.get("Amount"));
    BrowserUtils.waitFor(2);
    softAssertions.assertThat(BrowserUtils.isNumeric(information.get("Amount"))).isTrue();
    new PayBillsPage().date.sendKeys(information.get("Date"));
    BrowserUtils.waitFor(4);
    new PayBillsPage().description.sendKeys(information.get("Description"));
}
    catch (Exception e){
        System.out.println("Please fill out this field.");

    }

    }


    @When("the user clicks the Pay button")
    public void the_user_clicks_the_Pay_button() {
     new PayBillsPage().payButton.click();
    }

    @Then("the user should see the message as {string}")
    public void the_user_should_see_the_message_as(String expectedMessage) {
        if (expectedMessage.equals("The payment was successfully submitted.")){
            Assert.assertEquals(expectedMessage,new PayBillsPage().theMessage.getText());
        }

        if (expectedMessage.equals("Please fill out this field message!")){
            String actualMessage = Driver.get().findElement(By.name("amount")).getAttribute("validationMessage");
           Assert.assertEquals(expectedMessage,actualMessage);

        }


    }

    @Then("the user should not see the message as {string}")
    public void the_user_should_not_see_the_message_as(String unExpectedMessage) {
      //Assert.assertFalse(unExpectedMessage.equals(new PayBillsPage().theMessage.getText()));
        String actualmessage = new PayBillsPage().theMessage.getText();
        BrowserUtils.waitFor(2);
        softAssertions.assertThat(actualmessage).isNotEqualTo(unExpectedMessage);
        softAssertions.assertAll();

    }



}
