package Demo_web_shop;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utlity.BaseDriver.driver;

public class Suleyman extends BaseDriver {

    @Test
    public void negatifTest1() {

        driver.get("https://demowebshop.tricentis.com");

        WebElement LogIn = driver.findElement(By.linkText("Log in"));
        LogIn.click();

        String Email = " ";
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys(Email);

        String Password = "1234567SS";
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys(Password);

        WebElement rebemberMe=driver.findElement(By.id("RememberMe"));
        rebemberMe.click();

        WebElement Login2=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        Login2.click();

        String msj = "Login was unsuccessful. Please correct the errors and try again.";
        Assert.assertEquals(msj, "Login was unsuccessful. Please correct the errors and try again.");

    }
    @Test
    public void negatifTest2(){

        driver.get("https://demowebshop.tricentis.com");
        WebElement LogIn = driver.findElement(By.linkText("Log in"));
        LogIn.click();

        String Email = "grup16basardi@gmail.com";
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys(Email);


        String Password = "1234567Ss";
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys(Password);

        WebElement rebemberMe=driver.findElement(By.id("RememberMe"));
        rebemberMe.click();

        WebElement Login2=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        Login2.click();

        String msj = "Login was unsuccessful. Please correct the errors and try again.";

        Assert.assertEquals(msj, "Login was unsuccessful. Please correct the errors and try again.");
    }


}
