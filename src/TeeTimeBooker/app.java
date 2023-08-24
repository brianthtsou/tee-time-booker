package TeeTimeBooker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import java.time.Duration;

public class app
{
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\brian\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.golfburnaby.ca/book-tee-time");
        wait(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement bookButton = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[3]/div/article/div/div/div/div[1]/div/p[3]/a"));
        bookButton.click();
        wait(7000);

        // to get datebutton will need to update each time
        WebElement dateButton = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-search-teetime-page/div/div[1]/app-search-teetime-filters/div/div/app-ngx-dates-picker/div/div/div[2]/div[2]/span[30]/span[1]"));
        dateButton.click();
        // click button to indicate 4 players
        driver.findElement(By.id("mat-button-toggle-4-button")).click();
        // class="teetimetableDateTime"

    }
}
