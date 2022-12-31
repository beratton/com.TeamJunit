package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

public class Q2 extends TestBase {
    //              ..Exercise2...
//  http://www.bestbuy.com 'a gidin,
//  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
//  Ayrica Relative Locator kullanarak;
//      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
//  Ayrica Relative Locator kullanarak;
//      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin

@Before
public void beforeTest(){
    driver.get("http://www.bestbuy.com");
}

    @Test
    public void titleTest(){
String expectedTitle="Best";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test
    public void logoTest() {
        // Ayrica Relative Locator kullanarak
        // logoTest=> BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin.
        WebElement helloHeading=driver.findElement(By.xpath(("//div[@class='heading'])[1]")));
        WebElement bestBuyLogo = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
    Assert.assertTrue(bestBuyLogo.isDisplayed());
    }
        @Test
        public void mexicoLinkTest(){
WebElement usFlag= driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
WebElement mexicoFlag= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usFlag));
/* 2. yontem
boolean Goruntuleniyormu=mexicoFlag.isDisplayed();
Assert.assertTrue(Goruntuleniyormu);
*/
        }

}
