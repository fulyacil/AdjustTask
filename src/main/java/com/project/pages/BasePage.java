package com.project.pages;

import com.saf.framework.AutomationConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void click(By byElement, int timeOut) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
    }

    public void sendKeys(By byElement, String text) {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.PageLoadTimeout);
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).sendKeys(text);
    }

    public String getText(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.PageLoadTimeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).getText();
    }

    public boolean isElementVisible(By byElement){
        boolean isElementSeen;
        try{
            WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.PageLoadTimeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
            isElementSeen = true;
        }
        catch(Exception e) {
            isElementSeen = false;
        }
        return isElementSeen;
    }
}
