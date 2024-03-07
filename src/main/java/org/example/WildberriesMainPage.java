package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class WildberriesMainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private List<String> mainPageItemNames;

   // By mainPageLocator = By.className("main-page__content");
    By firstItemLocator = By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[1]/div/a");
    By firstItemCartButtonLocator = By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[1]/div/div[3]/p[3]/a");
    By secondItemLocator = By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[2]/div/a");
    By secondItemCartLocator = By.xpath("//*[@id='app']/div[2]/div/div[2]/div/article[2]/div/div[3]/p[3]/a");
    By cartButtonLocator = By.xpath("//*[@id='basketContent']/div[3]/a");

    public List<String> getMainPageItemNames() {
        return mainPageItemNames;
    }

    public WildberriesMainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        mainPageItemNames = new ArrayList<>();
    }

    public void findFirstItem() {
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemLocator));
        String firstItemName = firstItem.getAttribute("aria-label");
        System.out.println(firstItemName);
        mainPageItemNames.add(firstItemName);
    }

    public void getFirstItemToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstItemCartButtonLocator)).click();
    }

    public void findSecondItem() {
        WebElement secondItem = wait.until(ExpectedConditions.visibilityOfElementLocated(secondItemLocator));
        String secondItemName = secondItem.getAttribute("aria-label");
        System.out.println(secondItemName);
        mainPageItemNames.add(secondItemName);
    }

    public void getSecondItemToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(secondItemCartLocator)).click();
    }

    public void goToCart() {
        driver.findElement(cartButtonLocator).click();
    }
}
