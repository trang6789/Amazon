package com.pom.loginPage;

import com.basepage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageEmail extends AbstractBasePage {
    //Constructor of class LoginPageEmail
    // To initialize elements.
    public LoginPageEmail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    /***
     * Locators
     * */
    // Locator of email field
    @FindBy(xpath = "//*[@id='ap_email']")
    private WebElement emailField;

    // Locator of submit button
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitButton;


    /***
     * Method
     */
    //Sendkey to email field
    public void login(String email) {
        sendKeyToTextBox(emailField, email);

    }

    //Input invalid data into Email textbox
    public void fillFail_LoginEmail() {
        login("abc@gmail.com");
    }

    //Input valid data into Email textbox
    public void fillSuccess_LoginEmail() {
        login("amazon.test.250620@gmail.com");
    }

    //Click on Submit button
    public void clickOn_SubmitButton() {
        submitButton(submitButton);
    }
}
