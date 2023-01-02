package can_Hoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class can_assertion_01 {

     WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }





    @Test

    public void Test01(){

        //Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");

        //Then new butonuna basar
        driver.findElement(By.xpath("//span[.='New']")).click();

        //And editor firstname kutusuna "<firstName>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_first_name']")).sendKeys("Oguzhan");

        //And editor lastname kutusuna "<lastName>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_last_name']")).sendKeys("Yilmaz");

        //And editor position kutusuna "<position>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_position']")).sendKeys("Kaltie Guvence Muhendisi");

        //And editor office kutusuna "<office>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_office']")).sendKeys("Kalite Mudurlugu");

        //And editor extension kutusuna "<extension>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_extn']")).sendKeys("Guvence");

        //And editor startdate kutusuna "<startDate>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_start_date']")).sendKeys("2022-12-26");

        //And editor salary kutusuna "<salary>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_salary']")).sendKeys("10000");

        //When Create tusuna basar
        driver.findElement(By.xpath("//*[@class='btn']")).click();

        //Then Kullanıcının eklendiğini doğrular.
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Oguzhan Yilmaz");
        WebElement actualName= driver.findElement(By.xpath("//*[@class='sorting_1']"));
        Assert.assertEquals("Oguzhan Yilmaz",actualName.getText());
        System.out.println("Test Nikelaj");

        //And Eklediği kullanıcı kaydını siler
        actualName.click();
        driver.findElement(By.xpath("//*[@class='dt-button buttons-selected buttons-remove']")).click();
        driver.findElement(By.xpath("//*[@class='btn']")).click();

        //Then Kullanıcinin silindiğini doğrular.
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Oguzhan Yilmaz");
        WebElement actualName01=driver.findElement(By.xpath("//*[@valign='top']"));
        Assert.assertTrue(actualName01.getText().equalsIgnoreCase("No matching records found"));
        System.out.println("Test Ambalaj");


    }




}





/*




    And Eklediği kullanıcı kaydını siler
    Then Kullanıcinin silindiğini doğrular.
    */