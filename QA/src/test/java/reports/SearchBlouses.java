package reports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class SearchBlouses {
    WebDriver driver;
    By searchBoxLocator = By.id("search_query_top");
    By resultsLocator = By.cssSelector("span.heading-counter");

    By searchButtonLocator = By.name("submit_search");

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationpractice.com/index.php");
    }
    @Test
    public void testSearchBlouses2() throws InterruptedException {
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.clear();
        searchBox.sendKeys("blouse");

        Thread.sleep(1000);
        driver.findElement(searchButtonLocator).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(resultsLocator));

        System.out.println("This is the result number:" + driver.findElement(resultsLocator).getText());

        assertEquals(driver.findElement(resultsLocator).getText(),"1 result has been found.");
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
