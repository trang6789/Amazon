package com.pom.BookInPagination;

import com.basepage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CountNumberOFBooks extends AbstractBasePage {
    WebElement driver;
    //Constructor of class SearchKeyWords
    // To initialize elements.
    public CountNumberOFBooks(WebDriver driver) {
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

    // Locator of result languages
    @FindBy(xpath = "//*[@class='a-list-item']//descendant::span[contains(text(),'English')]")
    private WebElement txt_resultBookLanguages;

    //Locator of list of books
    @FindBy(xpath = "//*[@data-component-type ='s-search-result']")
    private List<WebElement> books;

    //Locator of next button
    @FindBy(xpath = "//*[@class='a-last']")
    private WebElement btn_next;

    //Locator of pagination
    @FindBy(xpath = "//*[@class='a-pagination']")
    private List<WebElement> pagination;



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
    public void ResultsofBooks(){
        txt_resultBookLanguages.getCssValue("English");
    }

    public boolean check_BookNumber() {
        if (books.size() == 16) {
            return true;
        }
        else
            return false;
    }

    //Find the department need to search
    public void select_NextPage() {
        clickButton(btn_next);
    }
}


