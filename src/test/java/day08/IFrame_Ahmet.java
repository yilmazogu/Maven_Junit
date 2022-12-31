package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class IFrame_Ahmet {


        static WebDriver driver;

        @Before
        public void setup() {

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }

    /*

        Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
        Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
    */
        @Test
        public void test(){
                //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
                driver.get("https://the-internet.herokuapp.com/iframe");

                //sayfadaki toplam iframe sayısını bulunuz.
                List<WebElement> iframeSayisi=driver.findElements(By.tagName("iframe"));
                System.out.println("iframeSayisi.size() = " + iframeSayisi.size());

                //Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
                String sayfaBasligi=driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
                Assert.assertTrue(sayfaBasligi.contains("Editor"));

                //Paragrafdaki yaziyi silelim
                driver.switchTo().frame(0);
                driver.findElement(By.xpath("//*[.='Your content goes here.']//p")).clear();

                //Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
                driver.findElement(By.xpath("//p")).sendKeys("iframe'in içindeyim");

                //Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
                driver.switchTo().parentFrame();
                String actualResult=driver.findElement(By.xpath("(//div[@id='page-footer'][1])//a")).getText();
                Assert.assertTrue(actualResult.contains("Elemental Selenium"));




        }

}
