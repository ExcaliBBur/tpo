import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTest {

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
    public void clickDemo() throws InterruptedException {
        driver.get("https://statcounter.com");
        WebElement btn = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[1]/nav/ul/li[3]/a"));
        btn.click();
        Thread.sleep(5000);
        WebElement header = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[1]/header/ul/li/span[2]/span"));
        assertEquals("(Viewing as Guest)", header.getText());
    }
}