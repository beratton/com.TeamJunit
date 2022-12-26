package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    /*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin
     */


    static WebDriver driver;

  //  BeforeClass ile driver'i olusturun ve class icinde static yapin
  //  Maximize edin ve 10 sn bekletin

    @BeforeClass
public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    //@BeforeClass ve AfterClass seklinde olusturdugumuz methodlari static olarak tanimlariz.

    @AfterClass
    public static void teardown(){
       // driver.close();
    }

    //  http://www.google.com adresine gidin
@Before  // Her testten once calisir.
public void beforeTest(){
    driver.get("http://www.google.com");
}


    //  arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
@Test
    public void test01(){
        driver.get("http://www.google.com");
driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("The Lord of the Rings"+ Keys.ENTER);
    WebElement sonuc1= driver.findElement(By.id("result-stats"));
    System.out.println(sonuc1.getText());

    }
    //  arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test02(){
        driver.findElement(By.xpath("//input[@class='gLFyf']")).clear();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Brave Heart"+ Keys.ENTER);
        WebElement sonuc2= driver.findElement(By.id("result-stats"));
        System.out.println(sonuc2.getText());

    }
    // arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test03(){
        driver.findElement(By.xpath("//input[@class='gLFyf']")).clear();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Harry Potter"+ Keys.ENTER);
        WebElement sonuc3= driver.findElement(By.id("result-stats"));
        System.out.println(sonuc3.getText());

    }

   // AfterClass ile kapatin
}
