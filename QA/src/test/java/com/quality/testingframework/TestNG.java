package com.quality.testingframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;
public class TestNG {
    WebDriver driver;
    By searchBoxLocator = By.id("search_query_top");
    By resultsLocator = By.cssSelector("span.heading-counter");
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationpractice.com/index.php");
    }
    @Test
    public void testSearchBlouses(){
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.clear();
        searchBox.sendKeys("blouse");
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(resultsLocator));

        System.out.println("This is the result number:" + driver.findElement(resultsLocator).getText());

        assertTrue(driver.findElement(resultsLocator).isDisplayed(), "The result number is not present");
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
