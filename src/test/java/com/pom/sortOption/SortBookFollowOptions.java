package com.pom.sortOption;

import com.basepage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SortBookFollowOptions extends AbstractBasePage {
    WebElement driver;
    //Constructor of class LoginPageEmail
    // To initialize elements.
    public SortBookFollowOptions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /***
     * Locators
     * */

    // Locator of department list
    @FindBy(xpath = "//*[@id = 'searchDropdownBox']")
    private WebElement drpdwn_department;

    // Locator of search textbox
    @FindBy(xpath = "//*[@id = 'twotabsearchtextbox']")
    private WebElement tbx_search;

    // Locator of search button
    @FindBy(xpath = "//*[@class = 'nav-search-submit nav-sprite']")
    private WebElement btn_searchButton;

    // Locator of languages
    @FindBy(xpath = "//*[@class='a-list-item']//descendant::span[contains(text(),'English')]")
    private WebElement chbx_bookLanguage;


    //Locator of sort options
    @FindBy(xpath = "//*[@aria-label='Sort by:']")
    private WebElement drpdwn_sortOption;

    //Locator of sort button
    @FindBy(xpath = "//*[@aria-label='Sort by:']")
    private WebElement btn_sortOption;

    //Locator of Publication Date option
    @FindBy(xpath = "//*[@class='a-dropdown-link' and contains(text(),'Publication Date')]")
    private WebElement opt_PublicationDate;

    //Locator of result sort by options
    @FindBy(xpath = "//*[@class='a-dropdown-prompt']")
    private WebElement txt_sortBy;



    /***
     * Method
     */
    //Find the department need to search
    public void select_Department() {
        Select select = new Select(drpdwn_department);
        select.selectByVisibleText("Books");
    }

    //Send key to search field
    public void sendKey_SearchKeyWord(String value) {
        sendKeyToTextBox(tbx_search, value);
    }
    //Fill key word to search field
    public void fill_Keyword() {
        sendKey_SearchKeyWord("apple");
    }

    //Click to search button
    public void searchKeyWord() {
        clickButton(btn_searchButton);
    }

    //Find the department need to search
    public void select_Language() {
        clickButton(chbx_bookLanguage);
    }


    //Click on button sort
    public void click_SortButton() {
        clickButton(btn_sortOption);
    }

    //Click on button sort
    public void click_ChoseOption() {
        clickButton(opt_PublicationDate);
    }

    //String name of option
    public String check_SortOptionName() {
        IsEnabledElement(txt_sortBy);
        return null;
    }



}
