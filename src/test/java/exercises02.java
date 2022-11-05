import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class exercises02 {
    //Zadanie 1
    @Test
    void LoginFieldEmpty(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.saucedemo.com/");
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        passwordInput.sendKeys("Hasło123!!!");
        loginButton.click();
        WebElement errorAlert = driver.findElement(By.cssSelector(".error-message-container"));
        System.out.println(errorAlert.getText());
        Assertions.assertEquals("Epic sadface: Username is required",errorAlert.getText());
        driver.quit();
    }

    //Zadanie 2
    @Test
    void PasswordFieldEmpty() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get("https://www.saucedemo.com/");
        WebElement loginInput = driver.findElement(By.id("user-name"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginInput.sendKeys("logintest123");
        loginButton.click();
        //Thread.sleep(7000);
        WebElement errorAlert = driver.findElement(By.cssSelector(".error-message-container"));
        System.out.println(errorAlert.getText());
        Assertions.assertEquals("Epic sadface: Password is required", errorAlert.getText());
        driver.quit();
    }

    //Zadanie 3
    /*@Test
    void PasswordEmpty() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("http://automationpractice.com/");
        Boolean logoImage = driver.findElements(By.xpath("//img[@title='My store']"));
        //Assertions.assertTrue(driver.findElement(By.xpath("//a[@title = 'Contact us']")).isDisplayed();
        Assertions.assertTrue(logoImage);
    }*/

    //Zadanie 4 i 5

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("http://automationpractice.com/");
    }
    @AfterEach
    public void driverQuit(){
        driver.quit();
    }

    @Test
    void MainPageToContactPage() {
        WebElement contactInput = driver.findElement(By.xpath("//a[@title = 'Contact us']"));
        contactInput.click();
        //System.out.println(contactInput.getText());
        //String entryUrl = "http://automationpractice.com/index.php?controller=contact";
        //Assertions.assertEquals("You are on Contact page", entryUrl);
        //Assertions.assertTrue(driver.findElement(By.xpath("//a[@title = 'Contact us']")).isDisplayed();
    }
}
