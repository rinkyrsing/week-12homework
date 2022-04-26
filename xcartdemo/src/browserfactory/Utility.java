package browserfactory;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    //This method will click on element
    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    //This method will get text from element
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    //This method will send text on element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //Verify the expected result
    public void assertVerifyText(By by, String expectedText){
        String actualResult = getTextFromElement(by);
        String expectedResult = expectedText;

        Assert.assertEquals("Error > test failed: " , expectedResult, actualResult);
    }



    // ===================================Select Class Method==================================================
    // This method will select the option by visible text=== visible in Black colour
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    // In Blue colour
    public void selectByValue(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByIndex(By by, int num){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(num);
    }
    //=========================MouseHoverOnElement================================
//Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
    public void clickMouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).click().build().perform();
    }
    public void mouseHover(By by){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).build().perform();
    }
   // ================================Alert Message==================================
    public void alertMessage(){
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        alert.accept();

    }
}
