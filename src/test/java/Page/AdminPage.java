package Page;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AdminPage extends BasePage {
    By adminModule = By.xpath(".//span[text()='Admin']");
    By usernameField = By.xpath(".//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']");
    By searchButton = By.xpath(".//button[@type='submit']");
    By tableRow = By.xpath(".//div[@class='oxd-table-card']");
    By userRoleDropdown = By.xpath(".//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    By userRoleOptions = By.xpath(".//div[@class='oxd-select-option']");
    By employeeNameField = By.xpath(".//input[@placeholder='Type for hints...']");
    By employeeNameOptions = By.xpath(".//div[@class='oxd-autocomplete-option']");
    By statusField = By.xpath(".//div[@class='oxd-select-text oxd-select-text--focus']");
    By statusOptions = By.xpath(".//div[@class='oxd-select-option']");

    public AdminPage(WebDriver driver){
        super(driver);
    }

    public void goToAdmin(){
        findElement(adminModule,5).click();
    }

    public void inputUserName(String username){
        findElement(usernameField, 5).sendKeys(username);
    }

    public void selectUserRole(String roleName){
        findElement(userRoleDropdown,5).click();
        List<WebElement> options = findElements(userRoleOptions,5);
        boolean optionFound = false;
        for(WebElement option : options){
            if(option.getText().trim().equalsIgnoreCase(roleName)){
                option.click();
                optionFound = true;
                break;
            }
        }
        Assert.assertTrue(optionFound,"User Role is not found");
    }

    public void inputEmployeeName(String employeeName){
        findElement(employeeNameField,5).sendKeys(employeeName);
        List<WebElement> options = findElements(employeeNameOptions,5);
        boolean optionFound = false;
        for(WebElement option : options){
            if(option.getText().trim().equalsIgnoreCase(employeeName)){
                option.click();
                optionFound = true;
                break;
            }
        }
        Assert.assertTrue(optionFound,"Employee is not found");
    }

    public void selectStatus(String status){
        findElement(statusField,5).click();
        List<WebElement> options = findElements(statusOptions,5);
        boolean optionFound = false;
        for(WebElement option : options){
            if(option.getText().trim().equalsIgnoreCase(status)){
                option.click();
                optionFound = true;
                break;
            }
        }
        Assert.assertTrue(optionFound,"Employee is not found");
    }

    public void clickSearch(){
        findElement(searchButton, 5).click();
    }

    public void verifySearchResult(int expectedRow){
        int actualRow = findElements(tableRow, 5).size();
        Assert.assertEquals(actualRow, expectedRow, "Expected " + expectedRow + " results, but found " + actualRow);
    }
}
