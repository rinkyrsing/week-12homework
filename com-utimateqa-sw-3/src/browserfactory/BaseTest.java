package browserfactory;

import com.sun.org.apache.bcel.internal.classfile.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest extends Utility {
    public WebDriver driver;
    public void openBrowser(String baseUrl) {

        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(baseUrl);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    public void closeBrowser()
    {
        driver.quit();
    }
}

