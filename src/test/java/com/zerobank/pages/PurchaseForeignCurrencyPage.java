package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseForeignCurrencyPage extends PayBillsPage {


    @FindBy(xpath="//input[@id='pc_amount']")
    public WebElement amount;

    @FindBy(css="#pc_currency")
    public WebElement currencyDropdown;

    @FindBy(xpath="//input[@id='pc_inDollars_true']")
    public WebElement dollarUSD;

    @FindBy(xpath="//input[@id='pc_inDollars_false']")
    public WebElement selectedCurrency;

    @FindBy(xpath=" //input[@id='pc_calculate_costs']")
    public WebElement calculateButton;

    @FindBy(xpath="//input[@id='purchase_cash']")
    public WebElement purchaseButton;






}
