package can_Hoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class day_09 {

    static  WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }






// uygula butonuna tıklayın
    @Test
    public void test(){

        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> animal= driver.findElements(By.xpath("//*[@class='mdl-tabs__panel is-active']//img"));
        animal.stream().forEach(t->t.click());

        // ana iframe'e geri dön
        driver.switchTo().defaultContent();

        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.id("text")).sendKeys("nikelaj", Keys.TAB,"ambalaj", Keys.TAB,"patinaj",
                Keys.TAB,"arbitraj", Keys.TAB,"sabotaj", Keys.TAB,"kabotaj", Keys.TAB, "Ayaş", Keys.TAB, "Yağmurdede" ,
                Keys.TAB, "Angara", Keys.TAB, "dastarli", Keys.TAB, "dolmuscu", Keys.TAB, Keys.ENTER);



    }

}
