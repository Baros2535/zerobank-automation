package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{

    @FindBy(xpath="//a[text()='Pay Saved Payee']")
    public WebElement paySavedPaye;

    @FindBy(xpath="//a[text()='Add New Payee']")
    public WebElement addNewPayee;

    @FindBy(xpath="//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;

    @FindBy(xpath="  //div[@id='alert_content']")
    public WebElement theMessage;


}
