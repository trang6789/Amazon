package com.pom.homePage;

import com.basepage.AbstractBasePage;
import com.utilities.propertyreader.ConfigPropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends AbstractBasePage {
    // Create an instance of ConfigPropertiesReader
    ConfigPropertiesReader configFileReader;

    //Constructor of class HomePage
    // To initialize elements.
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locator of account List
    @FindBy(xpath = "//*[@class='nav-line-2 ']")
    private WebElement accountList;;

    //@FindBy(xpath = "//*[@id='nav-al-links-container']//preceding::span[@class ='nav-action-inner']")
    //private WebElement btn_signInButton;

    // Navigate to home page
    public void navigateTo_HomePage(WebDriver driver){
        driver.get("https://www.amazon.com/");
        //driver.get(configFileReader.getApplicationURL());
    }

//    public void select_accounList(){
//        Select select = new Select(accountList);
//        select.selectByVisibleText("Sign in");
//    }

    //Click on Sign in button
    public void clickOn_LoginButton() {
        accountList.click();
    }
}
