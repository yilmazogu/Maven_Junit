package practice03_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P06_Self extends TestBase {

    // https://the-internet.herokuapp.com/iframe adresine gidiniz
    // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
    // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
    // Elemental Selenium linkine tıklayın
    // Açılan sayfada sayfa başlığını yazdırınız
    // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
    // Source labs linkine tıklayın
    // Açılan sayfada sayfa başlığını yazdırınız
    // ilk sekmeye geri dönelim ve url'ini yazdıralım
    // ilk sekmeyi kapatalım

    @Test
    public void Test(){

        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkWindow=driver.getWindowHandle();

        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe=driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));

        driver.switchTo().frame(iframe);

        WebElement textBox=driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Techproeducation");

        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        WebElement selenyum=driver.findElement(By.xpath("//*[.='Elemental Selenium']"));

        Assert.assertTrue(selenyum.isDisplayed());

        //Elemental Selenium linkine tıklayın
        selenyum.click();

        // Açılan sayfada sayfa başlığını yazdırınız
        List<String> sayfalarId= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(sayfalarId.get(1));
        System.out.println("driver.getTitle() = " + driver.getTitle());

        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement sauceLabs=driver.findElement(By.xpath("//*[.='Sauce Labs']"));
        Assert.assertTrue(sauceLabs.isDisplayed());

        // Source labs linkine tıklayın
        sauceLabs.click();

        // Açılan sayfada sayfa başlığını yazdırınız
        List<String> sayfalarId_2= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(sayfalarId_2.get(2));
        System.out.println("driver.getTitle() = " + driver.getTitle());

        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(sayfalarId_2.get(0));
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        // ilk sekmeyi kapatalım
        driver.close();




    }
}
