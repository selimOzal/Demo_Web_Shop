package Demo_web_shop;

import org.junit.Assert;
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

        driver.get("https://demowebshop.tricentis.com/");
        WebElement log_in =driver.findElement(By.className("ico-login"));
        log_in.click();

        String Email = "grup16basarir@gmail.com";
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys(Email);

        String Password = "1234567Ss";
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys(Password);

        WebElement loginButton = driver.findElement(By.cssSelector("[value='Log in']"));
        loginButton.click();

     // Login islemi yapildi simdi Logout yapabilabilir.

        WebElement logoutButton = driver.findElement(By.className("ico-logout"));
        logoutButton.click();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/"));

    }
}

