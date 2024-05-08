
import org.example.MainPage;
import org.example.WebDriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;
import java.util.concurrent.TimeUnit;

public class A1TextCheck {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static MainPage mainPage;

    @BeforeAll
    public static void setup() {
        driver = WebDriverSingleton.getWebDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        mainPage = new MainPage(driver, wait);
        driver.manage().window().maximize();
    }

    @Test()
    public void a1TextCheck() {
        driver.navigate().to("https://www.a1.by/ru/");
        mainPage.clickAcceptCookiesButton();
        mainPage.scrollDownToEmail();
        mainPage.sendKeysAndClickButton();
        //Assertions.assertTrue(mainPage.getSuccessText().contains(mainPage.getActualText())); //с этим работает всегда
        Assertions.assertEquals(mainPage.getSuccessText(), mainPage.getActualText());
    }

    @AfterAll
    public static void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
