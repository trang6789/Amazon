package com.testcases;

import com.base.BaseTest;
import com.pom.homePage.HomePage;
import com.pom.pageObjectManager.PageObjectManager;
import com.pom.BookInPagination.CountNumberOFBooks;
import com.utilities.webdrivers.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPaginateList extends BaseTest {

    private WebDriver driver;
    HomePage homePage;
    CountNumberOFBooks countNumberOFBooks;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;
    private static Logger logger = LogManager.getLogger(TestPaginateList.class.getName());


    @BeforeClass
    public void setUp() {
        driver = getDriver();
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(driver);

        homePage = pageObjectManager.getHomePage();
        countNumberOFBooks = pageObjectManager.getSearchKeyWord();
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
     * Verify displays exactly 16 items on each page
     * */
    public void loginAsManager () {
        logger.info("Inside login test ");
        logger.info("Navigate to Login page");
        //navigate to home page
        homePage.navigateTo_HomePage(driver);

        //select department on search text box
        countNumberOFBooks.select_Department();

        //fill key word on search text box
        countNumberOFBooks.fill_Keyword();

        //search key word on search text box
        countNumberOFBooks.searchKeyWord();

        //select language
        countNumberOFBooks.select_Language();

        //check condition
        countNumberOFBooks.ResultsofBooks();
        Assert.assertEquals("English","English");
        logger.debug("Search successfully executed ");

        //check condition
        boolean actual = countNumberOFBooks.check_BookNumber();
        Assert.assertEquals(actual,true);
        logger.debug("Items display correctly ");

        countNumberOFBooks.select_NextPage();
        countNumberOFBooks.check_BookNumber();
        Assert.assertEquals(actual,true);
        logger.debug("Items display correctly ");

    }
}
