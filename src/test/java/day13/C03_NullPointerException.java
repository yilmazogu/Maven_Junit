package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

    /*
    Obje oluşturmadıgımız için "nullPointerException" alıyoruz.
     dekler ettin ama deger atamadıgımızda bu exceptıon u alıyoruz.


     */

public class C03_NullPointerException {

    WebDriver driver;
    Faker faker;
    @Test
    public void nullPointerExceptionTest(){

        driver.get("https://www.techproeducatıon.com"); //java.lang.NullPointerException


    }

    @Test
    public void nullPointerExceptionTest2(){
        System.out.println(faker.name().firstName());

    }

}