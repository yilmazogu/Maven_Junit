package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P30_amazon extends TestBase {

    @Test
    public void testAmazon(){

//        Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");

//        Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın.
        WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownMenu);
        List<WebElement> dropDownMenuList = new ArrayList<>(select.getOptions());
        dropDownMenuList.stream().forEach(t-> System.out.println(t.getText()));

//        dropdown menude 28 eleman olduğunu doğrulayın.
        Assert.assertTrue(dropDownMenuList.size()==28);

//                Test02
//        dropdown menuden elektronik bölümü seçin.
        select.selectByVisibleText("Electronics");

//        arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın.
        WebElement searchBox = driver.findElement(By.id("searchDropdownBox"));
        searchBox.sendKeys("iphone", Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//*[text()='1-16 of 144 results for']"));
        String[] resultList = result.getText().split(" ");
        System.out.println("Sonuc = " + resultList[2]);

//        sonuc sayisi bildiren yazinin iphone icerdigini test edin.

//        ikinci ürüne relative locater kullanarak tıklayin
//        ürünün title'ni ve fiyatını variable'a  assign edip ürünü sepete ekleyelim
//        Test03
//        yeni bir sekme açarak amazon anasayfaya gidin
//        dropdown'dan bebek bölümüne secin
//        bebek puset aratıp bulundan sonuç sayısını yazdırın
//        sonuç yazsının puset içerdiğini test edin
//        5-üçüncü ürüne relative locater kullanarak tıklayin
//        6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
//        1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın.






    }
}