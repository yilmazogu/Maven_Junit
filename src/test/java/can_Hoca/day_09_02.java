package can_Hoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.Set;

public class day_09_02 extends TestBase {
    /*
       url'ye git: http://demo.guru99.com/popup.php
       ilk pencereyi al
       "Click Here" butonuna tıklayın
       setteki tüm pencereyi al
       diğer pencereye geç
       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
       Gönder düğmesine tıklayarak
       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
       Tekrar ilk pencereye geç
       İlk pencerede olduğunu doğrula
      */
    @Test
    public void windowHandleTest(){
        //url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

        //ilk pencereyi al
        String ilkPencere=driver.getWindowHandle();

        //Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//*[@style='text-align:center']")).click();

        //setteki tüm pencereyi al
        Set<String> id= driver.getWindowHandles();

        //diğer pencereye geç
        for (String w: id) {
            if(!w.equalsIgnoreCase(ilkPencere)){
                driver.switchTo().window(w);
                break;
            }

        }

        //e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        //Gönder düğmesine tıklayarak
        driver.findElement(By.xpath("//*[@name='emailid']")).sendKeys("somepne@gmail.com", Keys.ENTER);

        //""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String sonucYazisi= driver.findElement(By.xpath("//*[text()='This access is valid only for 20 days.']")).getText();
        Assert.assertEquals("This access is valid only for 20 days.", sonucYazisi);

        //Tekrar ilk pencereye geç
        driver.switchTo().window(ilkPencere);

        //İlk pencerede olduğunu doğrula
        String yeniIlkPencere=driver.getWindowHandle();
        Assert.assertEquals(ilkPencere,yeniIlkPencere);












    }
}
