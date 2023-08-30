package Demo_web_shop;
import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeynepUs02 extends BaseDriver {

    @Test
    public void NegatifHesapOlusturma(){

        WebDriver driver= new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");

        WebElement accountRegister = driver.findElement(By.className("ico-register"));
        accountRegister.click();

        WebElement selectGender = driver.findElement(By.id("gender-male"));
        selectGender.click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.click();
        firstName.sendKeys("Osman");

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.click();
        lastName.sendKeys("Yilmaz");

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.click();
        emailInput.sendKeys("osmanenosman@hotmail.com");

        WebElement passwordInput= driver.findElement(By.id("Password"));
        passwordInput.click();
        passwordInput.sendKeys("1234567Ss");

        WebElement confirmPassword= driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.click();
        confirmPassword.sendKeys("1234567Ss");

        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        registerButton.click();

        WebElement alert = driver.findElement(By.className("validation-summary-errors"));
        String errorMessage = alert.getText();
        System.out.println("Error message is: " + errorMessage);
        Assert.assertTrue(alert.getText().equals("The specified email already exists"));




        BekleVeKapat();



    }
}
