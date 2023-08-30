package Demo_web_shop;


import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Suleyman extends BaseDriver {
    @Test
    public void NegatifOturumAcma(Login); {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        WebElement NegatifOturumAcma(Login)= driver.findElement(By.cssSelector("a[class='ico-login']"));
        MyFunc.Bekle(2);
        NegatifOturumAcma(Login).click();
        WebElement Emailgiris = driver.findElement(By.cssSelector("input[id='Email']"));
        Emailgiris.sendKeys("grup16basarir@gmail.com");
        MyFunc.Bekle(2);
        WebElement Password = driver.findElement(By.cssSelector("input[id='Password']"));
        Password.sendKeys("12345657Ss");
        MyFunc.Bekle(2);
        WebElement login2 = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        login2.click();
        WebElement computers = driver.findElement(By.cssSelector("a[chref='/computers']"));
        computers.click();


                BekleVeKapat();


      }
     }
