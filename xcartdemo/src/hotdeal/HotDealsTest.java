package hotdeal;

import browserfactory.Utility;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Mouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotDealsTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {

        // Mouse hover on the “Hot deals”link
        mouseHover(By.xpath("//div[@class='collapse navbar-collapse']/ul[1]/li[2]/span"));

        // Mouse hover on the “Sale”link and click
        clickMouseHoverOnElement(By.xpath("//*[@id='header-area']/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a"));

        // Verify the text “Sale”
        assertVerifyText(By.id("page-title"), "Sale");

        //Mouse hover on “Sort By”and select “Name A -Z”
        mouseHover(By.xpath("//span[@class='sort-by-value']"));
        clickMouseHoverOnElement(By.xpath("//ul[@id='XLite-Module-CDev-Sale-View-SalePage-sortby-1']/li[5]/a"));

        //Verify that the product arrange alphabetically
        assertVerifyText(By.xpath("//span[contains(text(),'Name A - Z')]"),"Name A - Z");
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {
        // Mouse hover on the “Hot deals”link
        mouseHover(By.xpath("//div[@class='collapse navbar-collapse']/ul[1]/li[2]/span"));

        // Mouse hover on the “Sale”link and click
        clickMouseHoverOnElement(By.xpath("//*[@id='header-area']/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a"));

        // Verify the text “Sale”
        assertVerifyText(By.id("page-title"), "Sale");

        // Mouse hover on “Sort By” and select “Price Low-High”
        mouseHover(By.xpath("//span[@class='sort-by-value']"));
        clickMouseHoverOnElement(By.linkText("Price Low - High"));

        // Verify that the product’s price arrange Low to High
        assertVerifyText(By.xpath("//span[contains(text(),'Price Low - High')]"),"Price Low - High");
    }


    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {

        // Mouse hover on the “Hot deals”link
        mouseHover(By.xpath("//div[@class='collapse navbar-collapse']/ul[1]/li[2]/span"));

        // Mouse hover on the “Sale”link and click
        clickMouseHoverOnElement(By.xpath("//*[@id='header-area']/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a"));

        // Verify the text “Sale”
        assertVerifyText(By.id("page-title"), "Sale");

        // Mouse hover on “Sort By” and select “Rates”
        mouseHover(By.xpath("//span[@class='sort-by-value']"));
        clickMouseHoverOnElement(By.linkText("Rates"));

        // Verify that the product’s arrange Rates
        assertVerifyText(By.xpath("//span[contains(text(),'Rates')]"),"Rates");

    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {

        // Mouse hover on the “Hot deals”link
        mouseHover(By.xpath("//div[@class='collapse navbar-collapse']/ul[1]/li[2]/span"));

        // Mouse hover on the “Bestsellers”link and click
        mouseHover(By.xpath("//*[@id='header-area']/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));
        clickMouseHoverOnElement(By.linkText("Bestsellers"));

        // Verify the text “Bestsellers”
        assertVerifyText(By.id("page-title"),"Bestsellers");

        // Mouse hover on “Sort By”and select “Name Z -A”
        mouseHover(By.xpath("//span[@class='sort-by-value']"));
        clickMouseHoverOnElement(By.linkText("Name Z - A"));
        List<WebElement> originalProductList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/h5/a"));
        //create the list object
        List<String> sortPriceList = new ArrayList();
        //add all web element value to list object
        for (WebElement element : originalProductList) {
            sortPriceList.add(element.getText());
        }
        Collections.sort(sortPriceList, Collections.reverseOrder());
        //sort by Z to A
        mouseHover(By.className("sort-by-label"));
        clickOnElement(By.partialLinkText("Name Z -"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/h5/a"));
        //create the list object
        List<String> actualPriceList = new ArrayList();
        //add all web element value to list object
        for (WebElement element : actualProductListElements) {
            actualPriceList.add(element.getText());
        }
        Assert.assertEquals(sortPriceList, actualPriceList);
    }
    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        // Mouse hover on the “Hot deals”link
        mouseHover(By.xpath("//div[@class='collapse navbar-collapse']/ul[1]/li[2]/span"));

        // Mouse hover on the “Bestsellers”link and click
        mouseHover(By.xpath("//*[@id='header-area']/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));
        clickMouseHoverOnElement(By.linkText("Bestsellers"));

        // Verify the text “Bestsellers”
        assertVerifyText(By.id("page-title"),"Bestsellers");

        // Mouse hover on “Sort By” and select “Price High-Low”
        mouseHover(By.xpath("//span[@class='sort-by-value']"));
        clickMouseHoverOnElement(By.linkText("Price High - Low"));

        //actual product list
        List<WebElement> originalProductList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> sortPriceList = new ArrayList();
        /*remove $ sign and add the sortPriceList
        //add all web element value to list object*/
        for (WebElement element : originalProductList) {
            sortPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        Collections.sort(sortPriceList, Collections.reverseOrder());
        //Mouse hover on “Sort By”
        mouseHover(By.xpath("//div[@class='sort-box']"));
        //select “Price: Low to High”
        clickOnElement(By.partialLinkText("Price High - L"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> actualPriceList = new ArrayList();
        /*remove $ sign and add the sortPriceList
        add all web element value to list object*/
        for (WebElement element : actualProductListElements) {
            actualPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        Assert.assertEquals(sortPriceList, actualPriceList);

    }
    @Test
    public void verifyBestSellersProductsArrangeByRates() {
        // Mouse hover on the “Hot deals”link
        mouseHover(By.xpath("//div[@class='collapse navbar-collapse']/ul[1]/li[2]/span"));

        // Mouse hover on the “Bestsellers”link and click
        mouseHover(By.xpath("//*[@id='header-area']/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));
        clickMouseHoverOnElement(By.linkText("Bestsellers"));

        // Verify the text “Bestsellers”
        assertVerifyText(By.id("page-title"),"Bestsellers");

        //Mouse hover on “Sort By” and select “Rates”
        mouseHover(By.xpath("//span[@class='sort-by-value']"));
        clickMouseHoverOnElement(By.linkText("Rates"));

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

    }


