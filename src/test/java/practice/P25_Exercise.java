package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P25_Exercise extends TestBase {

    @Test
    public void test01(){

        // ...Exercise 1...
        // https://html.com/tags/iframe sayfasına gidiniz.
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz.
        WebElement videoIframe = driver.findElement(By.xpath("//*[@class='render']/iframe"));
        driver.switchTo().frame(videoIframe);
        WebElement playBox = driver.findElement(By.cssSelector("button[aria-label='Oynat']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(playBox).perform();
        playBox.click();

        // Videoyu izlemek icin Play tusuna basiniz
        // Videoyu calistirdiginizi test ediniz
        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

    }
}