package TeeTimeBooker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class app
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\brian\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }
}
