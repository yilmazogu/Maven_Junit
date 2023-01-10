package homeWork_ahmet;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Keybord_actions_2 extends TestBase {

    @Test

    //Bir Class olusturalim KeyboardActions2
    public void keysAciton(){




        //videoyu calistirdiginizi test edin


        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //videoyu izlemek icin Play tusuna basin
        WebElement iframe=driver.findElement(By.xpath("//*[@class='render']/iframe"));
        driver.switchTo().frame(iframe);
        WebElement video_oncesi= driver.findElement(By.cssSelector("button[aria-label='Oynat']"));
        String video_oncesi_deger=video_oncesi.getAttribute("class");
        video_oncesi.click();

        //videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.cssSelector("button[data-title-no-tooltip='Duraklat']")).isDisplayed());









    }
}
