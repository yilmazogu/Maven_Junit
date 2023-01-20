package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P11_UploadFile extends TestBase {

    //https://demo.guru99.com/test/upload/ adresine gidiniz
    //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
    // I accept terms of service bölümünü tikleyin
    // Submit File buttonuna basınız
    // "1 file has been successfully uploaded" görünür olduğunu test edin

    @Test
    public void upload() throws InterruptedException {

        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        WebElement upload=driver.findElement(By.cssSelector("input[name='uploadfile_0']"));
        String path="C:\\Users\\Oguz\\Desktop\\testcaseforjira.xlsx";
        String farkliYol=System.getProperty("user.home");
        String ortakYol="\\Desktop\\testcaseforjira.xlsx";
        String dosyaYolu=farkliYol+ortakYol;
        upload.sendKeys(dosyaYolu);

        // I accept terms of service bölümünü tikleyin
        // Submit File buttonuna basınız
        WebElement checkBox =  driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER);

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        Thread.sleep(2000);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();





    }


}
