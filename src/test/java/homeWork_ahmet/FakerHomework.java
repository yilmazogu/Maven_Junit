package homeWork_ahmet;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class FakerHomework extends TestBase {

    @Test
    public void fakerClass(){
         /*

             Faker Kutuphanesi HOMEWORK

        Faker class'i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
        degerler uretmemize imkan tanir.
        Faker degerler uretmek icin Faker class'indan bir obje uretir ve var olan method'lari kullaniriz.

         */


        //"https://facebook.com"  Adresine gidin.
        driver.get("https://facebook.com");

        //"create new account"  butonuna basin.
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();

        Faker faker= new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String sifre = faker.internet().password(6,10);



        //"firstName" giris kutusuna bir isim yazin.
        //"surname" giris kutusuna bir soyisim yazin.
        //"email" giris kutusuna bir email yazin.
        //"email" onay kutusuna emaili tekrar yazin.
        //Bir sifre girin.
        //Bir sifre girin.
        WebElement isim = driver.findElement(By.xpath("//*[@name='firstname']"));
        isim.sendKeys(firstName);
        isim.sendKeys(Keys.TAB,lastName,Keys.TAB, email, Keys.TAB, sifre);

        //Tarih icin gun secin
        WebElement Day = driver.findElement(By.xpath("//*[@title='Gün']"));
        Select gun = new Select(Day);
        gun.selectByVisibleText("2");

        //Tarih icin ay secin
        WebElement month = driver.findElement(By.id("month"));
        Select ay = new Select(month);
        ay.selectByVisibleText("Oca");

        //Tarih icin yil secin
        WebElement year = driver.findElement(By.xpath("//*[@title='Yıl']"));
        Select yıl = new Select(year);
        yıl.selectByVisibleText("1989");

        //Cinsiyeti secin.
        WebElement cinsiyet1 = driver.findElement(By.xpath("(//*[@name='sex'])[1]"));
        cinsiyet1.click();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement cinsiyet2 = driver.findElement(By.xpath("(//*[@name='sex'])[2]"));
        cinsiyet1.click();
        WebElement cinsiyet3 = driver.findElement(By.xpath("(//*[@name='sex'])[3]"));
        cinsiyet1.click();

        Assert.assertTrue(cinsiyet1.isSelected());
        Assert.assertFalse(cinsiyet2.isSelected());
        Assert.assertFalse(cinsiyet3.isSelected());
        //Sayfayi kapatin
    }


}
