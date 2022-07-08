package qa.application.pom;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignInTest extends TestCase {
    private WebDriver driver;
    SignInPage signInPage;
    @Before
    public void setUp() throws Exception {
        signInPage = new SignInPage(driver);
        driver = signInPage.chromeDriverConnection();
        signInPage.visit("https://demo.guru99.com/test/newtours/");
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        signInPage.testSignIn();
        Thread.sleep(2000);
        assertEquals("Login Successfully", signInPage.testRegisteredMessageLogin());
    }
}