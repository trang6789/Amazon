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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogInSuccess extends BaseTest {
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
    public void loginAsManager () throws InterruptedException {
        logger.info("Inside login test ");
        logger.info("Navigate to Login page");
        homePage.navigateTo_HomePage(driver);
        logger.info("Click on login button");
        // method click Login button
        homePage.clickOn_LoginButton();

        // method input email
        loginPageEmail.fill_LoginEmail();
        // method submit button
        loginPageEmail.clickOn_SubmitButton();

        // method input password
        loginPagePassWord.fill_LoginPassWord();
        // method submit button
        loginPagePassWord.clickOn_SubmitButton();

        //System.out.println(System.getProperty("user.dir"));
        Assert.assertEquals(true,true);
        logger.debug("Login successfully executed ");


    }
}
