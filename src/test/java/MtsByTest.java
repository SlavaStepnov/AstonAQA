
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class MtsByTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public void clickSelectButton() {
        WebElement selectButton = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(selectButton));
        selectButton.click();
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.mts.by");
        driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]")).click();
    }

    @Test
    public void communicationServicesTest() {
        clickSelectButton();
        WebElement comServButton = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]"));
        comServButton.click();

        WebElement numberTextBox = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        String numberPlaceholderText = numberTextBox.getAttribute("placeholder");
        Assert.assertEquals(numberPlaceholderText, "Номер телефона");

        WebElement priceTextBox = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        String pricePlaceholderText = priceTextBox.getAttribute("placeholder");
        Assert.assertEquals(pricePlaceholderText, "Сумма");

        WebElement emailTextBox = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        String emailPlaceHolderText = emailTextBox.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceHolderText, "E-mail для отправки чека");
    }

    @Test
    public void homeInternetTest() {
        clickSelectButton();
        WebElement homeIntButton = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]"));
        homeIntButton.click();

        WebElement subNumberTextBox = driver.findElement(By.xpath("//*[@id=\"internet-phone\"]"));
        String numPlaceholderText = subNumberTextBox.getAttribute("placeholder");
        Assert.assertEquals(numPlaceholderText, "Номер абонента");

        WebElement intPriceTextBox = driver.findElement(By.xpath("//*[@id=\"internet-sum\"]"));
        String intPricePlaceholderText = intPriceTextBox.getAttribute("placeholder");
        Assert.assertEquals(intPricePlaceholderText, "Сумма");

        WebElement emailTextBox = driver.findElement(By.xpath("//*[@id=\"internet-email\"]"));
        String emailPlaceholderText = emailTextBox.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceholderText, "E-mail для отправки чека");
    }

    @Test
    public void installmentPlanTest() {
        clickSelectButton();
        WebElement instPlanButton = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(instPlanButton));
        instPlanButton.click();

        WebElement accNumber = driver.findElement(By.xpath("//*[@id=\"score-instalment\"]"));
        String accNumPlaceholderText = accNumber.getAttribute("placeholder");
        Assert.assertEquals(accNumPlaceholderText, "Номер счета на 44");

        WebElement instPriceTextBox = driver.findElement(By.xpath("//*[@id=\"instalment-sum\"]"));
        String instPricePlaceholderText = instPriceTextBox.getAttribute("placeholder");
        Assert.assertEquals(instPricePlaceholderText, "Сумма");

        WebElement emailTextBox = driver.findElement(By.xpath("//*[@id=\"instalment-email\"]"));
        String emailPlaceholderText = emailTextBox.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceholderText, "E-mail для отправки чека");
    }

    @Test
    public void debtTest() {
        clickSelectButton();
        WebElement debtButton = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]"));
        wait.until(ExpectedConditions.elementToBeClickable(debtButton));
        debtButton.click();

        WebElement accNumberTextBox = driver.findElement(By.xpath("//*[@id=\"score-arrears\"]"));
        String accNumberPlaceholderText = accNumberTextBox.getAttribute("placeholder");
        Assert.assertEquals(accNumberPlaceholderText, "Номер счета на 2073");

        WebElement priceTextBox = driver.findElement(By.xpath("//*[@id=\"arrears-sum\"]"));
        String pricePlaceholderText = priceTextBox.getAttribute("placeholder");
        Assert.assertEquals(pricePlaceholderText, "Сумма");

        WebElement emailTextBox = driver.findElement(By.xpath("//*[@id=\"arrears-email\"]"));
        String emailPlaceholderText = emailTextBox.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceholderText, "E-mail для отправки чека");
    }


    @Test(dependsOnMethods = {"communicationServicesTest", "homeInternetTest", "installmentPlanTest", "debtTest"})
    public void moveToFrame() {
        //Выбираю услуги связи и ввожу данные
        clickSelectButton();
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"connection-phone\"]")).sendKeys("297777777");
        driver.findElement(By.xpath("//*[@id=\"connection-sum\"]")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).click();

        //Переход во фрейм
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1)); //нашел наугад
        //Жду, пока фрейм прогрузится
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/div/span[1]")));

        WebElement headerPayment = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/app-header/header/div/div"));
        Assert.assertTrue(headerPayment.getText().contains("100"));
        Assert.assertTrue(headerPayment.getText().contains("297777777"));

        WebElement buttonPrice = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/button"));
        Assert.assertTrue(buttonPrice.getText().contains("100"));

        WebElement paymentWindow = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]"));
        String paymentData = paymentWindow.getText();
        Assert.assertTrue(paymentData.contains("Номер карты"));
        Assert.assertTrue(paymentData.contains("Срок действия"));
        Assert.assertTrue(paymentData.contains("CVC"));
        Assert.assertTrue(paymentData.contains("Имя держателя (как на карте)"));

        WebElement logos = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div"));
        Assert.assertTrue(logos.isDisplayed());
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }
}
