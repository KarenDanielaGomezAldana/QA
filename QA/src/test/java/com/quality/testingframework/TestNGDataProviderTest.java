package com.quality.testingframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.*;

public class TestNGDataProviderTest {
    WebDriver driver;
    By signInLocator = By.linkText("Sign in");
    By emailLocator = By.id("email");
    By passwordLocator = By.id("passwd");
    By signInButtonLocator = By.id("SubmitLogin");
    By signOutButtonLocator = By.cssSelector("a.logout");
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationpractice.com/index.php");
    }
    @DataProvider(name = "authenticationData")
    public Object[][] getData(){
        Object[][] data = new Object[2][2];

        data[0][0]= "qs123@gmail.com"; data[0][1]="qs123";
        data[1][0] = "testng_qs@gmail.com";data[1][1]="qs123";
        return data;
    }
    @Test(dataProvider = "authenticationData")
    public void login(String email, String password) throws InterruptedException {
        if (driver.findElement(signInLocator).isDisplayed()){
            driver.findElement(signInLocator).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));

            driver.findElement(emailLocator).sendKeys(email);
            driver.findElement(passwordLocator).sendKeys(password);
            Thread.sleep(2000);
            driver.findElement(signInButtonLocator).click();
            Thread.sleep(2000);
            assertEquals(driver.findElement(signOutButtonLocator).getText(),"Sign out");

            driver.findElement(signOutButtonLocator).click();
        }
        else {
            System.out.println("Sign in link not present");
        }
    }
    @AfterClass
    public void afterClass() {
        driver.close();
    }
}