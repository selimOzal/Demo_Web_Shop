package Demo_web_shop;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static Utlity.BaseDriver.driver;

public class elif {
    @Test
    public void Logout() {

        // Logout yapabilmek icin once Login olmak gerekiyor
        WebElement log_in =driver.findElement(By.xpath("//div[@id='bar-notification']"));
        log_in.click();

        String Email = "grup16basarir@gmail.com";
        WebElement email = driver.findElement(By.xpath("//div[@class='master-wrapper-page']"));
        email.sendKeys(Email);

        String Password = "1234567Ss";
        WebElement password = driver.findElement(By.id("//input[@type='password']"));
        password.sendKeys(Password);

        WebElement rememberMe=driver.findElement(By.id("//input[@type='checkbox']"));
        rememberMe.click();


     // Login islemi yapildi simdi Logout yapabilabilir.



        WebDriver driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        WebElement logoutButton = driver.findElement(By.xpath("//div[@class='master-wrapper-page']"));
        logoutButton.click();










    }
}

