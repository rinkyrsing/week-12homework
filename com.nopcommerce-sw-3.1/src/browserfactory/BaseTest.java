package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public void openBrowser(String baseUrl){
        //Launch web on chrome driver
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(baseUrl);

        //maximum window
        driver.manage().window().maximize();

        String  title = driver.getTitle();
        System.out.println("Title: " + title);

        //implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public void closeBrowser(){
        driver.quit();
    }

}
