package day07_dropdown_JsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void iframeTest() throws InterruptedException {

        //   1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //   2 ) Bir metod olusturun: iframeTest
                //           - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement actualSayfaYazisiElementi= driver.findElement(By.tagName("h3"));

        Assert.assertTrue(actualSayfaYazisiElementi.isEnabled());
        Thread.sleep(3000);
        //   - Text Box’a “Merhaba Dunya!” yazin.

        //Locator'i dogru yazdigimiz halde web elementi bulunamiyorsa O zaman bir Iframe yani ic ice sayfa
        //soz konusu olabilir. Oncelikle bu Iframe'e gecis yapmamiz gerekir. switchTo() kullanilir.
        // Normal locate yapip yazdirmayi denedigimizde NoSuchElementException verdi.
        WebElement iframeWebElementi= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeWebElementi);
        WebElement yazikutuElementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
        yazikutuElementi.clear();
        yazikutuElementi.sendKeys("Merhaba Dunya");
        Thread.sleep(3000);
        //           - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve
        //   konsolda yazdirin.

        // Iframe' in icine girdikten sonra, ordan cik diye komut verene kadar
        // driver ifram in icinde kalir.
        // eger disina cikmak istersek
        driver.switchTo().parentFrame(); // bulundugu ifram den bir ust html sayfasina gecer.
        // genelde ic ice iframe ler oldugunda tercih edilir.

        driver.switchTo().defaultContent();// anasayfaya gecis yapar

        WebElement elementalSeleniumLinkElementi= driver.findElement(By.xpath("//div[text()='Powered by ']"));
        Assert.assertTrue(elementalSeleniumLinkElementi.isDisplayed());
        System.out.println(elementalSeleniumLinkElementi.getText());
    }
}
