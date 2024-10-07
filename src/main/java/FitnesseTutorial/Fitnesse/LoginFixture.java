package FitnesseTutorial.Fitnesse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Boolean.*;

public class LoginFixture {
    private WebDriver driver;
    
    public LoginFixture() {
    }

    private void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://login.appian.com/app/appiancommunity_usappiancommunity_1/exkbj2dap0hJhrVS3697/sso/saml");
    }
    private void tearDown() {
        driver.quit();
    }

    public void setEmail(String email) {
        setup();
        WebElement _email = driver.findElement(By.id("input28"));
        _email.sendKeys(email);
    }

    public void setPassword(String password){
        WebElement _password = driver.findElement(By.id("input36"));
        _password.sendKeys(password);
    }

    public void setRememberMe( Boolean rememberMe){
        WebElement _rememberMe = driver.findElement(By.xpath("//*[text()='Remember my Email']"));
        if (rememberMe) _rememberMe.click();
    }


    public void setSignIn(String s){
        WebElement _signInButton = driver.findElement(By.xpath("//*[@value='Sign in']"));
        _signInButton.click();
        driver.findElement(By.xpath("//*[text()='"+s+"']")).isDisplayed();
        tearDown();
    }

    public void setRegister(Boolean click){
        WebElement _registerButton = driver.findElement(
                By.xpath("//*[text()='Register For Appian Community']"));
        if (click) _registerButton.click();
    }

    public void setForgotPassword(Boolean click){
        WebElement _forgotPassword = driver.findElement(By.className("link js-forgot-password"));
        if (click) _forgotPassword.click();
    }
}
