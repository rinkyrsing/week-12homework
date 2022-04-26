package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find log in link and click on login link
        clickOnElement(By.linkText("Log in"));

        //This is from requirement
        String expectedMessage = "Welcome, Please Sign In!";

        //Find the welcome text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        //Validate actual and expected message
        //("Not navigate to login page", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //  click on login link
        clickOnElement(By.linkText("Log in"));

        //Passing valid user name in user field
        sendTextToElement(By.id("Email"), "amysmith@gmail.com");

        //  Passing password feild
        sendTextToElement(By.id("Password"),"amy123");

        //Login button
        clickOnElement(By.partialLinkText("Log in"));

        //find logout button
        WebElement logout = driver.findElement(By.className("ico-logout"));
        if (logout.isDisplayed()) {
            System.out.println("Verification completed successfully - 'Log out' is not displayed on the wed pade");
        } else {
            System.out.println("Verification completed Unsuccessfully - 'Log out' is not displayed on the wed pade");
        }
    }

    @Test
    public void verifyTheErrorMessage() {
        //Find log in link and click on login link
        clickOnElement(By.linkText("Log in"));

        //find email element
        sendTextToElement(By.id("Email"), "amysmith12@gmail.com");

        // Find password field element
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("amy123");
        sendTextToElement(By.name("Password"), "amy123");

        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));


        String expectedErrorMessade = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = getTextFromElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        Assert.assertEquals("Error message not display", expectedErrorMessade, actualErrorMessage);

    }

    @After
    public void tearDown() {

        closeBrowser();
    }

}
