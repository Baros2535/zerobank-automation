package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindTransactionsPage extends AccountActivityPage {


    @FindBy(xpath ="//input[@id='aa_description']" )
    public WebElement description;

    @FindBy(css ="#aa_fromDate" )
    public WebElement fromDate;

    @FindBy(css ="#aa_toDate" )
    public WebElement toDate;

    @FindBy(xpath ="//input[@id='aa_fromAmount']" )
    public WebElement fromAmount;

    @FindBy(xpath ="//input[@id='aa_toAmount']" )
    public WebElement toAmount;

    @FindBy(xpath ="//select[@id='aa_type']" )
    public WebElement typeDropDown;

    @FindBy(xpath ="//button[@type='submit']" )
    public WebElement search;

    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[1]" )
    public List<WebElement> dateColumnData ;

    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[2]" )
    public List<WebElement> descriptionColumnData ;

    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[3]" )
    public List<WebElement> depositColumnData ;

     @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[4]" )
    public List<WebElement> withdrawalColumnData ;

}
