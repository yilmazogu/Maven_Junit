package homeWork_ahmet;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DropDown_Ahmet extends TestBase {

    @Test
    public void DropDown() {

        //amazon gidin
        driver.get("https://amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);

        List<WebElement> options = select.getOptions();
        System.out.println(options.size());
        for (WebElement liste : options) {
            System.out.println(liste.getText());
        }

        Assert.assertTrue(options.size() == 28);

    }
    @Test
    public void DropDown_2(){

        //amazon gidin
        driver.get("https://amazon.com");

        //dropdown menuden elektronik bölümü seçin
        WebElement dropdown_elektronik = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select1 = new Select(dropdown_elektronik);
        select1.selectByVisibleText("Electronics");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        dropdown_elektronik.sendKeys(Keys.TAB +"iphone" + Keys.ENTER);

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        String sonucSayisi=driver.findElement(By.xpath("//*[@class='sg-col-inner']")).getText();
        List<String> sonucListesi=new ArrayList<>(Arrays.asList(sonucSayisi.split(" ")));
        System.out.println("sonucListesi.get(3) = " + sonucListesi.get(3));
        System.out.println(sonucSayisi);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucSayisi.contains("iphone"));


        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun=driver.findElement(By.xpath("//*[@alt='Jephuwneh 2 Pack Gradient Tempered Glass for " +
                "iPhone 14 Pro Max Privacy Screen Protector for iPhone14 ProMax 6.7inch Anti S...']"));
        ikinciUrun.click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        WebElement urunIsmi=driver.findElement(By.xpath("//*[@id='title']"));
        String urunText=urunIsmi.getText();
        WebElement fiyat=driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']"));
        String fiyattext=fiyat.getText();
        System.out.println(urunText);
        System.out.println("fiyattext = " + fiyattext);
        WebElement sepete_ekleme=driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
        sepete_ekleme.click();









        driver.switchTo().newWindow(WindowType.TAB);
        switchToWindow(1);
        driver.get("https://www.amazon.com");

        //dropdown’dan bebek bölümüne secin
        WebElement dropdown_puset = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select2= new Select(dropdown_puset);
        select2.selectByVisibleText("Baby");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        dropdown_puset.sendKeys(Keys.TAB+"bebek puset", Keys.ENTER);
        WebElement baby_puset=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        List<String> baby_arama=new ArrayList<>(Arrays.asList(baby_puset.getText().split(" "))) ;
        System.out.println(baby_arama.get(2));

        //sonuç yazsının puset içerdiğini test edin
        String baby_text=baby_puset.getText();
        Assert.assertTrue(baby_text.contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement secenek_3=driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        secenek_3.click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        WebElement title_puset=driver.findElement(By.xpath("//*[@id='title']"));
        String title_puset_text=title_puset.getText();
        WebElement price_puset= driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']"));
        String price_puset_string=price_puset.getText();
        WebElement sepete_ekle=driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
        sepete_ekle.click();


        //sepete git
        driver.findElement(By.xpath("a-button-inner")).click();
        String control_puset=driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base sc-product-title sc-grid-item-product-title'])[1]")).getText();
        Assert.assertEquals(control_puset,urunText);


    }




        //







    }

