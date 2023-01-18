package can_Hoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class day_15 extends TestBase {
    //https://www.way2automation.com/angularjs-protractor/webtables/
//tüm E-mail leri yazdırın
//Tüm E-maillerin "@" işareti içerdiğini doğrulayin

    @Test
    public void test(){

        //https://www.way2automation.com/angularjs-protractor/webtables/
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");

        //tüm E-mail leri yazdırın
        List<WebElement>mailler= driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody//tr//td[7]"));
        mailler.forEach(veri-> System.out.println(veri.getText()));

        //Tüm E-maillerin "@" işareti içerdiğini doğrulayin
        for (WebElement w: mailler) {
            Assert.assertTrue(w.getText().contains("@"));

        }




    }
}
