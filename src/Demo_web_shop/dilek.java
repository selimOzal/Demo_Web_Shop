package Demo_web_shop;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dilek extends BaseDriver {
    @Test
    public void OturumAcma() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        WebElement loginButon = driver.findElement(By.cssSelector("a[class='ico-login']"));
        loginButon.click();
        WebElement Emailgiris = driver.findElement(By.cssSelector("input[id='Email']"));
        Emailgiris.sendKeys("grup16basarir@gmail.com");
        MyFunc.Bekle(2);
        WebElement Passwordgiris = driver.findElement(By.cssSelector("input[id='Password']"));
        Passwordgiris.sendKeys("12345657Ss");
        MyFunc.Bekle(2);
        WebElement login2 = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        login2.click();
        WebElement computers = driver.findElement(By.cssSelector("a[href='/computers']"));
        computers.click();


        Assert.assertTrue(login2.getText().toLowerCase().contains("success"));



    }

