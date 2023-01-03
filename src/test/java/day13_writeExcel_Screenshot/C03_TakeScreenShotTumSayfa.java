package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TakeScreenShotTumSayfa extends TestBase {
    @Test
    public  void test01() throws IOException {
        //amazon.com.tr'a gidip
        driver.get("https://amazon.com.tr");
        // Nutella aratıp
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // arama sonuclarının Nutella içerdiğini test edin

        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";

        String actualAramaSonucu= aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

        ReusableMethods.bekle(3);
        //-----Tum sayfanın screenshot'ını alın-----

        //1- Takescreenshot objesi olusturun
        TakesScreenshot tss=(TakesScreenshot) driver;
        // 2- Resmi son olarak kaydedecegimiz dosyayi olusturun
        File tumSayfaScreenShot= new File("target/ekranResimleri/tumEkranSS.jpeg");
        // 3- Tss objesi kullanarak ekran goruntusu alip gecici dosyaya kaydet
        File geciciDosya= tss.getScreenshotAs(OutputType.FILE);
        //4- Gecici dosyayi ana dosyaya kopyala
        FileUtils.copyFile(geciciDosya,tumSayfaScreenShot);

        ReusableMethods.bekle(3);
   ReusableMethods.tumSayfaScreenShotCek(driver);

    }
}
