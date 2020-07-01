package com.pom.resultSort;

import com.basepage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ResultSortDate extends AbstractBasePage {
    WebElement driver;
    //Constructor of class ResultSortDate
    // To initialize elements.
    public ResultSortDate(WebDriver driver) {
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

    //Locator of sort date
    @FindBy(xpath = "//*[@class='a-size-base a-color-secondary a-text-normal']")
    private List<WebElement> sortDateList;


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

    public void check_sortDate() throws ParseException {
        List<Date> listDates = new ArrayList<Date>();

        //Convert the text into time
        SimpleDateFormat dateFormatter = new SimpleDateFormat("mmm dd, yyyy");
        for(WebElement date:sortDateList)
        {
            listDates.add(dateFormatter.parse(date.getText()));
        }

        //Put all the collected time into a array list
        ArrayList<Date> sortedList = new ArrayList<>();
        for(Date s:listDates){

            sortedList.add(s);

        }

        // Compare date in list
        Collections.sort(sortedList, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
