package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Can_DropDown {

    static WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    /*
    1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
    2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
    3-Option3 ü seçin.
    4-Option3 ün seçili olduğunu doğrulayın.
    */
    @Test
    public void test(){

        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        WebElement dropDownExample=driver.findElement(By.xpath("//*[.='Dropdown Example']"));
        Assert.assertTrue(dropDownExample.isDisplayed());
        WebElement option3=driver.findElement(By.xpath("//*[@id='dropdown-class-example']"));
        Select menu=new Select(option3);
        menu.selectByVisibleText("Option3");
        String actualResult=menu.getFirstSelectedOption().getText();
        Assert.assertEquals("Option3",actualResult);
        driver.quit();



    }
}
