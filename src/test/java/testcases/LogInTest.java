package testcases;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LogInPage;

public class LogInTest extends BaseSetup {

    private WebDriver driver;
    public LogInPage logInPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Parameters({ "username", "password" })
    @Test
    public void loginAs(String username,String password) throws Exception {
        logInPage = new LogInPage(driver);

        logInPage.logInAs(username, password);
        Assert.assertTrue(logInPage.isLogInSuccessful());
    }
}
