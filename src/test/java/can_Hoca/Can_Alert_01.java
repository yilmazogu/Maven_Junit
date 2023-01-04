package can_Hoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Can_Alert_01 {


    static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
    }







    //    and then sendKeys 'TechProEducation' (Please enter your name)
//Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
//Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
    //    finally print on console this mesaaje "Hello TechproEducation How are you today"

    @Test
    public void test() throws InterruptedException {
        //   // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//*[@href='#OKTab']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();

        //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("//*[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();

        //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        driver.findElement(By.xpath("//*[@href='#Textbox']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
        Thread.sleep(3000);


        //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();








    }


}
