package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void Setup() {

        openBrowser(baseUrl);
    }


    @Test
    public void name() throws InterruptedException {
        //click on Computer
        clickOnElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text() = 'Computers ']"));
        //Click on Desktop
        clickOnElement(By.xpath("//div[@class='picture']/a//img[@alt='Picture for category Desktops']"));
        clickOnElement(By.id("products-orderby"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Price: Low to High");
    }

    @Test
    public void VerifyPriceOrderLowToHigh() throws InterruptedException, NumberFormatException {
        //click on computers
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));

        Thread.sleep(1000);
        List<WebElement> beforeFilter = driver.findElements(By.xpath("//span[contains(@class, 'actual-price')]"));
        List<Double> beforeFilterPriceList = new ArrayList();

        for (WebElement p : beforeFilter) {
            beforeFilterPriceList.add(Double.parseDouble(p.getText().trim().replace(",", "").replace(",", "")));
            // boolean check = Ordering.natural().isOrdered(beforeFilterPriceList);
        }

        //sort by Price : Low to High
        selectByValue(By.id("products-orderby"), "10");
        Thread.sleep(1000);
        List<WebElement> afterFilter = driver.findElements(By.xpath("//span[contains(@class, 'actual-price')]"));
        List<Double> afterFilterPriceList = new ArrayList<>();

        for (WebElement q : afterFilter) {
            afterFilterPriceList.add(Double.parseDouble(q.getText().replace("$", "").replace(",", "")));
        }
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws
            ElementClickInterceptedException, InterruptedException {

        //click on Computer
        clickOnElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text() = 'Computers ']"));

        //Click on Desktop
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='picture']/a//img[@alt='Picture for category Desktops']"));

        //selecting the element
        clickOnElement(By.xpath("//h2[@class='product-title']/a[contains(text(),'Build your own computer')]"));

        //Click on cart
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        //Verify the text
        assertVerifyText(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");

        //Select 2.2 GHz Intel Pentium Dual-Core E2200
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //Select RAM "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");

        //Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));

        //verify the price
        System.out.println(driver.findElement(By.cssSelector("#price-value-1")).getText());
        assertVerifyText(By.cssSelector("#price-value-1"), "$1,475.00");

        //Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        assertVerifyText(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");

        //close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));

        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//a[@class='ico-cart']"));

        //Click on "GO TO CART" button
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));

        //Verify the message "Shopping cart"
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //Change the Qty to "2" and Click on "Update shopping cart"
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//tbody/tr/td[5]/input")).sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);
        //Updating the quantity
        sendTextToElement(By.xpath("//tbody/tr/td[5]/input"), "2");

        // Verify the Total"$2,950.00"
        assertVerifyText(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"), "$2,950.00");

        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //20 Verify the Text “Welcome, Please Sign In!”
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Amy");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Smith");
        sendTextToElement(By.id("BillingNewAddress_Email"), "amysmith123@gmail.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "India");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "2, Station Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "CTT1 4BB");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07777777777");

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text()='Continue']"));
        //
        clickOnElement(By.id("shippingoption_1"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

        //Verify “Payment Method” is “Credit Card”
        assertVerifyText(By.xpath("//label[text()='Credit Card']"), "Credit Card");

        //click on continue button
        clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));

        //select credit card
        selectByValue(By.id("CreditCardType"), "visa");

        //Cardholder Name
        sendTextToElement(By.id("CardholderName"), "Amy Smith");

        //Card Number
        sendTextToElement(By.id("CardNumber"), "4263982640269299");

        //Expire date
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "04");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2023");

        sendTextToElement(By.id("CardCode"), "738");

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //click on Confirm
        clickOnElement(By.xpath("//button[text()='Confirm']"));

        //Verify the Text “Thank You”
        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //Verify the message “Your order has been successfully processed!”
        assertVerifyText(By.xpath("//strong[text()='Your order has been successfully processed!']"), "Your order has been successfully processed!");

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        //Verify the text “Welcome to our store”
        assertVerifyText(By.xpath("//h2[text()='Welcome to our store']"), "Welcome to our store");


    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}











