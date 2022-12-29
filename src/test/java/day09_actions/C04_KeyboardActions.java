package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_KeyboardActions extends TestBase {
    @Test
    public void test01(){
     //   1- Bir Class olusturalim KeyboardActions1
     //   2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
     //   3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve
        //   Enter’a basarak arama yaptirin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        Actions action= new Actions(driver);
        ReusableMethods.bekle(2);
        action
                .click(aramaKutusu)
                .keyDown(Keys.SHIFT)// basili tutmak demek
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER).perform();

        ReusableMethods.bekle(5);

        //   4- aramanin gerceklestigini test edin

WebElement sonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

String expectedKelime="Samsung A71";
String actualKelime=sonucYaziElementi.getText();

        Assert.assertTrue(actualKelime.contains(expectedKelime));



    }
}
