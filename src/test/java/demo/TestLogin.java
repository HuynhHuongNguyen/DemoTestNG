package demo;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestLogin {
    private WebDriver driver = null;
    //Pages
    private LogInPage logInPage = null;


    @BeforeMethod()
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://admin-dev.nowbookit.com/");
        logInPage = new LogInPage(driver);
    }

    @Test
    public void main() {
        logInPage.logInAs("z.d.r.a.v.k.o.stojkoski@gmail.com", "ThePassword01##!!");
        assertTrue(logInPage.isLogInSuccessful());
        logInPage.selectOption("Admin Portal");
    }

//    @Test
//    public void Test1() {
//        logInPage.logInAs("username", "password");
//        assertTrue(logInPage.isLogInSuccessful());
//    }
//    @AfterMethod()
//    public void teardown() {
//        driver.quit();
//    }
}
