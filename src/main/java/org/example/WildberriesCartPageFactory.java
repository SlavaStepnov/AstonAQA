package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class WildberriesCartPageFactory {
    private WebDriver driver;
    private WebDriverWait wait;
    private List<String> cartPageItemNames;

    By cartItemsLocator = By.className("list-item__wrap");
    By cartItemsNameLocator = By.className("good-info__good-name");
    @FindBy(xpath = "//input[@type='number']")
    List<WebElement> quantityBoxes;

    public WildberriesCartPageFactory(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public List<WebElement> findCartItems() {
        List<WebElement> cartItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItemsLocator));
        System.out.println(cartItems.size());
        return cartItems;
    }

    public List<String> getCartItemNames(List<WebElement> cartItemsToFindNames) {
        cartPageItemNames = new ArrayList<>();
        for (int i = cartItemsToFindNames.size()-1; i >= 0; i--) {
            wait.until(ExpectedConditions.visibilityOf(cartItemsToFindNames.get(i)));
            String cartPageItemName = cartItemsToFindNames.get(i).findElement(cartItemsNameLocator).getText();
            System.out.println(cartPageItemName);
            cartPageItemNames.add(cartPageItemName);
        }
        return cartPageItemNames;
    }

    public List<WebElement> getQuantityBoxElements() {
        wait.until(ExpectedConditions.visibilityOfAllElements(quantityBoxes));
        return quantityBoxes;
    }
}
