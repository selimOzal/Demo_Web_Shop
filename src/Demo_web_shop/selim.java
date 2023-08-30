package Demo_web_shop;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class selim extends BaseDriver {

    @Test
    public void AnketYanıtlama()
    {
     driver.get("https://demowebshop.tricentis.com/");

        WebElement comminityPoll=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[1]/strong"));

        WebElement Excellent=driver.findElement(By.xpath("//*[@id=\"poll-block-1\"]/ul/li[1]/label"));
        Excellent.click();

        WebElement vote= driver.findElement(By.id("vote-poll-1"));
        vote.click();

        WebElement actualText= driver.findElement(By.id("block-poll-vote-error-1"));

        System.out.println(actualText.getText());

        WebElement LogIn=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        LogIn.click();

        WebElement email= driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        email.sendKeys("grup16basarir@gmail.com");

        WebElement password= driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        password.sendKeys("1234567Ss");

        WebElement rememberMe=driver.findElement(By.xpath("//*[@id=\"RememberMe\"]"));
        rememberMe.click();

        WebElement LogIn1=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
        LogIn1.click();

       List<WebElement> answer= driver.findElements(By.xpath("//*[@id=\"poll-block-1\"]/ul"));
        for(WebElement e: answer)

            System.out.println("e.getText() = " + e.getText());
    }
}
