package com.project.pages;

import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By txtUserName = By.id("user-name");
    private By txtPassword = By.id("password");
    private By btnLoginButton = By.id("login-button");
    private By txtAcceptedUsers = By.xpath("//div[@id='login_credentials']/h4");
    private By txtPasswordForUsers = By.xpath("//div[@class='login_password']/h4");
    private By imgLoginLogo = By.xpath("//div[@class='login_logo']");
    private By txtErrorMessage = By.xpath("//div[@class='error-message-container error']");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterUsername(String username){
        sendKeys(txtUserName,username);
    }

    public void enterPassword(String password){
        sendKeys(txtPassword,password);
    }

    public void clickLoginButton(){
        click(btnLoginButton,1);
    }

    public String getAcceptedUserText(){
        return getText(txtAcceptedUsers);
    }

    public String getPasswordText(){
        return getText(txtPasswordForUsers);
    }

    public boolean isLogoVisible(){
        return isElementVisible(imgLoginLogo);
    }

    public String getErrorMessageText(){
        return getText(txtErrorMessage);
    }
}
