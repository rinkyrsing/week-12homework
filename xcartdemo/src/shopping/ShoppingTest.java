package shopping;

import browserfactory.Utility;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Mouse;

public class ShoppingTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAppleiPhoneSEOptions() throws InterruptedException {

        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//div[@class='collapse navbar-collapse']/ul[1]/li[2]/span"));

        //Mouse hover on the “Bestsellers”  link and click
        mouseHover(By.xpath("//*[@id='header-area']/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));
        clickMouseHoverOnElement(By.linkText("Bestsellers"));

        //Verify the text “Bestsellers”
        assertVerifyText(By.id("page-title"), "Bestsellers");

        // Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[@class='sort-by-value']"));
        clickMouseHoverOnElement(By.linkText("Name A - Z"));

        //Click on “Add to cart” button of the product Apple iPhone SE
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']\n" +
                "/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[2]/div[4]/div[1]/button[1]"));

        // Verify the message “Product has been added to your cart” display in  green bar
        assertVerifyText(By.xpath("//li[contains(text(),'Product has been added to your cart')]"), "Product has been added to your cart");

        //Click on X sign to close the message
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='status-messages']/a"));


        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.linkText("View cart"));

        // Verify the text “Your shopping cart - 1 item”
        assertVerifyText(By.id("page-title"), "Your shopping cart - 1 item");

        //Click on “Go to checkout” button
        clickOnElement(By.xpath("//span[text()='Go to checkout']"));

        // Verify the text “Log in to your account”
        assertVerifyText(By.xpath("//h3[text()='Log in to your account']"), "Log in to your account");

        // Enter Email address
        sendTextToElement(By.id("email"), "amysmith12@gmail.com");

        //Click on “Continue” Button
        clickOnElement(By.xpath("//span[text()='Continue']"));

        // Verify the text “Secure Checkout”
        assertVerifyText(By.xpath("//h1[@class='title']"), "Secure Checkout");

        // Fill all the mandatory fields
        sendTextToElement(By.id("shippingaddress-firstname"), "Amy");
        sendTextToElement(By.id("shippingaddress-lastname"), "Smith");
        sendTextToElement(By.id("shippingaddress-street"), "2, station Road");
        sendTextToElement(By.id("shippingaddress-city"), "");
        Thread.sleep(2000);
        selectByValue(By.id("shippingaddress-country-code"), "US");

        // sendTextToElement(By.name("shippingAddress[custom_state]"),"California");
        sendTextToElement(By.id("shippingaddress-zipcode"), "TT3 4T");
        sendTextToElement(By.id("shippingaddress-phone"), "0333333333333");
        sendTextToElement(By.id("email"), "amysmith12@gmail.com");

        // Check the check box “Create an account for later use”
        Thread.sleep(2000);
        clickOnElement(By.name("create_profile"));

        // Enter the password
        sendTextToElement(By.id("password"), "amysmith123");

        //Select the Delivery Method to “Local Shipping”
        Thread.sleep(2000);
        clickOnElement(By.id("method128"));

        //Select Payment Method “COD”
        clickOnElement(By.id("pmethod6"));

        //Click on “Place Order” Button
        clickOnElement(By.xpath("//button[@type='submi']"));

        //Verify the text “Thank you for your order”
        assertVerifyText(By.id("page-title"), "Thank you for your order");

    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//div[@class='collapse navbar-collapse']/ul[1]/li[2]/span"));

        //Mouse hover on the “Bestsellers”  link and click
        mouseHover(By.xpath("//*[@id='header-area']/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));
        clickMouseHoverOnElement(By.linkText("Bestsellers"));

        //Verify the text “Bestsellers”
        assertVerifyText(By.id("page-title"), "Bestsellers");

        // Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[@class='sort-by-value']"));
        clickMouseHoverOnElement(By.linkText("Name A - Z"));

        //Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        mouseHover(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[8]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//ul[@class = 'products-grid grid-list']/li[8]/div/div[2]/div[4]/div/button"));

        // Verify the message “Product has been added to your cart” display in  green bar
        assertVerifyText(By.xpath("//li[contains(text(),'Product has been added to your cart')]"), "Product has been added to your cart");

        //Click on X sign to close the message
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='status-messages']/a"));


        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.linkText("View cart"));

        // Verify the text “Your shopping cart - 1 item”
        assertVerifyText(By.id("page-title"), "Your shopping cart - 1 item");

        //Click on “Empty your cart” link
        clickOnElement(By.xpath("//a[@class='clear-bag']"));

        //Click “Ok” on alert
        alertMessage();

        //Verify the message “Item(s) deleted from your cart”
        assertVerifyText(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"),"Item(s) deleted from your cart");

        //Verify the text “Your cart is empty”
        assertVerifyText(By.xpath("//h1[contains(text(),'Your cart is empty')]"),"Your cart is empty");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
