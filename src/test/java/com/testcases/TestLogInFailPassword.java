package com.testcases;

import com.base.BaseTest;
import com.pom.homePage.HomePage;
import com.pom.loginPage.LoginPageEmail;
import com.pom.loginPage.LoginPagePassWord;
import com.pom.pageObjectManager.PageObjectManager;
import com.utilities.webdrivers.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogInFailPassword extends BaseTest {
    private WebDriver driver;
    HomePage homePage;
    LoginPageEmail loginPageEmail;
    LoginPagePassWord loginPagePassWord;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;
    private static Logger logger = LogManager.getLogger(com.testcases.TestLogInSuccess.class.getName());

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(driver);

        homePage = pageObjectManager.getHomePage();
        loginPageEmail = pageObjectManager.getLoginPageEmail();
        loginPagePassWord = pageObjectManager.getLogOutPagePassword();


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
     * This test case will login to home page
     * Verify valid email and invalid pass to login page
     * Login to amazon page fail
     * */
    public void loginFail() {
        logger.info("Inside login test ");
        logger.info("Navigate to Login page");
        //navigate to home page
        homePage.navigateTo_HomePage(driver);
        logger.info("Click on login button");

        // click Login button
        homePage.clickOn_LoginButton();

        // input valid email
        loginPageEmail.fillSuccess_LoginEmail();
        // method submit button
        loginPageEmail.clickOn_SubmitButton();

        // input invalid password
        loginPagePassWord.fillFail_LoginPassWord();

        // method submit button
        loginPagePassWord.clickOn_SubmitButton();

        //Get error message
        loginPagePassWord.errorMessage();
        String actualResult = "Your password is incorrect";
        String expectedResult = "Your password is incorrect";

        //check condition
        Assert.assertEquals(actualResult,expectedResult);
        logger.debug("Login failure executed ");


    }
}
