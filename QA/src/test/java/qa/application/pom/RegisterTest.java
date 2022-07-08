package qa.application.pom;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
public class RegisterTest extends TestCase {
    private WebDriver driver;
    RegisterPage registerPage;
    @Before
    public void setUp() throws Exception {
        registerPage = new RegisterPage(driver);
        driver = registerPage.chromeDriverConnection();
        registerPage.visit("https://demo.guru99.com/test/newtours/");
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        registerPage.testRegisterUser();
        assertEquals("Note: Your user name is Karen.", registerPage.testRegisteredMessage());
    }
}