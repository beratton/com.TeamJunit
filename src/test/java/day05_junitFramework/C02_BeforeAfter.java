package day05_junitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    // 3 farkli test methodu olusturun. Her bir metodun basinda driver'i olusturup
    //1- amazon.com
    //2- wisequarter.com
    //3- youtube.com'a gidip
    // title 'lari yazdirin ve metoddan sonra driver i kapatin.

    WebDriver driver;
   @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       System.out.println("Setup metodu calisti");
    }

    @After
    public void tearDown(){
       driver.close();
        System.out.println("TearDOwn metodu calisti.");
    }

    @Test
    public void test01(){
       driver.get("https://amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test02(){
        driver.get("https://wisequarter.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test03(){
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());
    }


}
