package homepage;

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
    public void Setup(){
      openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        if (menu == "Computers") {
            //find computer tab and click
            clickOnElement(By.linkText("Computers"));
            //get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ", "nopCommerce demo store. Computers", title);
        }else  if (menu == "Electronics") {
            //find computer tab and click
            clickOnElement(By.linkText("Electronics"));
            //get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ", "nopCommerce demo store. Electronics", title);

        }else if(menu == "Apparel"){
            clickOnElement(By.linkText("Apparel"));
            //get Title
            String title = driver.getTitle();
            Assert.assertEquals("title not matched: ", "nopCommerce demo store. Apparel", title);

        }else if(menu == "Books"){
            clickOnElement(By.linkText("Books"));
            //get Title
            String title = driver.getTitle();
            Assert.assertEquals("title not matched: ", "nopCommerce demo store. Books", title);

        }else if(menu == "Jewelry"){
            clickOnElement(By.linkText("Jewelry"));
            //get Title
            String title = driver.getTitle();
            Assert.assertEquals("title not matched: ", "nopCommerce demo store. Jewelry", title);

        }else if(menu == "Gift Cards"){
            clickOnElement(By.linkText("Gift Cards"));
            //get Title
            String title = driver.getTitle();
            Assert.assertEquals("title not matched: ", "nopCommerce demo store. Gift Cards", title);

        }
    }
    @Test
    public void verifyPageNavigation(){
        selectMenu("Computers");
        selectMenu("Electronics");
        selectMenu("Apparel");
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
