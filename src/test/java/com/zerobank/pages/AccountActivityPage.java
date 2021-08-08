package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage {
    @FindBy(xpath = "//select[@name='accountId']")
    public WebElement accountDropdown;

    @FindBy(xpath = "//a[text()='Show Transactions']")
    public WebElement showTransations;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    public WebElement findTransations;

    @FindBy(xpath = "//thead/tr/th")
    public List <WebElement> transactionsColumns;


}
