package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By txtProducts = By.xpath("//span[contains(text(),'Products')]");
    private By btnBasket = By.xpath("//a[@class='shopping_cart_link']");
    private By btnMenu = By.id("react-burger-menu-btn");
    private By txtSortContainer = By.xpath("//select[@class='product_sort_container']");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isProductsVisible(){
        return isElementVisible(txtProducts);
    }

    public boolean isBasketVisible(){
        return isElementVisible(btnBasket);
    }

    public boolean isMenuVisible(){
        return isElementVisible(btnMenu);
    }

    public boolean isSortContainerVisible(){
        return isElementVisible(txtSortContainer);
    }
}
