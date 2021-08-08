package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{

    @FindBy(xpath="//a[text()='Pay Saved Payee']")
    public WebElement paySavedPayee;

    @FindBy(xpath="//a[text()='Add New Payee']")
    public WebElement addNewPayee;

    @FindBy(xpath="//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;

    @FindBy(xpath="  //div[@id='alert_content']")
    public WebElement theMessage;

    @FindBy(xpath="//input[@id='sp_amount']")
    public WebElement theAmount;

    @FindBy(css="#sp_account")
    public WebElement accountDropdown;

    @FindBy(css="#sp_description ")
    public WebElement description;

    @FindBy(css="#sp_payee")
    public WebElement payeeDropdown;

    @FindBy(css="#sp_date")
    public WebElement date;

    @FindBy(css="#pay_saved_payees")
    public WebElement payButton;




}
