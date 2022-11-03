package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {

    private final WebDriver driver;

    //Page URL
    private static final String PAGE_URL="/unauthorised";

    //Locators
    @FindBy(name = "username")
    private WebElement txtUsername;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//h2[@class='loginConfirmation--heading']")
    private WebElement lblHeadingOption;

    @FindBy(xpath = "//button[@ng-click='vm.diaryLogin()']")
    private WebElement btnRestaurantDiary;

    @FindBy(xpath = "//button[@ng-click='vm.adminLogin()']")
    private WebElement btnAdminPortal;

    //Constructor
    public LogInPage(WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void logInAs(String username, String password) {
        String baseURL = "https://admin-dev.nowbookit.com/";
        this.driver.get(baseURL+PAGE_URL);
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public boolean isLogInSuccessful(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement lblHeadingOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='loginConfirmation--heading']")));
        return lblHeadingOption.getText().contains("You have successfully logged in");
    }

    public void selectOption(String option) {
        if(option.equalsIgnoreCase("Restaurant Diary"))
            btnRestaurantDiary.click();
        else if(option.equalsIgnoreCase("Admin Portal"))
            btnAdminPortal.click();
    }
}
