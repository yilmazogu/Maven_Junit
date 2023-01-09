package can_Hoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class day_12_HoverOver extends TestBase {

    @Test
    public void hoverOver(){


        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");


        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement birinciHover=driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(birinciHover).perform();
        waitFor(2);

        //3. "Link 1" e tiklayin
        WebElement Link1=driver.findElement(By.xpath("(//*[.='Link 1'])[1]"));
        Link1.click();

        //4. Popup mesajini yazdirin
        String alertMesaj=driver.switchTo().alert().getText();
        System.out.println("alertMesaj = " + alertMesaj);

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickANDHold=driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickANDHold).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("clickANDHold = " + clickANDHold.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClick=driver.findElement(By.xpath("//*[.='Double Click Me!']"));
        String firstColor = doubleClick.getCssValue("background-color");
        actions.doubleClick(doubleClick).perform();

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        String lastColor = doubleClick.getCssValue("background-color");

        Assert.assertNotEquals(firstColor,lastColor);






    }


}
