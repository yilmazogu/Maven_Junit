package burak_p;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_self {

    static WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3);

    }

    // ...Exercise 1...
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin

    @Test
    public void test02(){

        driver.get("https://amazon.com");
        WebElement book= driver.findElement(By.xpath("//*[@aria-describedby='searchDropdownDescription']"));
        Select menu=new Select(book);
        menu.selectByVisibleText("Books");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);
        List<WebElement> javaListesi= driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement w: javaListesi) {

            Assert.assertTrue(w.getText().toUpperCase().contains("JAVA"));

        }




    }

}
