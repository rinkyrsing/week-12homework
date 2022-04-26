package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void open() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully()
    {

        clickOnElement(By.linkText("Sign In"));
        String expectedResult = "Welcome Back!";
        String actualResult = getTextFromElement(By.cssSelector("h1.page__heading"));

        Assert.assertEquals("error occured",expectedResult,actualResult);

    }

    @Test
    public void verifyTheErrorMessage()
    {
        clickOnElement(By.linkText("Sign In"));
        sendTextToElement (By.id("user[email]"),"abc@gmail.com");
        sendTextToElement(By.id("user[password]"),"123456");
        clickOnElement(By.cssSelector("input.button.button-primary.g-recaptcha"));

        String expectedresult = "Invalid email or password.";
        String actualResult = getTextFromElement(By.xpath("//li[text() ='Invalid email or password.' ]"));

        Assert.assertEquals("Error occured",expectedresult,actualResult);

    }
    @After
    public void close() {
        closeBrowser();
    }


}
