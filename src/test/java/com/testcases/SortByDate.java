package com.testcases;

import com.base.BaseTest;
import com.pom.homePage.HomePage;
import com.pom.pageObjectManager.PageObjectManager;
import com.pom.resultSort.ResultSortDate;
import com.pom.sortOption.SortBookFollowOptions;
import com.utilities.webdrivers.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.ParseException;

public class SortByDate extends BaseTest {

    private WebDriver driver;
    HomePage homePage;
    ResultSortDate resultSortDate;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;
    private static Logger logger = LogManager.getLogger(TestPaginateList.class.getName());


    @BeforeClass
    public void setUp() {
        driver = getDriver();
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(driver);

        homePage = pageObjectManager.getHomePage();
        resultSortDate = pageObjectManager.getSortByDate();
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    /***
     * This test case will find department (Books) on home page
     * Send key word (apple) in search field
     * Search result successfully for key word
     * */
    public void loginAsManager () throws ParseException {
        logger.info("Inside login test ");
        logger.info("Navigate to Login page");
        //navigate to home page
        homePage.navigateTo_HomePage(driver);

        //select department on search text box
        resultSortDate.select_Department();

        //fill key word on search text box
        resultSortDate.fill_Keyword();

        //fill key word on search text box
        resultSortDate.searchKeyWord();

        //search key word on search text box
        resultSortDate.select_Language();

        //click on sort feature button
        resultSortDate.click_SortButton();

        //chose option for feature
        resultSortDate.click_ChoseOption();

        //check condition
        String actual = resultSortDate.check_SortOptionName();
        actual = "Publication Date";
        Assert.assertEquals(actual,"Publication Date");
        logger.debug("Sort successfully executed ");

        //check sort by Publication Date
        resultSortDate.check_sortDate();

    }
}
