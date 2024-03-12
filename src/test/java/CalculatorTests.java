
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorTests {
    private AppiumDriver<AndroidElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 7");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void additionTest() {
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"сложить\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"равно\"]")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals("12", result);
    }
}
