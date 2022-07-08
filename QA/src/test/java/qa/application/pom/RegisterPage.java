package qa.application.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class RegisterPage extends Base{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    By registerLinkLocator  = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
    By usernameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
    By registerButtonLocator = By.name("submit");
    By registeredMessage = By.tagName("font");

    public void testRegisterUser() throws InterruptedException{
        click(registerLinkLocator);
        Thread.sleep(2000);
        if(isDisplayed(registerPageLocator)){
            type("Karen", usernameLocator);
            type("1234", passwordLocator);
            type("1234", confirmPasswordLocator);

            click(registerButtonLocator);
        }
        else {
            System.out.println("Register Page was not found");
        }
    }
    public String testRegisteredMessage(){
        List<WebElement> fonts =  findElements(registeredMessage);
        return getText(fonts.get(5));
    }
}
