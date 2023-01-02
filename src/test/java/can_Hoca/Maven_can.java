package can_Hoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Maven_can {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement nikelaj=driver.findElement(By.xpath("(//*[@class='inventory_item_name'])[1]"));
        String ambalaj=nikelaj.getText();
        nikelaj.click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepettekiUrun=driver.findElement(By.xpath("//*[@class='inventory_item_name']"));

        String actualUrun=sepettekiUrun.getText();

        System.out.println(actualUrun.equals(ambalaj) ? "Test Passed": "Test Failed" );

        driver.close();





    }
}






//9. Sayfayi kapatin
