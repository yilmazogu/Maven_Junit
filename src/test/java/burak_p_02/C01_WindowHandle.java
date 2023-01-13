package burak_p_02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_WindowHandle extends TestBase {
    @Test
    public void test(){


        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
        String ilksayfa=driver.getWindowHandle();

        // 2- nutella icin arama yapın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella" + Keys.ENTER);

        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella" + Keys.ENTER);


        // 4- yeni tab'da acilan urunun basligini yazdirin
        String baslik=driver.findElement(By.xpath("//*[.='" +
                        "Nutella Hazelnut Spread with Cocoa for Breakfast, Great for Holiday Baking, 13 oz Jar']")).getText();
        System.out.println("baslik = " + baslik);


        // 5- ilk sayfaya gecip url'i yazdırın
        driver.switchTo().window(ilksayfa);
    }
}
