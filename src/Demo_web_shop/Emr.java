package Demo_web_shop;
import Utlity.BaseDriver;
import Utlity.MyFunc;
import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Emr extends BaseDriver {
    @Test
    public void Coupons_and_gift_cards() {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.className("ico-login"));
        login.click();

        WebElement emailInput= driver.findElement(By.id("Email"));
        emailInput.click();
        emailInput.sendKeys("emr@test.com");

        WebElement passwordInput= driver.findElement(By.id("Password"));
        passwordInput.click();
        passwordInput.sendKeys("Test1234");

        WebElement loginButton = driver.findElement(By.cssSelector("[value='Log in']"));
        loginButton.click();

        WebElement computers = driver.findElement(By.xpath("//ul[@class='top-menu'] /li[2]/a"));
        computers.click();


        WebElement product = driver.findElement(By.xpath("//div[@class='sub-category-grid'] / div[2]"));
        product.click();

        WebElement addToCart = driver.findElement(By.cssSelector("[value='Add to cart']"));
        addToCart.click();

        WebElement goToCart = driver.findElement(By.xpath("//*[@id='topcartlink']/a"));
        goToCart.click();

        WebElement discounCode = driver.findElement(By.xpath("//*[@class='discount-coupon-code']"));
        discounCode.sendKeys("123456");

        WebElement applyDiscounCode = driver.findElement(By.xpath("//*[@name='applydiscountcouponcode']"));
        applyDiscounCode.click();

        WebDriverWait bekle=new WebDriverWait(driver, Duration.ofSeconds(5));
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='message']")));

        WebElement submitControl = driver.findElement(By.xpath("//*[@class='message']"));
        Assert.assertTrue("Discount Code kabul edildi!!!!", submitControl.getText().contains("The coupon code you entered couldn't be applied to your order"));




        WebElement giftCode = driver.findElement(By.xpath("//*[@class='gift-card-coupon-code']"));
        giftCode.sendKeys("123456");

        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='message']")));
        WebElement applyGiftCode = driver.findElement(By.xpath("//*[@name='applygiftcardcouponcode']"));
        applyGiftCode.click();

        WebElement submitControlGift = driver.findElement(By.xpath("//*[@class='message']"));
        Assert.assertTrue("Gift Code kabul edildi!!!!", submitControlGift.getText().contains("The coupon code you entered couldn't be applied to your order"));


        BekleVeKapat();
    }
}
