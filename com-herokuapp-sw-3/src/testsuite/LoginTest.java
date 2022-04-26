package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

public class LoginTest extends Utility {

    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void open()
    {
        openBrowser(baseUrl);

    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        sendTextToElement(By.id("username"),"tomsmith");
        sendTextToElement (By.id("password"),"SuperSecretPassword!");
        clickOnElement (By.xpath("//button[@type='submit']"));

        String expectedResult ="Secure Area";
        String actualResult = getTextFromElement(By.xpath("//h2[text()=' Secure Area']"));

        Assert.assertEquals("Error occur",expectedResult,actualResult);
    }
    @Test
    public void verifyTheUsernameErrorMessage()
    {
        sendTextToElement(By.id("username"),"tomsmith1");
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//button[@type='submit']"));
        ////div[contains(text(),'Your username is invalid!')]
        String expectedResult = "Your username is invalid!";
        String actualResult = getTextFromElement(By.xpath("//div[contains(text(),'Your username is invalid!')]"));
        String mainResult = actualResult.substring(0,25);
        //System.out.println(main);

        Assert.assertEquals("error occur",expectedResult,mainResult);
    }

    @Test
    public void verifyThePasswordErrorMessage()
    {
        sendTextToElement(By.id("username"),"tomsmith");
        sendTextToElement(By.id("password"), "SuperSecretPassword");
        clickOnElement(By.xpath("//button[@type='submit']"));

        String expectedResult = "Your password is invalid!";
        String actualResult = getTextFromElement(By.xpath("//div[contains(text(),'Your password is invalid!')]"));
        String mainResult = actualResult.substring(0,25);

        Assert.assertEquals("error occur",expectedResult,mainResult);
    }
    @After
    public void close()
    {
        closeBrowser();
    }

}
