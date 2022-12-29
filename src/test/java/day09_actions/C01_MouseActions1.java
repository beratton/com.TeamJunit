package day09_actions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C01_MouseActions1 extends TestBase {
    @Test
    public void test01() {

// 1- Yeni bir class olusturalim: MouseActions1
// 2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        ReusableMethods.bekle(3);
//             3- Cizili alan uzerinde sag click yapin
        Actions actions= new Actions(driver);
                WebElement ciziliAlanElementi= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        ReusableMethods.bekle(3);
                actions.contextClick(ciziliAlanElementi).perform();
// 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedAlertYazisi= "You selected a context menu" ;
        String actualAlertYazisi= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
// 5- Tamam diyerek alert’i kapatalim
        ReusableMethods.bekle(2);
        driver.switchTo().alert().accept();
// 6- Elemental Selenium linkine tiklayalim
        String ilksayfaWHD= driver.getWindowHandle();
        ReusableMethods.bekle(3);
        driver.findElement(By.linkText("Elemental Selenium")).click();

        System.out.println("ilk sayfanin WHD si:" + ilksayfaWHD);
// 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Set<String> ikisayfaninWHDSeti= driver.getWindowHandles();

        String ikincisayfaWHD="";
        for (String eachWHD: ikisayfaninWHDSeti
             ) { if(!eachWHD.equals(ilksayfaWHD)){
                 ikincisayfaWHD=eachWHD;
        }

        }
driver.switchTo().window(ikincisayfaWHD);
        String expectedYenisayfaYazi= "Elemental Selenium";
        String actualYeniSayfaYazi= driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYenisayfaYazi,actualYeniSayfaYazi);
        ReusableMethods.bekle(3);

    }
}
