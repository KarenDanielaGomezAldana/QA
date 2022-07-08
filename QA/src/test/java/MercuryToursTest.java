import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
public class MercuryToursTest extends TestCase {
    private WebDriver driver;
    By registerLinkLocator  = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
    By usernameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
    By registerButtonLocator = By.name("submit");
    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By submitLocator = By.name("submit");

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testRegisterUser() throws InterruptedException {
        driver.findElement(registerLinkLocator).click();
        Thread.sleep(2000);
        if(driver.findElement(registerPageLocator).isDisplayed()){
            driver.findElement(usernameLocator).sendKeys("Karen");
            driver.findElement(passwordLocator).sendKeys("1234");
            driver.findElement(confirmPasswordLocator).sendKeys("1234");

            driver.findElement(registerButtonLocator).click();
        }
        else {
            System.out.println("Register pages not found");
        }
        List<WebElement> fonts = driver.findElements(By.tagName("font"));
        assertEquals("Note: Your user name is Karen.",fonts.get(5).getText());
    }
    @Test
    public void testSignIn() throws InterruptedException {
        if (driver.findElement(userLocator).isDisplayed()){
            driver.findElement(userLocator).sendKeys("Karen");
            driver.findElement(passLocator).sendKeys("1234");
            driver.findElement(submitLocator).click();
            Thread.sleep(2000);
            WebElement h3 = driver.findElement(By.tagName("h3"));
            assertEquals("Login Successfully",h3.getText());
        }
        else {
            System.out.println("Register pages not found");
        }
    }
}