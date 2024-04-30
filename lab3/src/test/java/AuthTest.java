import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void successfulAuth() throws InterruptedException {
        driver.get("https://statcounter.com");
        WebElement btn = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[1]/nav/ul/li[5]/a"));
        btn.click();
        Thread.sleep(5000);
        WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        login.sendKeys("ExcaliBBur");
        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        password.sendKeys("v2H6$wua9G$e#.E");
        Thread.sleep(5000);
        btn = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        btn.click();
        Thread.sleep(5000);
        WebElement header = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/header/ul/li[1]/span[2]/span"));
        assertEquals("(Admin User)", header.getText());
    }

    @Test
    public void logout() throws InterruptedException {
        driver.get("https://statcounter.com");
        WebElement btn = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[1]/nav/ul/li[5]/a"));
        btn.click();
        Thread.sleep(5000);
        WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        login.sendKeys("ExcaliBBur");
        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        password.sendKeys("v2H6$wua9G$e#.E");
        Thread.sleep(5000);
        btn = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        btn.click();
        Thread.sleep(5000);
        btn = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/header/ul/li[1]/span[2]/span"));
        btn.click();
        btn = driver.findElement(By.xpath("/html/body/div[4]/div[4]/div/ul/li[5]/a"));
        btn.click();
        WebElement header = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/h2"));
        assertEquals("Logged out", header.getText());
    }

    @Test
    public void failedAuth() throws InterruptedException {
        driver.get("https://statcounter.com");
        WebElement btn = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[1]/nav/ul/li[5]/a"));
        btn.click();
        Thread.sleep(5000);
        WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        login.sendKeys("ExcaliBBur");
        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        password.sendKeys("v2H6$wua");
        Thread.sleep(5000);
        btn = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        btn.click();
        Thread.sleep(5000);
        WebElement header = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/h2"));
        assertEquals("Invalid Username or Password", header.getText());
    }
}