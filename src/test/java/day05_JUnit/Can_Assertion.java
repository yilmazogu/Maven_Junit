package day05_JUnit;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Can_Assertion {

    static WebDriver driver;
    static List<String> markaText=new ArrayList<>();
    static List<String> cardNameText=new ArrayList<>();
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();

    }
    @Test
    public void test01() throws InterruptedException {
        //~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        //~ click on Phones & PDAs
        driver.findElement(By.xpath("(//*[.='Phones & PDAs'])[1]")).click();

        //~ get the brandName of phones
        List<WebElement> brandName= driver.findElements(By.xpath("//h4"));

        getName(brandName,markaText);

        System.out.println(markaText);

        //~ click on add to button for all elements
        List<WebElement> addTOCard=driver.findElements(By.xpath("//*[.='Add to Cart']"));

        clickAllElement(addTOCard);

        //~ click on black total added cart button

        driver.findElement(By.xpath("//*[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();

        //~ get the names of list from the cart

        List<WebElement> cartList=driver.findElements(By.xpath("//*[@class='text-left']"));

        getName(cartList,cardNameText);

        System.out.println(cardNameText);

        //~ compare the names from displaying list and cart list

        compareTwoList(markaText,cardNameText);


    }
    public static void getName(List<WebElement> a, List<String> b){

        for (WebElement w: a) {

            b.add(w.getText());

        }
        Collections.sort(b);

    }
    public static void clickAllElement(List<WebElement> c){

        for (WebElement w: c) {

            w.click();
        }
    }

    public void compareTwoList(List<String>x, List<String> y ){

        Assert.assertEquals(x,y);
        System.out.println("Test Nikelaj");
    }
}







