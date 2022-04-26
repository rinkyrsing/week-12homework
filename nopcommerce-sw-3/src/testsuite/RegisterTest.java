package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/register?returnUrl=%2F";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfull() {
        clickOnElement(By.className("ico-register"));
        String expectedResult = "Register";
        String actualResult = getTextFromElement(By.xpath("//div[@class='page-title']"));
        Assert.assertEquals("Invalid result",expectedResult,actualResult);
    }

    @Test
    public void userShouldRegisterAccountSuccessfull() {

         clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        // getting gender radio button
        clickOnElement(By.id("gender-male"));

        //Find First name and send value
        sendTextToElement(By.id("FirstName"),"Amy");

        //Finding last name and send value
        sendTextToElement(By.id("LastName"),"Smith");

        // Finding date elements
        selectByValue(By.name("DateOfBirthDay"),"19");

        //Finding month
        selectByVisibleTextFromDropDown(By.name("DateOfBirthMonth"),"May");

        //Finding year element
         selectByValue(By.name("DateOfBirthYear"),"1982");

         // Finding Email
        sendTextToElement(By.id("Email"),"amysmith12@gmail.com");

        // password
        sendTextToElement(By.id("Password"),"amy123");

        //Confirm password
        sendTextToElement(By.id("ConfirmPassword"),"amy123");

        //Registration
        clickOnElement(By.id("register-button"));

        //Verifying successful registration
         String actualText = getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));

         String expectedText = "Your registration completed";
        //Validating actual and expected text
        Assert.assertEquals("Not found 'Your registration completed' text", expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
