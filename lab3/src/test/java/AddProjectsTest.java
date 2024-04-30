import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProjectsTest {

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
    public void addProject() throws InterruptedException {
        driver.get("https://statcounter.com");
        WebElement btn = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[1]/nav/ul/li[5]/a"));
        btn.click();
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        login.sendKeys("ExcaliBBur");
        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        password.sendKeys("v2H6$wua9G$e#.E");
        Thread.sleep(3000);
        btn = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        btn.click();
        Thread.sleep(5000);
        btn = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div/div/div[3]/div[2]/a[1]"));
        btn.click();
        Thread.sleep(5000);
        WebElement header = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[3]/div/div/h1"));
        assertEquals("Choose a plan for your new project.", header.getText());
    }
}