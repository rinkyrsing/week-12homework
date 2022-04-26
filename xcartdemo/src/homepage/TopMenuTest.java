package homepage;

import browserfactory.Utility;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
        //Click on the “Shipping” link
        clickOnElement(By.linkText("Shipping"));

        // Verify the text “Shipping”
        assertVerifyText(By.id("page-title"),"Shipping");
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() {
        //Click on the “New!” link
        clickOnElement(By.linkText("New!"));

        //Verify the text “New arrivals”
        assertVerifyText(By.id("page-title"),"New arrivals");
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() {
        // Click on the “Coming soon”link
        clickOnElement(By.linkText("Coming soon"));

        // Verify the text “Coming soon”
        assertVerifyText(By.id("page-title"),"Coming soon");
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() {
        // Click on the “Contact us”link
        clickOnElement(By.linkText("Contact us"));

        // Verify the text “Contact us”
        assertVerifyText(By.id("page-title"),"Contact us");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }



}
