import org.example.Singleton;
import org.example.WildberriesCartPageFactory;
import org.example.WildberriesMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WildberriesRuTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private WildberriesMainPage mainPage;
    private WildberriesCartPageFactory wildberriesCartPage;

    public void checkNamesToBeEqual(List<String> mainPageItemNames, List<String> cartPageItemNames) {
        for (int i = 0; i < mainPageItemNames.size(); i++) {
            Assert.assertTrue(mainPageItemNames.get(i).contains(cartPageItemNames.get(i)));
        }
    }

    public void checkQuantityBoxes(List<WebElement> quantityBoxesToCheck) {
        for (WebElement qBox : quantityBoxesToCheck) {
            Assert.assertEquals(qBox.getAttribute("value"), "1");
        }
    }

    @BeforeClass
    public void setup() {
        driver = Singleton.getWebDriverInstance();
        wait = Singleton.getWebDriverWaitInstance();

        mainPage = new WildberriesMainPage(driver, wait);
        wildberriesCartPage = new WildberriesCartPageFactory(driver, wait);
        PageFactory.initElements(driver, wildberriesCartPage);

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
        mainPage.findFirstItem();
        mainPage.findSecondItem();
        mainPage.getFirstItemToCart();
        mainPage.getSecondItemToCart();
        mainPage.goToCart();
    }

    @Test(dependsOnMethods = {"pickItems"})
    public void cartUrlTest() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.wildberries.ru/lk/basket");
    }

    @Test(dependsOnMethods = {"cartUrlTest"})
    public void cartNamesTest() {
        List<String> cartItemNames = wildberriesCartPage.getCartItemNames(wildberriesCartPage.findCartItems());
        checkNamesToBeEqual(mainPage.getMainPageItemNames(),cartItemNames);
    }

    @Test(dependsOnMethods = {"cartUrlTest"})
    public void cartQuantityTest() {
        checkQuantityBoxes(wildberriesCartPage.getQuantityBoxElements());
    }
/*
    @Test(dependsOnMethods = {"cartUrlTest"})
    public void cartPriceTest() {
        WebElement bucket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='basket-form__basket-section basket-section']")));
        List<WebElement> itemPrices = driver.findElements(By.xpath("//div[@class='list-item__price-new wallet']"));

         //Не работает, находит цену продуктов, но она неправильная

        List<Integer> itemPricesAsInt = new ArrayList<>();
        for(WebElement itemPrice : itemPrices) {
            String str = itemPrice.getText();
            str = str.replaceAll("[^0-9.,]+", "");
            int numb = Integer.parseInt(str);
            itemPricesAsInt.add(numb);
            System.out.println(numb);
        }
        int sum = 0;
        for (Integer itPrAsInt : itemPricesAsInt) {
            sum += itPrAsInt;
        }
        //Здесь тоже самое, находит цену, но она неправильная
        //Откуда она берется, я не понимаю

        //WebElement totalPrice = driver.findElement(By.xpath("//p[@class=\"b-top__total line\"]"));
        WebElement totalPrice = driver.findElement(By.xpath("//span[@class=\"b-right\"]"));
        int totalSum = Integer.parseInt(totalPrice.getText().replaceAll("\\D+",""));
        System.out.println(totalSum);
    }  */

    @AfterClass
    public void finish() {
        driver.quit();
        driver = null;
    }
}
