package com.quality.testingframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.*;
public class CrossBrowserTest {
    private WebDriver driver;
    By searchBox = By.name("q");
    By videoLocator = By.cssSelector("a[href='https://www.youtube.com/watch?v=R_hh3jAqn8M']");
    @BeforeClass
    @Parameters({"URL", "BrowserType"})
    public void beforeClass(String url, String browserType) {
        if (browserType.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver","./src/main/resources/chromedriver/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("Internet Explorer")) {
            System.setProperty("webdriver.ie.driver","./src/main/resources/chromedriver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);

        System.out.println("Opening:" + browserType);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void GoogleTest(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(videoLocator));

        assertTrue(driver.findElement(videoLocator).isDisplayed());
    }
}