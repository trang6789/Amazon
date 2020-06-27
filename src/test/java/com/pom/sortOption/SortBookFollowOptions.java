package com.pom.sortOption;

import com.basepage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy(xpath = "//*[@id='s-result-sort-select']")
    private WebElement drpdwn_sortOption;

//    //Locator of result sort by options
//    @FindBy(xpath = "//*[@class='a-dropdown-prompt']")
//    private WebElement txt_sortBy;



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
    //Find the department need to search
//    public void click_SortByButton() {
//        clickButton(btn_sortBy);
//    }

    public void select_SortOption() {
        Select select = new Select(drpdwn_sortOption);
        select.selectByVisibleText("Publication Date");
    }

//    public String check_SortOptionName() {
//        IsEnabledElement(txt_sortBy);
//        return null;
//    }

}
