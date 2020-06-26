package com.pom.pageObjectManager;

import com.pom.homePage.HomePage;
import com.pom.loginPage.LoginPageEmail;
import com.pom.loginPage.LoginPagePassWord;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPageEmail loginPageEmail;
    private LoginPagePassWord loginPagePassWord;


    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null)? homePage = new HomePage(driver):homePage;
    }

    public LoginPageEmail getLoginPageEmail(){
        return (loginPageEmail == null)? loginPageEmail = new LoginPageEmail(driver) :loginPageEmail;
    }

    public LoginPagePassWord getLogOutPagePassword(){
        return (loginPagePassWord == null)? loginPagePassWord = new LoginPagePassWord(driver):loginPagePassWord;
    }

}
