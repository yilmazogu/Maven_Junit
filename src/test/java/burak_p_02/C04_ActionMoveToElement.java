package burak_p_02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C04_ActionMoveToElement extends TestBase {
    @Test
    public void test(){
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement bayrak=driver.findElement(By.xpath("//*[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-discoverability-t1']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(bayrak).perform();

        // Change country/region butonuna basiniz
        WebElement changeCountry=driver.findElement(By.xpath("(//*[text()='Change country/region.'])[1]"));
        changeCountry.click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement dilDropDown=driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(dilDropDown);
        select.selectByVisibleText("Turkey (Türkiye)");

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@class='a-container']")).click();
        driver.findElement(By.xpath("//*[@class='a-button-input']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        List<String> sayfalar= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(sayfalar.get(1));
        Assert.assertTrue(driver.getTitle().contains("Elektronik"));
}}
