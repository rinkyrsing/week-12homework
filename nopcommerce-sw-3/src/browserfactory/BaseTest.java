package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {


        //Declaring driver
        public static WebDriver driver;

        public void openBrowser(String baseUrl) {
            //Lancing Browser
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            driver = new ChromeDriver();

            //Launch Url
            driver.get(baseUrl);

            //Get title
            String title = driver.getTitle();
            System.out.println("Title: " + title);

            //Maximise Window
            driver.manage().window().maximize();

            //Giving implicit time to driver
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        }

        public void closeBrowser() {
            driver.quit();
        }
}






