package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        sendTextToElement(By.id("txtUsername"),"Admin");
        sendTextToElement(By.id("txtPassword"),"admin123");
        clickOnElement(By.id("btnLogin"));

        String expectedResult = "Welcome";
        String actualResult = getTextFromElement(By.xpath("//a[contains(text(),'Welcome')]"));
        String mainResult = actualResult.substring(0,7);
        Assert.assertEquals("invalid",expectedResult, mainResult);

    }
    @After
    public void close()
    {
        closeBrowser();
    }



}
