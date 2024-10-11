package FitnesseTutorial.Fitnesse;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.jetbrains.annotations.NotNull;
import java.time.Duration;

public class DriverSetup {
    public WebDriver setup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return  driver;
    }
    public void tearDown(@NotNull WebDriver driver) {
        driver.quit();
    }

    public void checkForText(WebDriver driver, String s) {
        driver.findElement(By.xpath("//*[text()='"+s+"']")).isDisplayed();
    }
}
