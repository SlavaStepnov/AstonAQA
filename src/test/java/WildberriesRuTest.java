import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class WildberriesRuTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.wildberries.ru/");
        driver.manage().window().maximize();
    }

    @Test
    public void urlTest() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.wildberries.ru/");
    }

    @Test(dependsOnMethods = {"urlTest"})
    public void pickItems() {

        WebElement mainPageContent = driver.findElement(By.className("main-page__content"));

        WebElement firstItem = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[1]/div/a"));
        String str1 = firstItem.getAttribute("aria-label");
        System.out.println(str1);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[1]/div/div[3]/p[3]/a")).click();

        WebElement secondItem = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[2]/div/a"));
        String str2 = secondItem.getAttribute("aria-label");
        System.out.println(str2);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[2]/div/div[3]/p[3]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"basketContent\"]/div[3]/a")).click();//корзина
    }

    @AfterClass
    public void finish() {
        driver.quit();
        driver = null;
    }
}
