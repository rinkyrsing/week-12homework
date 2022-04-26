package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class ForgotPasswordTest extends Utility {
    String baseUrl= "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setup()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully()
    {

        clickOnElement(By.linkText("Forgot your password?"));

        String expectedResult = "Forgot Your Password?";

        String actualResult = getTextFromElement(By.xpath("//div/div[2]/h1"));

        Assert.assertEquals("Error occured",expectedResult,actualResult);
    }

    @After
    public void close()
    {
        closeBrowser();
    }
}
