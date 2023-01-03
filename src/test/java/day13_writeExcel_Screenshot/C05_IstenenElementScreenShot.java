package day13_writeExcel_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;

public class C05_IstenenElementScreenShot extends TestBase {
    @Test
    public void test(){
        driver.get("https://amazon.com.tr");

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
// Sonuclarin nutella icerdigini test edin
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";

        String actualAramaSonucu= aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

        // arama sonucu elementinin ekran goruntusunu alin.

        ReusableMethods.elementSSCek(aramaSonucElementi);




    }
}
