package com.pom.loginPage;

import com.basepage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageEmail extends AbstractBasePage {
    public LoginPageEmail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
        /***
         * Locators
         * */


        @FindBy(xpath = "//*[@id='ap_email']")
        private WebElement emailField;

        @FindBy(xpath = "//*[@type='submit']")
        private WebElement submitButton;


    /***
     * Method
     */

    public void login(String email) {
        sendKeyToTextBox(emailField, email);

    }
    public void clickOn_SubmitButton() {
        submitButton(submitButton);
    }

    public void fill_LoginEmail() {
        login("amazon.test.250620@gmail.com");
    }
}
