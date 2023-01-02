package homeWork_ahmet;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Window_handle extends TestBase {

    /*
    https://testcenter.techproeducation.com/index.php?page=multiple-windows
    Title'in "Windows" oldugunu test edin
    Click here a tiklayin
    Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin

     */
    @Test
    public void windovHandleTest(){

        //url'ye git: http://demo.guru99.com/popup.php
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        //Title'in "Windows" oldugunu test edin
        String baslik=driver.getTitle();
        Assert.assertTrue(baslik.equalsIgnoreCase("Windows"));
        String window1handle=driver.getWindowHandle();

        //Click here a tiklayin
        driver.findElement(By.xpath("//*[@target='_blank']")).click();

        //Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin
        Set<String> allWindowHandles = driver.getWindowHandles();  //bütün pencerelerin id sini aldık
        System.out.println(allWindowHandles);

        for (String w: allWindowHandles) {
            if(!w.equalsIgnoreCase(window1handle)){
                driver.switchTo().window(w);
                break;
            }

        }

        //Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin

        String yeniBaslik=driver.getTitle();
        Assert.assertEquals("New Window", yeniBaslik);








    }
}
