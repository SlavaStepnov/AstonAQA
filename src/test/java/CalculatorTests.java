
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorTests {
    private AppiumDriver<AndroidElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nubia Z11 miniS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test//(testName = "Сложение") так не сработало
    @Description("Проверка сложения двух чисел : 9 + 3 = 12")
    @Feature("Калькулятор")
    @Story("Сложение")
    public void additionTest() {
        Allure.getLifecycle().updateTestCase(result -> {
            result.setName("Сложение");
        });
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"сложить\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"равно\"]")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "12");
    }

    @Test
    @Description("Проверка вычитания двух чисел : 9 - 3 = 6")
    @Feature("Калькулятор")
    @Story("Вычитание")
    public void subtractionTest() {
        Allure.getLifecycle().updateTestCase(result -> {
            result.setName("Вычитание");
        });
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"вычесть\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"равно\"]")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "6");
    }

    @Test
    @Description("Проверка умножения двух чисел : 9 * 3 = 27")
    @Feature("Калькулятор")
    @Story("Умножение")
    public void multiplicationTest() {
        Allure.getLifecycle().updateTestCase(result -> {
            result.setName("Умножение");
        });
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"умножение\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"равно\"]")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "27");
    }

    @Test
    @Description("Проверка деления двух чисел : 9 / 3 = 3")
    @Feature("Калькулятор")
    @Story("Деление")
    public void divisionTest() {
        Allure.getLifecycle().updateTestCase(result -> {
            result.setName("Деление");
        });
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"разделить\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"равно\"]")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "3");
    }

    @AfterClass
    public void finish() {
        if(driver != null)
            driver.quit();
    }
}