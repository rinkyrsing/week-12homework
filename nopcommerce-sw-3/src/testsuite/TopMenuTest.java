package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //find computer tab and click on computer tab
        clickOnElement(By.linkText("Computers"));
        String expectedResult = "Computers";
        String actualResult = getTextFromElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
        Assert.assertEquals("invalid element", expectedResult, actualResult);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {

        clickOnElement(By.linkText("Electronics"));
        String expectedResult = "Electronics";
        String actualResult = getTextFromElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));

        Assert.assertEquals("Error occured", expectedResult, actualResult);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {

        clickOnElement(By.linkText("Apparel"));
        String expectedResult = "Apparel";
        String actualResult = getTextFromElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));

        Assert.assertEquals("Error occured", expectedResult, actualResult);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {

        clickOnElement(By.linkText("Digital downloads"));
        String expectedResult = "Digital downloads";
        String actualResult = getTextFromElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[4]/a"));
        Assert.assertEquals("Error occured", expectedResult, actualResult);

    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {

        clickOnElement(By.linkText("Books"));
        String expectedResult = "Books";
        String actualResult = getTextFromElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a"));

        Assert.assertEquals("Error occured", expectedResult, actualResult);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {

        clickOnElement(By.linkText("Jewelry"));
        String expectedResult = "Jewelry";
        String actualResult = getTextFromElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a"));

        Assert.assertEquals("Error occured", expectedResult, actualResult);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {

        clickOnElement(By.linkText("Gift Cards"));

        String expectedResult = "Gift Cards";
        String actualResult = getTextFromElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[7]/a"));
        Assert.assertEquals("Error occured", expectedResult, actualResult);
    }

    @After
    public void close(){
        closeBrowser();
    }
}
