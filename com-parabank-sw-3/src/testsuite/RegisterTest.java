package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    //super class method to open the browser
    public void steUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //loge in with valid username
        sendTextToElement(By.xpath("//input[@name='username']"),"AmySmith");

        //loge in with valid password
        sendTextToElement(By.xpath("//input[@name='password']"),"welcome123");

        //Login with login button
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //Verify the ‘Accounts Overview’ text is display
        String expectedResult = "Accounts Overview";

        String actualResult = getTextFromElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));

        //verifying actual outcome with expected
        Assert.assertEquals("Error occurred", expectedResult, actualResult);
    }
    @Test
    public void verifyTheErrorMessage(){
        //  Verify the error message ‘The username and password could not be verified.’
        //loge in with valid username
        sendTextToElement(By.xpath("//input[@name='username']"),"AmySmith!!");

        //loge in with valid password
        sendTextToElement(By.xpath("//input[@name='password']"),"welcome12");

        //Login with login button
        clickOnElement(By.xpath("//input[@value='Log In']"));

        String expectedResult = "The username and password could not be verified.";

        String actualResult = getTextFromElement(By.xpath("//p[@class='error']"));

        //verifying actual outcome with expected
        Assert.assertEquals("Error occurred", expectedResult, actualResult);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //loge in with valid username
        sendTextToElement(By.xpath("//input[@name='username']"),"AmySmith");

        //loge in with valid password
        sendTextToElement(By.xpath("//input[@name='password']"),"welcome123");

        //Login with login button
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //log Out like
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));


        String expectedResult = "Customer Login";

        String actualResult = getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]"));

        Assert.assertEquals("error occurred", expectedResult, actualResult);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
