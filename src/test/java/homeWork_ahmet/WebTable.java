package homeWork_ahmet;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTable extends TestBase {

   @Test
   public void printTable() {


      //    https://the-internet.herokuapp.com/tables
//    Create a class: WebTables
//    Task 1 : Table1’i print edin
//    Task 2 : 3. Row’ datalarını print edin
//    Task 3 : Son row daki dataları print edin
//    Task 4 : 5. Column datalarini print edin
//    Task 5 : Iki parametreli bir Java metot oluşturalım: printData
//    Parameter 1 = row numarasi
//    Parameter 2 = column numarasi
//    printData(2,3);  => 2nd row, 3rd column daki datayı print etsin

      //    https://the-internet.herokuapp.com/tables
      driver.get("https://the-internet.herokuapp.com/tables");

      //    Task 1 : Table1’i print edin
      String table2 = driver.findElement(By.xpath("//*[@id='table2']")).getText();
      System.out.println("table2 = " + table2);

      //    Task 2 : 3. Row’ datalarını print edin
      String satir3 = driver.findElement(By.xpath("//*[@id='table2']//tbody//tr[3]")).getText();
      System.out.println("satir3 = " + satir3);

      //    Task 3 : Son row daki dataları print edin
      String sonSatir = driver.findElement(By.xpath("//*[@id='table2']//tbody//tr[last()]")).getText();
      System.out.println("sonSatir = " + sonSatir);

      //Task 4 : 5. Column datalarini print edin
      List<WebElement> sütun5 = driver.findElements(By.xpath("//*[@id='table2']//tbody//tr//td[5]"));
      sütun5.forEach(veri -> System.out.println(veri.getText()));

      printDesiredData(3,2);


   }

   //    Task 5 : Iki parametreli bir Java metot oluşturalım: printData
   public void printDesiredData(int satir, int sütun) {

      driver.get("https://the-internet.herokuapp.com/tables");
      String myXpath="//*[@id='table2']//tbody//tr["+satir+"]//td["+sütun+"]";
      System.out.println(driver.findElement(By.xpath(myXpath)).getText());
   }
}