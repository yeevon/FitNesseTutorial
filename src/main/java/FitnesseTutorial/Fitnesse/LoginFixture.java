package FitnesseTutorial.Fitnesse;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFixture {
    private WebDriver driver;
    private final DriverSetup ds;
    private Boolean astor;

    public LoginFixture() {
        ds = new DriverSetup();
    }

    public void setTestURL(String url) {
        driver = ds.setup();
        driver.get(url);
        if (url.contains("astor")) astor = true;
    }

    public void setEmail(String email) throws Exception {
        if (astor) {
            Email(email, "un");
        }
        else Email(email, "input28");

    }

    private void Email(String email, String id)  throws Exception{
        try {
            WebElement _email = driver.findElement(By.id(id));
            _email.sendKeys(email);
        } catch (Exception e) {
            driver.quit();
            throw new Exception(e);
        }
    }

    public void setPassword(String password) throws Exception{
        if (astor) {
            Email(password, "pw");
        }
        else Email(password, "input36");
    }

    private void Password(String password, String id) throws Exception{
        try {
            WebElement _password = driver.findElement(By.id(id));
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
        if (astor) {
            SignIn(s, "Sign In");
        }
        else SignIn(s, "Sign in");
    }

    private void SignIn(String s, String value) throws Exception{
        try {
            WebElement _signInButton = driver.findElement(By.xpath("//*[@value='" + value + "']"));
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
