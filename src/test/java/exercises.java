import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class exercises {
    @Test
    void emptyLoginField() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        passwordInput.sendKeys("Haslo123");
        submitButton.click();
        WebElement errorBox = driver.findElement(By.cssSelector(".error-message-container"));
        System.out.println(errorBox.getText());

        Assertions.assertEquals("Epic sadface: Username is required", errorBox.getText());
        driver.quit();
    }
        @Test
        void emptyPasswordField(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement loginInput = driver.findElement(By.id("user-name"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        loginInput.sendKeys("LoginTest");
        submitButton.click();
        WebElement errorBox = driver.findElement(By.cssSelector(".error-message-container"));
        System.out.println(errorBox.getText());

        Assertions.assertEquals("Epic sadface: Password is required", errorBox.getText());
        driver.quit();
    }


}
