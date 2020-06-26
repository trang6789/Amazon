package com.pom.loginPage;

import com.basepage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePassWord extends AbstractBasePage {
    public LoginPagePassWord(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    /***
     * Locators
     * */

    @FindBy(xpath = "//*[@id='ap_password']")
    private WebElement passWordField;

    @FindBy(xpath = "//*[@id='signInSubmit']")
    private WebElement submitButton;


    /***
     * Method
     */

    public void login(String password) {
        sendKeyToTextBox(passWordField, password);

    }
    public void clickOn_SubmitButton() {
        submitButton(submitButton);
    }

    public void fill_LoginPassWord() {
        login("Test@123");
    }

}
