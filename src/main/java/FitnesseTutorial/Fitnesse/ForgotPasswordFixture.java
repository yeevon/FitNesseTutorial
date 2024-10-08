package FitnesseTutorial.Fitnesse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordFixture {
    private WebDriver driver;
    private final DriverSetup ds;

    public ForgotPasswordFixture() {
        ds = new DriverSetup();
    }

    public void setForgotPassword(String s) throws Exception{
        driver = ds.setup();
        try {
            WebElement _forgotPassword = driver.findElement(By.xpath("//*[@class='link js-forgot-password']"));
            _forgotPassword.click();
            ds.checkForText(driver, s);
        } catch (Exception e) {
            driver.quit();
            throw new Exception(e);
        }
    }

    public void setEmail(String email) throws Exception{
        try {
            Thread.sleep(4000);
            WebElement _email = driver.findElement(By.name("identifier"));
            _email.sendKeys(email);
        }
        catch (Exception e) {
            driver.quit();
            throw new Exception(e);
        }
    }

    public void setReset(String s) throws Exception{
        try {
            WebElement _nextButton = driver.findElement(By.xpath("//*[@value='Next']"));
            _nextButton.click();
            ds.checkForText(driver, s);
            ds.tearDown(driver);
        }
        catch (Exception e) {
            driver.quit();
            throw new Exception(e);
        }
    }
}
