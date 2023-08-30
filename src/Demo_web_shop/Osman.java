package Demo_web_shop;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Osman extends BaseDriver {
    @Test
    public void ListeIndirme(){

        //Anasayfada giriş yaparak hesabıma erişebilmeliyim.
        driver.get("https://demowebshop.tricentis.com/");


        WebElement login = driver.findElement(By.className("ico-login"));
        login.click();

        WebElement emailInput= driver.findElement(By.id("Email"));
        emailInput.click();
        emailInput.sendKeys("osmanenosman@hotmail.com");


        WebElement passwordInput= driver.findElement(By.id("Password"));
        passwordInput.click();
        passwordInput.sendKeys("1234567Ss");


        WebElement loginButton = driver.findElement(By.cssSelector("[value='Log in']"));
        loginButton.click();


        //Hesabım sayfasında "My account (mail adresiniz)" veya benzeri bir bağlantıyı görmeliyim
        // ve bu bağlantıya tıklayarak hesap bilgilerimi görüntüleyebilmeliyim.

        WebElement myAccount = driver.findElement(By.xpath("(//a[@class='account'])[1]"));
        Assert.assertTrue("Mail adresi gorunmuyor!!!", myAccount.getText().equals("osmanenosman@hotmail.com"));


        // ve bu bağlantıya tıklayarak hesap bilgilerimi görüntüleyebilmeliyim.
        myAccount.click();


        WebElement firstName = driver.findElement(By.id("FirstName"));
        WebElement lastName = driver.findElement(By.id("LastName"));
        WebElement email = driver.findElement(By.id("Email"));

        Assert.assertTrue("Isim gorunmuyor", firstName.getAttribute("value").equals("Osman"));
        Assert.assertTrue("Soyisim gorunmuyor", lastName.getAttribute("value").equals("Yilmaz"));
        Assert.assertTrue("Email gorunmuyor", email.getAttribute("value").equals("osmanenosman@hotmail.com"));

        //Hesap bilgileri sayfasında "Orders" veya "Siparişler" adlı bir bağlantıyı görmeliyim
        //ve bu bağlantıya tıklayarak sipariş geçmişimi görüntüleyebilmeliyim.

        WebElement orders = driver.findElement(By.xpath("(//a[@class='inactive'])[2]"));
        orders.click();


        List<WebElement> siparisGecmisi = driver.findElements(By.xpath("//ul[@class='info']"));
        Assert.assertTrue("Siparis gesmisi gorunmuyor", siparisGecmisi.size()>0);
        System.out.println("*** Siparis Detayi ***");
        for (WebElement s: siparisGecmisi)
            System.out.println(s.getText());

        //Bir siparişin detaylarına erişmek için ilgili sipariş numarasına tıklayabilmeliyim.
        List<WebElement> details = driver.findElements(By.cssSelector("[value='Details']"));
        for (WebElement d: details){
            d.click();
            driver.navigate().back();}


        //Sipariş detayları sayfasında, siparişin faturasını indirebilmeliyim.
        for (WebElement d: details){
            d.click();
            WebElement invoice = driver.findElement(By.cssSelector("[class='button-2 pdf-order-button']"));
            invoice.click();
            driver.navigate().back();}

        BekleVeKapat();
    }
}
