package burak_p;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Drop_down_self {

    // ...Exercise 2...
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin

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
    @Test
    public void test01(){
        driver.get("https://amazon.com");
        WebElement menu= driver.findElement(By.xpath("//*[@aria-describedby='searchDropdownDescription']"));
        Select dropDown= new Select(menu);
        dropDown.selectByVisibleText("Baby");
        System.out.println(dropDown.getFirstSelectedOption().getText());
        List<WebElement> nikeelaj=dropDown.getOptions();
        Assert.assertTrue(nikeelaj.size()==28);


    }





}
