package FitnesseTutorial.Fitnesse;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFixture {
    private WebDriver driver;
    private final DriverSetup ds;

    public LoginFixture() {
        ds = new DriverSetup();
    }

    public void setEmail(String email) throws Exception {
        driver = ds.setup();
        try {
            WebElement _email = driver.findElement(By.id("input28"));
            _email.sendKeys(email);
        } catch (Exception e) {
            driver.quit();
            throw new Exception(e);
        }
    }

    public void setPassword(String password) throws Exception{
        try {
            WebElement _password = driver.findElement(By.id("input36"));
            _password.sendKeys(password);
        } catch (Exception e) {
            driver.quit();
            throw new Exception(e);
        }
    }

    public void setRememberMe(Boolean rememberMe) throws Exception{
        try {
            if (rememberMe == null) rememberMe = false;
            WebElement _rememberMe = driver.findElement(By.xpath("//*[text()='Remember my Email']"));
            if (rememberMe) _rememberMe.click();
        } catch (Exception e) {
            driver.quit();
            throw new Exception(e);
        }
    }

    public void setSignIn(String s) throws Exception{
        try {
            WebElement _signInButton = driver.findElement(By.xpath("//*[@value='Sign in']"));
            _signInButton.click();
            ds.checkForText(driver, s);
            ds.tearDown(driver);
        } catch (Exception e) {
            driver.quit();
            throw new Exception(e);
        }
    }

    public void setRegister(String s){
        try {
            WebElement _registerButton = driver.findElement(
                    By.xpath("//*[text()='Register For Appian Community']"));
            _registerButton.click();
            ds.checkForText(driver, s);
        } catch (Exception e){
            if (e instanceof NoSuchElementException) {
                driver.quit();
                throw new NoSuchElementException("Registration failed " + e);
            }
        }
        ds.tearDown(driver);
    }
}
