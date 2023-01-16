package day13;

public class InterviewQuestions {

    /*

    Tell me 5 exception that you get/What type of exceptions do you get in selenium?
    Null pointer, no such element, time out, slate element reference, web driver

    What is your solution?
    Read the error message and learn what is the error and where it is.
    In general, error happens because of the timing issue, wrong locator, or iframe/windows/alerts
    Each error has specific solutions but in general, I debug my code,
    and do some research then execute the code one more time after the fix.

    What type of waits do you use?
    I use implicit or explicit wait
    Which wait do you prefer?
    Explicit wait works better in some cases. When I use explicit wait, and still see timeout exception,
    then there can be other issues such as incorrect locators.

    Why do you prefer that wait?
    I already have implicit wait in my Driver class,
    but I prefer explicit wait when I need to use an expected condition such as element is not visible.

    How do you resolve synronization issue?
    I use implicit or explicit wait. In my driver class, I already have implicit wait, that handles most of the wait issues,
    but when it is not enough than I use explicit wait.

    ***************************************************************************************************************************************************

     Seleniumda aldigin 5 exception?
    Null pointer, no such element, time out, slate element reference, web driver

    Genel olarak exception aldiginda bozum yolun nedir?
    Hata mesajini oku
    Genel olarak zamanlama, yanlis locator, iframe hataları olabiliyor
    Hata mesajina gore exception I cozdukden sonra tekrar kodumu calistirim

    Selniumda kullandigin waitler nelerdir?
    Implicit yada explicit yada fluent

    Hangi waiti tercih edersin?
    Test Base (Driver sinifinda) implicit wait kullanıyorum. Cogu problemi bozuyor Cozemedigi durumlarda explicit wait kullanıyorum.

    Neden Explicit wait?
    Explicit wait element e ozel yazilabilir. Yerel cozum gerektiğinde explicit wait I kullanmak zorundayiz.

    Senkronize(bekleme) problemlerini nasıl çözersin?
    Selenium waitlerini kullanarak. Implicit wait driver im da var, ama yetmedigi durumlarda explicit wait kullanirim.
    Bu yüzden ReusableMethod sinifimda tekrar tekrar kullanabileceğimiz explicit wait method lari var.
    Kolaylıkla explicit wait ile bekleme problemlerini cozebuliyoruz.


     */
}