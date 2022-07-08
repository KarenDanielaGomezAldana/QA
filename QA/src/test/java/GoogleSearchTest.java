import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
public class GoogleSearchTest {
    private WebDriver webDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com/");
    }
    @Test
    public void testGooglePage(){
        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
        searchBox.submit();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google", webDriver.getTitle());
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }
}
