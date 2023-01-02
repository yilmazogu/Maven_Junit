package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public abstract class TestBase {
    //    driver objesini olustur. Driver ya public yada protected olmali. Sebepi child classlarda gorulebilir olmasi
    protected static WebDriver driver;
    //    setUp
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    //    tearDown
    @After
    public void tearDown(){
        //driver.quit();
    }


    //MULTIPLE WINDOW
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

/*(){
        //techproeducation ana sayfasına git ve title'ın "Bootcamps" icerdigini test edin.
        driver.get("https://www.techproeducation.com");

        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));

    }
            /*
            *Alertleri nasil automate edersin? How to handle alerts in selenium?
             -Alertler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir.
 */
}
