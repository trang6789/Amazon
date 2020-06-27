package com.pom.loginPage;

import com.basepage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePassWord extends AbstractBasePage {
    //Constructor of class LoginPageEmail
    // To initialize elements.
    public LoginPagePassWord(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    /***
     * Locators
     * */
    // Locator of password field
    @FindBy(xpath = "//*[@id='ap_password']")
    private WebElement passWordField;

    // Locator of submit button
    @FindBy(xpath = "//*[@id='signInSubmit']")
    private WebElement submitButton;

    // Locator of error message
    @FindBy(xpath = "//*[contains(text(),'Your password is incorrect')]")
    private WebElement errormsg;


    /***
     * Method
     */
    //Sendkey to password field
    public void login(String password) {
        sendKeyToTextBox(passWordField, password);

    }

    //Input valid data into Password textbox
    public void fillSuccess_LoginPassWord() {
        login("Test@123");
    }

    //Input invalid data into Password textbox
    public void fillFail_LoginPassWord() {
        login("12345");
    }

    //Click on Submit button
    public void clickOn_SubmitButton() {
        submitButton(submitButton);
    }

    //display on error message
    public WebElement errorMessage(){
        getTextInElement(errormsg);
        return null;
    }

}
