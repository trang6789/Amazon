package com.testcases;

import com.base.BaseTest;
import com.pom.homePage.HomePage;
import com.pom.pageObjectManager.PageObjectManager;
import com.pom.sortOption.SortBookFollowOptions;
import com.utilities.webdrivers.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSortOptions extends BaseTest {

    private WebDriver driver;
    HomePage homePage;
    SortBookFollowOptions sortBookFollowOptions;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;
    private static Logger logger = LogManager.getLogger(TestPaginateList.class.getName());


    @BeforeClass
    public void setUp() {
        driver = getDriver();
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(driver);

        homePage = pageObjectManager.getHomePage();
        sortBookFollowOptions = pageObjectManager.getSortOption();
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
    public void loginAsManager () {
        logger.info("Inside login test ");
        logger.info("Navigate to Login page");
        //navigate to home page
        homePage.navigateTo_HomePage(driver);

        //select department on search text box
        sortBookFollowOptions.select_Department();

        //fill key word on search text box
        sortBookFollowOptions.fill_Keyword();

        //fill key word on search text box
        sortBookFollowOptions.searchKeyWord();

        //search key word on search text box
        sortBookFollowOptions.select_Language();

        //click on sort feature button
        sortBookFollowOptions.click_SortButton();

        //chose option for feature
        sortBookFollowOptions.click_ChoseOption();

        //check condition
        String actual = sortBookFollowOptions.check_SortOptionName();
        actual = "Publication Date";
        Assert.assertEquals(actual,"Publication Date");
        logger.debug("Sort successfully executed ");

    }
}
