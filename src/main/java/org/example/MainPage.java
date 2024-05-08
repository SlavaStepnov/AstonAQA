package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cookiesPanelLocator = By.xpath("//form[@id='CookiesStickyPanel']");
    private By acceptCookiesLocator = By.xpath("//button[@class='button button--primary button--fixed-width']");
    private By newsCarouselLocator = By.xpath("//div[@class='carousel-container ']");
    private By emailTextBoxLocator = By.xpath("//input[@name='email']");
    private By emailButtonLocator = By.xpath("//input[@name='email']/following-sibling::button");
    private By contentTableLocator = By.xpath("//div[@class='toast-content--success toast-content']");
    private By titleAndContentTextLocator = By.xpath("//div[@class='toast-content--success toast-content']/child::div");
    private String successText = "Вы подписались\n" +
            "Вы успешно подписались на нашу новостную рассылку.";

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getSuccessText() {
        return successText;
    }

    public void clickAcceptCookiesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesLocator)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cookiesPanelLocator));
    }

    public void scrollDownToEmail () {
        WebElement newsCarousel = wait.until(ExpectedConditions.presenceOfElementLocated(newsCarouselLocator));
        WebElement emailTextBox = driver.findElement(emailTextBoxLocator);
        Actions actions = new Actions(driver);

        while(!newsCarousel.isDisplayed()) {
            actions.moveToElement(emailTextBox).perform();
        }
        actions.moveToElement(emailTextBox).perform();
    }

    public void sendKeysAndClickButton () {
        driver.findElement(emailTextBoxLocator).sendKeys("abcdefg@yandex.ru");
        driver.findElement(emailButtonLocator).click();
    }

    //первый вариант метода на проверку текста
    //не нравится, потому что вторая строчка костыльная
//    public String getActualText() {
//        WebElement contentTable = wait.until(ExpectedConditions.visibilityOfElementLocated(contentTableLocator));
//        driver.findElement(By.xpath("//div[@class='toast-content-text']")); // без этой строчки не находит весь текст
//        return contentTable.getText();
//    }

    //второй вариант метода на проверку текста.
    //вроде даже получилось, он работает
    //но кажется слишком массивным
    public String getActualText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contentTableLocator));
        List<WebElement> contentTableElements = driver.findElements(titleAndContentTextLocator);
        StringBuilder actualText = new StringBuilder();
        for (int i = 0; i < contentTableElements.size(); i++) {
            if(!contentTableElements.get(i).getText().isEmpty()) {
                actualText.append(contentTableElements.get(i).getText()).append("\n");
                System.out.println(contentTableElements.get(i).getText());
            }
        }
        actualText.deleteCharAt(actualText.length()-1);
        return actualText.toString();
    }
}
