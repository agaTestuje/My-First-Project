import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class exercisesAutomationpractice {

    static WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
        driver.get("http://automationpractice.com/");
    }

    @AfterEach
    void driverQuit() {
    driver.quit();
    }

    //Ex 1 - login without entering a login
    @Test
    void emptyLoginField(){
        WebElement signInField = driver.findElement(By.cssSelector(".login"));
        signInField.click();
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name = 'passwd']"));
        WebElement signInButton = driver.findElement(By.xpath("//button[@id = 'SubmitLogin']"));
        //WebElement signInButton = driver.findElement(By.xpath("//span[text() = ' Sign in ']"));
        passwordInput.sendKeys("Haslo123");
        signInButton.click();
        WebElement errorBox = driver.findElement(By.cssSelector(".alert-danger"));
        System.out.println(errorBox.getText());

        Assertions.assertEquals("There is 1 error\nAn email address required.", errorBox.getText().trim());

    }

    //Ex 2 - logging in without entering a password
    @Test
    void emptyPasswordField(){
        WebElement signInField = driver.findElement(By.cssSelector(".login"));
        signInField.click();
        WebElement loginInput = driver.findElement(By.xpath("//input[@name = 'email']"));
        WebElement signInButton = driver.findElement(By.xpath("//button[@id = 'SubmitLogin']"));
        loginInput.sendKeys("Firstname@test.com");
        signInButton.click();
        WebElement errorBox = driver.findElement(By.cssSelector(".alert-danger"));
        System.out.println(errorBox.getText());

        Assertions.assertEquals("There is 1 error\nPassword is required.", errorBox.getText().trim());
    }

    //Ex 3 - logo and searching field on the side
    @Test
    void logoAndSearchFieldOnMainPage(){
        WebElement logoImgOnMainPage = driver.findElement(By.cssSelector(".img-responsive"));
        WebElement searchFieldOnMainPage = driver.findElement(By.id("search_query_top"));
        WebElement signInField = driver.findElement(By.cssSelector(".login"));
        signInField.click();
        WebElement logoFieldOnLoginPage = driver.findElement(By.cssSelector(".img-responsive"));
        WebElement searchFieldOnLoginPage = driver.findElement(By.xpath("//input[@id = 'search_query_top']"));

        //Assertions.assertTrue(driver.findElement("//img-responise").isDisplayed());

    }

    //Ex 4 - go from main page to contact page
    @Test
    void mainPageToContactPage(){
        WebElement contactInput = driver.findElement(By.xpath("//a[@title = 'Contact us']"));
        contactInput.click();
        WebElement contactUsSite = driver.findElement(By.cssSelector(".page-heading"));
        String entryUrl = "http://automationpractice.com/index.php?controller=contact";
        //Assertions.assertEquals(" Customer service - Contact us", entryUrl);

        Assertions.assertTrue(driver.findElement(By.xpath("//a[@title = 'Contact us']")).isDisplayed());
        System.out.println("You are on Contact page");

    }

    //Ex 5 - go from login page to main page
    @Test
    void loginPageToMainPage(){
        WebElement loginPage = driver.findElement(By.cssSelector(".login"));
        loginPage.click();
        driver.navigate().back();
        //WebElement mainPage = driver.findElement(By.cssSelector(".img-responsive"));
        //mainPage.click();
        String actualUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        String expectedUrl = "http://automationpractice.com/";
        //Assertions.assertEquals(actualUrl, expectedUrl);
        //Assertions.assertTrue(driver.findElement(By.xpath("//a[@id = 'slider_row']")).isDisplayed();
        System.out.println("You are on main page");
        Assertions.assertTrue(driver.findElement(By.cssSelector("#slider_row")).isDisplayed());
    }

    //Ex 6 - add product to basket
    @Test
    void addProductToBasket(){
        WebElement dresses = driver.findElement(By.cssSelector(".sf-with-ul"));
        dresses.click();
        WebElement addToBasket = driver.findElement(By.cssSelector(".ajax_add_to_cart_button"));
        addToBasket.click();
        WebElement checkBasket = driver.findElement(By.xpath("//a[@title = 'View my shopping cart']"));
        checkBasket.click();
        //WebElement checkBasket = driver.findElements(By.xpath("//a[@title = 'View my shopping cart']"));

        //Assertions.assertTrue(driver.findElement());

       // WebElement addDressToBasket = driver.findElements(By.cssSelector(".ajax_add_to_cart_button"));
       // addDressToBasket.click();

    }
    //Ex 7 - add and remove product from basket
    @Test
    void addAndRemoveProductFromBasket() {
        WebElement dresses = driver.findElement(By.cssSelector(".sf-with-ul"));
        dresses.click();
        WebElement addToBasket = driver.findElement(By.cssSelector(".ajax_add_to_cart_button"));
        addToBasket.click();
        WebElement closeWindow = driver.findElement(By.xpath("//a[@title = 'Close window']"));
        closeWindow.click();
        WebElement checkBasket = driver.findElement(By.xpath("//a[@title = 'View my shopping cart']"));
        checkBasket.click();
    }
}
