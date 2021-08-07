package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewPayeePage extends PayBillsPage {

    @FindBy(xpath="//input[@id='np_new_payee_name']")
    public WebElement payeeName;

    @FindBy(xpath="//textarea[@id='np_new_payee_address']")
    public WebElement payeeAddress;

    @FindBy(xpath="//input[@id='np_new_payee_account']")
    public WebElement payeeAccount;

    @FindBy(xpath="//input[@id='np_new_payee_details']")
    public WebElement payeeDetails;

    @FindBy(xpath="//input[@id='add_new_payee']")
    public WebElement addButton;


}
