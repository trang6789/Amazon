package com.pom.pageObjectManager;

import com.pom.homePage.HomePage;
import com.pom.loginPage.LoginPageEmail;
import com.pom.loginPage.LoginPagePassWord;
import com.pom.resultSort.ResultSortDate;
import com.pom.BookInPagination.CountNumberOFBooks;
import com.pom.sortOption.SortBookFollowOptions;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPageEmail loginPageEmail;
    private LoginPagePassWord loginPagePassWord;
    private CountNumberOFBooks searchKeyWord;
    private SortBookFollowOptions sortBookFollowOptions;
    private ResultSortDate resultSortDate;

    //create an object of the page object manager
    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }
    //create an instance of home page
    public HomePage getHomePage(){
        return (homePage == null)? homePage = new HomePage(driver):homePage;
    }

    //create an instance of Login email page
    public LoginPageEmail getLoginPageEmail(){
        return (loginPageEmail == null)? loginPageEmail = new LoginPageEmail(driver) :loginPageEmail;
    }

    //create an instance of Login password page
    public LoginPagePassWord getLogOutPagePassword(){
        return (loginPagePassWord == null)? loginPagePassWord = new LoginPagePassWord(driver):loginPagePassWord;
    }
    //create an instance of search keyword page
    public CountNumberOFBooks getSearchKeyWord(){
        return (searchKeyWord == null)? searchKeyWord = new CountNumberOFBooks(driver):searchKeyWord;
    }

    //create an instance of sort following options
    public SortBookFollowOptions getSortOption(){
        return (sortBookFollowOptions == null)? sortBookFollowOptions = new SortBookFollowOptions(driver):sortBookFollowOptions;
    }

    //create an instance of sort following options
    public ResultSortDate getSortByDate(){
        return (resultSortDate == null)? resultSortDate = new ResultSortDate(driver):resultSortDate;
    }

}
