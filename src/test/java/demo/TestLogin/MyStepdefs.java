package demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LogInPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class MyStepdefs {

    private WebDriver driver = null;

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

    @Given("I LogIn web as <username> and <password>")
    public void iLogInWebAsUsernameAndPassword() {
        logInPage.logInAs("z.d.r.a.v.k.o.stojkoski@gmail.com", "ThePassword01##!!");
        assertTrue(logInPage.isLogInSuccessful());
    }

    @When("I select to open <option>")
    public void iSelectToOpenOption() {
        logInPage.selectOption("Admin Portal");
    }
}

//    @AfterMethod()
//    public void teardown() {
//
////        driver.quit();
//    }

