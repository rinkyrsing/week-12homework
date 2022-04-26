package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void open() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));

        String expectedResult = "PRODUCTS";
        String actualResult = getTextFromElement(By.xpath("//span[@class = 'title']"));

        Assert.assertEquals("error occurs", expectedResult, actualResult);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");
        clickOnElement(By.id("login-button"));

        int expectedResult = 6;
        List<WebElement> item = driver.findElements(By.className("inventory_item"));
        int list = item.size();

        Assert.assertEquals("error occured", expectedResult, list);


    }

    @After
    public void close() {
        closeBrowser();
    }
}
