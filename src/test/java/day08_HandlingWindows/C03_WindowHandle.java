package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandle {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
    // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
// elemental selenium linkini tiklayin
        // Linke taklayinca yeni sayfa acilacagi icin
        // click yapmadan once ilk sayfanin WHD sini kaydedelim.
        String ilksayfaWHD= driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
// yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        // click yapinca yeni tab acilir ancak driver eski tab da kalir.
        // yeni tab'a driver'i gecirmek icin yeni tab'in WHD sine ihtiyacimiz var.

        Set<String> ikisayfaninWHDegerleriSeti= driver.getWindowHandles();
        String ikincisayfaWHD="";

        for (String eachWHD: ikisayfaninWHDegerleriSeti
             ) {
            if (!eachWHD.equals(ilksayfaWHD)){
                ikincisayfaWHD=eachWHD;
            }
        }

        //for each loop bitince ikinci sayfanin whd'sini elde etmis olacagiz.
    // bu degeri kullanarak driver'i 2.sayfaya gecirebiliriz.
        driver.switchTo().window(ikincisayfaWHD);
// yeni tab'a gecip 2.sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edelim.

        String expectedIkincisayfaYazi="Elemental Selenium";
        String actualIkincisayfaYazi= driver.findElement(By.tagName("h1")).getText();
// ilk sayfaya geri donup sayfadaki yazinin
// "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin

        driver.switchTo().window(ilksayfaWHD);

        String expectedilkSayfaYazi="An iFrame containing the TinyMCE WYSIWYG Editor";
       // String actualIlkSayfaYazi=driver.findElement(By.tagName(""));

}}
