package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import utility.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void Setup() {

        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() {
        // Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));


        //Mouse Hover on “Cell phones” and click
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cell phones')]"));

        //Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[text()='Cell phones']"), "Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        // Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));


        //Mouse Hover on “Cell phones” and click
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cell phones')]"));

        //Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[text()='Cell phones']"), "Cell phones");

        //Click on List View Tab
        clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));
        //Click on product name “Nokia Lumia 1020” link

        Thread.sleep(2000);
        //Verify the text “Nokia Lumia 1020”
        assertVerifyText(By.xpath("//a[text()='Nokia Lumia 1020']"), "Nokia Lumia 1020");

        //Verify the price “$349.00”
        assertVerifyText(By.xpath("//span[contains(text(),'$349.00')]"), "$349.00");

        //Add to Cart
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        assertVerifyText(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");

        //close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));

        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));

        //Click on "GO TO CART" button
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));


        //Verify the message "Shopping cart"
        assertVerifyText(By.xpath("//h1[text()='Shopping cart']"), "Shopping cart");

        //Change the Qty to "2" and Click on "Update shopping cart"
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//tbody/tr/td[5]/input")).sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);
        //Updating the quantity
        sendTextToElement(By.xpath("//tbody/tr/td[5]/input"), "2");

        //Verify the Total $698.00
        //assertVerifyText(By.xpath("//strong[contains(text(),'$698.00')]"),"$698.00");

        //click on checkbox “I agree with the terms of service”
         clickOnElement(By.id("termsofservice"));

        //Click on checkout
        clickOnElement(By.id("checkout"));

        //Verify the Text “Welcome, Please Sign In!”
        assertVerifyText(By.xpath("//h1[text()='Welcome, Please Sign In!']"),"Welcome, Please Sign In!");
//==================================Register===========================
       //Verify the text “Register”
        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));

        //Fill the mandatory fields
        clickOnElement(By.id("gender-female"));

        //First Name
        sendTextToElement(By.id("FirstName"),"Amy");
        sendTextToElement(By.id("LastName"),"Smith");

        //Email
        sendTextToElement(By.id("Email"),"amysmith141@gmail1.com");

        //Password
        sendTextToElement(By.id("Password"),"amysmith123");
        sendTextToElement(By.id("ConfirmPassword"),"amysmith123");

        //Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

        //Verify the message “Your registration completed”
        assertVerifyText(By.xpath("//div[text()='Your registration completed']"),"Your registration completed");

        //Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[text()='Continue']"));

        //Verify the message "Shopping cart"
       assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

       //Fill the Mandatory fields
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Aamy");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Smith");
        sendTextToElement(By.id("BillingNewAddress_Email"), "amysmith123@gmail.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"India");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "2, Station Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "CTT1 4BB");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07777777777");

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text()='Continue']"));
       // Thread.sleep(2000);
        clickOnElement(By.id("shippingoption_2"));
        Thread.sleep(2000);
        //clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        // Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //select credit card
        selectByValue(By.id("CreditCardType"),"visa");

        //Cardholder Name
        sendTextToElement(By.id("CardholderName"),"Aamy Smith");

        //Card Number
        sendTextToElement(By.id("CardNumber"),"4263982640269299");

        //Expire date
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"04");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2023");

        sendTextToElement(By.id("CardCode"),"738");

        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        assertVerifyText(By.xpath("//li[@class='payment-method']/span[2]"),"Credit Card");
        assertVerifyText(By.xpath("//li[@class='shipping-method']/span[2]"),"2nd Day Air");
        assertVerifyText(By.xpath("//td[@class='subtotal']/span"),"$698.00");
        clickOnElement(By.xpath("//button[text()='Confirm']"));

        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");
        assertVerifyText(By.xpath("//div[@class='section order-completed']//strong"),"Your order has been successfully processed!");


        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");

        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/",url);


    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}

