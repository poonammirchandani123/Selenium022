import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class MouseActionsDemo {
    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        driver.manage().window().maximize();

        // Wait for elements to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize Actions class
        Actions actions = new Actions(driver);

        try {
            // Wait for elements to be visible before interacting
            WebElement rightClickElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("context-menu")));

            // Perform Right-click
            actions.contextClick(rightClickElement).perform();

            System.out.println("Mouse actions performed successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
