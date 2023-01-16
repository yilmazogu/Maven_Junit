package day13;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    /*
    StateElementReferenceException
    StateElementReferenceException = eski kullanılamaz durumda olan, kullanıma artık elverişli olmayan durumlarda alınan hatadır.
    Sayfayı yenilediğimizde,
    sayfada ileri geri gittiğimizde meydana gelen exception'dır.

    Çözüm
    Elemanı tekrar bulmak.

 */
    @Test
    public void staleElementReferenceExceptionTest1(){
        driver.get("https://www.techproeducation.com");
        waitFor(5);
//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        lmsLoginLink.click();//LMS e git
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URl in lms kelimesini icerdigini test et
        waitFor(5);
//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
        driver.navigate().back();//tekrar ana sayfaya gittik
        waitFor(5);
        lmsLoginLink.click();//LMS e git. org.openqa.selenium.StaleElementReferenceException:

        //EXCEPTION ALMADIGIM İÇİN 2. KEZ YAZDIM VE BU SEFER HATA ALDIM. !!!
        driver.navigate().back();
        waitFor(5);
        lmsLoginLink.click();
        /*
        lmsLoginLink linkini sayfa yenilendikden(back()) sonra kullandigim icin StaleElementReferenceException aldim
         */
    }

    @Test
    public void staleElementReferenceExceptionTest2(){
        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        lmsLoginLink.click(); //SAYFAYI YRNİLENMEDEN ÖNCE BULDUGUM ELEMENTİ SAYFAYI YENİLEDİKTEN SONRA KULLANMAK İSTEDİM.

    }



}