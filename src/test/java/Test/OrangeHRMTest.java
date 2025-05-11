package Test;

import Base.BaseTest;
import Page.AdminPage;
import Page.LoginPage;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {

    @Test
    public void TC01_Login_TestLoginSuccess(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");
        assertCondition(driver.getCurrentUrl().contains("/dashboard/index"),true,"Login failed");
    }

    @Test
    public void TC02_Login_TestIncorrectPasswordLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","1");
        assertCondition(loginPage.isErrorMessageDisplayed(),true,"Error message is not shown");
    }

    @Test
    public void TC03_Login_TestBlankLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","");
        assertCondition(loginPage.isRequiredMessageDisplayed(),true,"Required message is not shown");
    }

    @Test
    public void TC04_Admin_GoToAdminModule(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToAdmin();
        assertCondition(driver.getCurrentUrl().contains("admin/viewSystemUsers"),true,"Admin is not found");
    }

    @Test
    public void TC05_Admin_SearchByUserName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToAdmin();
        adminPage.inputUserName("Admin");
        adminPage.clickSearch();
        adminPage.verifySearchResult(1);
    }

    @Test
    public void TC06_Admin_SearchByUserRole(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToAdmin();
        adminPage.selectUserRole("Admin");
        adminPage.clickSearch();
        adminPage.verifySearchResult(2);
    }

    @Test
    public void TC07_Admin_SearchByEmployeeName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToAdmin();
        adminPage.inputEmployeeName("mandaIshwar userUtane");
        adminPage.clickSearch();
        adminPage.verifySearchResult(1);
    }

    @Test
    public void TC08_Admin_SearchByStatus(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToAdmin();
        adminPage.selectStatus("Enabled");
        adminPage.clickSearch();
        adminPage.verifySearchResult(1);
    }

    @Test
    public void TC09_Admin_DynamicSearch(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToAdmin();
        adminPage.inputUserName("Admin");
        adminPage.selectUserRole("Admin");
        adminPage.selectStatus("Enabled");
        adminPage.clickSearch();
        adminPage.verifySearchResult(1);
    }
}