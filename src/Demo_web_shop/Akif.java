package Demo_web_shop;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Akif extends BaseDriver {
    @Test
    public void Test1() {
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");

        WebElement register = driver.findElement(By.xpath("//*[@class='ico-register']"));
        register.click();
        MyFunc.Bekle(1);

        WebElement gender = driver.findElement(By.id("gender-male"));
        gender.click();
        MyFunc.Bekle(1);

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Akif");
        MyFunc.Bekle(1);

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Bilican");
        MyFunc.Bekle(1);

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("grup16basarir@gmail.com");
        MyFunc.Bekle(1);

        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys("1234567Ss");
        MyFunc.Bekle(1);

        WebElement confirmpassWord = driver.findElement(By.id("ConfirmPassword"));
        confirmpassWord.sendKeys("1234567Ss");
        MyFunc.Bekle(1);

        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
        MyFunc.Bekle(1);

        WebElement result = driver.findElement(By.xpath("//div[@class='result']"));
        Assert.assertTrue("Your registration is not completed! ", result.getText().equals("Your registration completed"));

        WebElement continuee = driver.findElement(By.xpath("//*[@class='button-1 register-continue-button']"));
        continuee.click();

    }


}
