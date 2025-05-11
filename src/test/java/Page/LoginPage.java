package Page;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class LoginPage extends BasePage {
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath(".//button[text()=' Login ']");
    By errorMessage = By.xpath(".//p[text()='Invalid credentials']");
    By requiredMessage = By.xpath(".//span[text()='Required']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String username, String password){
        findElement(usernameField,5).sendKeys(username);
        findElement(passwordField,5).sendKeys(password);
        findElement(loginButton,5).click();
    }

    public boolean isErrorMessageDisplayed(){
        return findElement(errorMessage,5).isDisplayed();
    }

    public boolean isRequiredMessageDisplayed(){
        return findElement(requiredMessage,5).isDisplayed();
    }
}