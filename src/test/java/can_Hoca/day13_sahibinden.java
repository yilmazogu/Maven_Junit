package can_Hoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;


public class day13_sahibinden extends TestBase {

    @Test
    public void test01(){

        //sahibinden.com a gidin.
        driver.get("https://www.sahibinden.com");
        driver.findElement(By.xpath("//*[text()='Tüm Çerezleri Kabul Et']")).click();

        //anasayfada oldugunuzu dogrulayin.
        Assert.assertTrue(driver.getTitle().contains("Sahibinden"));

        //detayli arama tiklayin.
        driver.findElement(By.xpath("//*[@title='Detaylı Arama']")).click();

        //detayli arama sayfasina geldiginizi dogrulatin.
        Assert.assertTrue(driver.getTitle().contains("Detaylı Arama"));

        //emlak-konut-satilik seceneklerini secip.
        driver.findElement(By.xpath("//*[text()='Emlak']")).click();
        driver.findElement(By.xpath("//*[text()='Konut']")).click();
        driver.findElement(By.xpath("//*[text()='Satılık']")).click();
        driver.findElement(By.xpath("//*[text()='Daire']")).click();


        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        //filtreler için sağıdakilere benzer methodlar oluşturun.
            /*
            detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
            detayli_Arama_Fiyat("4.000","4.000.000","USD");
            detayli_Arama_Brut("180","400");
            detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi

             */

        filtre("Ankara","Yenimahlle", "Emniyet Mah.", "500000", "1000000", "TL", "100", "150");

        //cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin


    }

    public void filtre (String il, String ilce, String Mah, String minFiyat, String maxFiyat, String paraTuru, String MinMetreKare, String MaxMetreKare){

        WebElement ilElement = driver.findElement(By.xpath("//*[@title='İl']"));
        Select select1 = new Select(ilElement);
        select1.selectByVisibleText(il);

        WebElement ilceElement = driver.findElement(By.xpath("//*[@class='faceted-select passive']"));
        Select select2 = new Select(ilceElement);
        select2.selectByVisibleText(ilce);

        WebElement mahElement = driver.findElement(By.xpath("//*[@class='faceted-select passive']"));
        Select select3 = new Select(mahElement);
        select3.selectByVisibleText(Mah);


        driver.findElement(By.xpath("//*[@class='collapse-pane']")).click();
        mahElement.sendKeys(Keys.TAB, minFiyat, Keys.TAB, maxFiyat, Keys.TAB );
        WebElement paraTuruDropDownMenu = driver.findElement(By.xpath("//*[@class='pricecurrSelect selectedOption']"));
        Select select4 = new Select(paraTuruDropDownMenu);
        select4.selectByVisibleText(paraTuru);

        paraTuruDropDownMenu.sendKeys(Keys.TAB,MinMetreKare, Keys.TAB, MaxMetreKare );

    }





}