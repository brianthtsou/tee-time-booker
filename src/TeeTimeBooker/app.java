package TeeTimeBooker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v113.systeminfo.model.ProcessInfo;
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


        WebDriverManager.chromedriver().setup();

//        System.setProperty("webdriver.chrome.driver","C:\\Users\\brian\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.golfburnaby.ca/book-tee-time");
        wait(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement bookButton = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[3]/div/article/div/div/div/div[1]/div/p[3]/a"));
        bookButton.click();
        wait(3000);

        // to get datebutton will need to update each time
        WebElement dateButton = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-search-teetime-page/div/div[1]/app-search-teetime-filters/div/div/app-ngx-dates-picker/div/div/div[2]/div[2]/span[32]/span[1]"));
        dateButton.click();
        // click button to indicate 4 players
        wait(3000);
        driver.findElement(By.id("mat-button-toggle-4-button")).click();
        // class="teetimetableDateTime"
        wait(3000);
        WebElement time = driver.findElement(By.xpath("//*[text()=' 6:57 PM ']"));
        time.click();

        //environment variables in java ide
        WebElement emailForm = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-verify-email/div/div[2]/div/div[2]/form/div[1]/mat-form-field/div/div[1]/div[3]/input"));
        emailForm.sendKeys(System.getenv("USER_EMAIL"));
        wait(2000);
        WebElement nextButton = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-verify-email/div/div[2]/div/div[2]/form/div[2]/button/span[1]"));
        nextButton.click();
        wait(2000);

        new Actions(driver)
                .sendKeys(System.getenv("USER_PASSWORD"))
                .sendKeys(Keys.RETURN)
                .perform();

        wait(2000);

        WebElement goNextButton = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-end-user-agreement-layout-page/app-end-user-agreement-page/div/div[1]/mat-card/mat-card-content/div/div[3]/button/span[1]"));
        goNextButton.click();

        wait(2000);
        WebElement finalize = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-checkout-layout-page/app-checkout-page-v2/div/div[2]/div/button[1]/span[1]"));
        finalize.click();
    }
}
