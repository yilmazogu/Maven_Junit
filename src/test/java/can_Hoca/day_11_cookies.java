package can_Hoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day_11_cookies extends TestBase {

    @Test
    public void test(){

        driver.get("https://www.amazon.com");

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iPhone13 512" + Keys.ENTER);

        WebElement gorunurluk=driver.findElement(By.xpath("//*[@class='a-size-medium-plus a-color-base a-text-normal']"));
        Assert.assertTrue(gorunurluk.isDisplayed());

        WebElement model=driver.findElement(By.xpath("//*[text()='iPhone 13 Mini, 512GB, Starlight - Unlocked (Renewed Premium)']"));
        String modeliIsmi=model.getText();
        List<String>kelimeler=new ArrayList<>(Arrays.asList(modeliIsmi.split(" ")));
        System.out.println(kelimeler);
        System.out.println(kelimeler.get(0) + " " + kelimeler.get(1) );
        model.click();

        WebElement renk=driver.findElement(By.xpath("(//*[text()='Starlight'])[1]"));
        String renkIsmi=renk.getText();
        System.out.println(renkIsmi);

        driver.findElement(By.xpath("//*[@aria-labelledby='size_name_2-announce']")).click();

    }




}
