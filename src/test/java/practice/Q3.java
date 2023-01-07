package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Q3 extends TestBase {

 /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
     */

    @Test
    public void test01(){
        driver.get("http://automationexercise.com");
        WebElement homeSayfaTesti = driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));

        boolean baslikGorundumu= homeSayfaTesti.isDisplayed();
        Assert.assertTrue(baslikGorundumu);

        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

        String expContactUsPageBaslik="GET IN TOUCH";

        WebElement actContactUsPageBaslik=driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
        Assert.assertTrue(actContactUsPageBaslik.isDisplayed());

       WebElement firstNameTextBox= driver.findElement(By.xpath("//input[@name='name']"));

        Actions action= new Actions(driver);

        action.
                click(firstNameTextBox).
                sendKeys("Bulent").
                sendKeys(Keys.TAB).
                sendKeys("bulent@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("Otomasyon").
                sendKeys(Keys.TAB).
                sendKeys("Hello New Year").perform();

        //7. Upload file
        ReusableMethods.bekle(5);
firstNameTextBox.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.bekle(5);
        WebElement ChooseFileButonu= driver.findElement(By.xpath("//input[@ name='upload_file']"));

        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\New Text Document.txt";
                ChooseFileButonu.sendKeys(dosyaYolu);
driver.findElement(By.xpath("//input[@value='Submit']")).click();

        driver.switchTo().alert().accept();
        WebElement successMesaji= driver.findElement(By.xpath("//a[@ class='btn btn-success']"));
                Assert.assertTrue(successMesaji.isDisplayed());

                driver.findElement(By.xpath("(//a[text()=' Home'])[1]")).click();

                Assert.assertTrue(baslikGorundumu);

    }
}
