package can_Hoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class day_10 extends TestBase {



    @Test
    public void windowHandleTest(){

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        String ilkSayfa=driver.getWindowHandle();

        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("//*[text()='Alerts, Frame & Windows']")).click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        String text=driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']")).getText();
        Assert.assertEquals("Please select an item from left to start practice.",text);
        //2. yol String text=driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']")).isDisplayed()

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        driver.findElement(By.xpath("//*[@id='tabButton']")).isDisplayed();

        //New Tab butonuna click yap
        driver.findElement(By.xpath("//*[@id='tabButton']")).click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        Set<String> sekmeler= driver.getWindowHandles();
        for (String w: sekmeler) {

            if(!w.equalsIgnoreCase(ilkSayfa));
            driver.switchTo().window(w);

        }

        driver.findElement(By.xpath("//*[text()='This is a sample page']")).isDisplayed();

        //İlk Tab'a geri dön
        driver.switchTo().window(ilkSayfa);

        //New Tab butonunun görünür olduğunu doğrula
        driver.findElement(By.xpath("//*[@id='tabButton']")).isDisplayed();

















    }
}
