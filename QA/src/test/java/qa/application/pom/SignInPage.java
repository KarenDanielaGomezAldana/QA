package qa.application.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class SignInPage extends Base{
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By submitLocator = By.name("submit");
    By homePageLocator = By.xpath("//*[text()='Login Successfully']");

    public void testSignIn(){
        if (isDisplayed(userLocator)){
            type("Karen",userLocator);
            type("1234", passLocator);
            click(submitLocator);
        }else {
            System.out.println("username textbox was not present");
        }
    }
    public String testRegisteredMessageLogin(){
        WebElement h3 = findElement(homePageLocator);
        return getText(h3);
    }
    public Boolean testIsHomePageDisplay(){
        return isDisplayed(homePageLocator);
    }
}
