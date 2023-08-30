package Demo_web_shop;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FatmaNur extends BaseDriver {
    @Test
    public void SiparisVerme(){
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(2);

        WebElement login = driver.findElement(By.className("ico-login"));
        login.click();
        //MyFunc.Bekle(2);

        WebElement emailInput= driver.findElement(By.id("Email"));
        emailInput.click();
        emailInput.sendKeys("hakan@hotmail.com");
        // MyFunc.Bekle(1);

        WebElement passwordInput= driver.findElement(By.id("Password"));
        passwordInput.click();
        passwordInput.sendKeys("123456");
        //MyFunc.Bekle(1);

        WebElement loginButton = driver.findElement(By.cssSelector("[value='Log in']"));
        loginButton.click();
        // MyFunc.Bekle(2);

        //Anasayfada ürün listesinden bir ürünü seçebilmeliyim
        WebElement urun = driver.findElement(By.linkText("Build your own expensive computer"));
        urun.click();

        //Seçtiğim ürün için "Add to Cart" butonuna tıklayarak ürünü başarılı
        // bir şekilde sepete ekleyebilmeliyim.
        WebElement productName=driver.findElement(By.xpath("//div[@class='product-name']//h1"));
        String productNameAssert=productName.getText();
        WebElement addToChart = driver.findElement(By.id("add-to-cart-button-74"));
        addToChart.click();

        //Sepetim sayfasına giderek seçtiğim ürünün sepetimde görüntülendiğini doğrulayabilmeliyim.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[@class='content']")));
        WebElement shoppingCart = driver.findElement(By.xpath("(//*[@class='cart-label'])[1]"));
        shoppingCart.click();
        WebElement addToChartAssert = driver.findElement(By.xpath("//a[@class='product-name']"));
        Assert.assertTrue(addToChartAssert.getText().equals(productNameAssert));

        //Kargo bilgileri için "Select Country" ve "Select State" alanlarından uygun seçenekleri seçebilmeliyim.
        WebElement ulkeSecme = driver.findElement(By.id("CountryId"));
        Select ulkeler = new Select(ulkeSecme);
        ulkeler.selectByVisibleText("Turkey");

        //Şartları kabul etmek için "Agree" onay kutusunu işaretleyebilmeliyim.
        WebElement termsBox = driver.findElement(By.id("termsofservice"));
        termsBox.click();

        //"Checkout" butonuna tıklayarak ödeme işlemine başlayabilmeliyim.
        WebElement checkoutBox = driver.findElement(By.id("checkout"));
        checkoutBox.click();

        //Fatura Adresini girebilmeliyim ve devam edebilmeliyim.
        WebElement adressCountry = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select adressCountrySelect = new Select(adressCountry);
        adressCountrySelect.selectByVisibleText("Turkey");

        WebElement adressCity = driver.findElement(By.id("BillingNewAddress_City"));
        adressCity.sendKeys("Istanbul");
        WebElement adress_1 = driver.findElement(By.id("BillingNewAddress_Address1"));
        adress_1.sendKeys("Fatih Mah.");
        WebElement zipCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        zipCode.sendKeys("34567");
        WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phoneNumber.sendKeys("0532345678");
        WebElement continueButton1 = driver.findElement(By.xpath("//input[@onclick='Billing.save()']"));
        continueButton1.click();

        //"Mağazadan Teslim (In-Store Pickup)" seçeneğini seçebilmeliyim
        // ve Kargolama Adresinin kaybolduğunu doğrulayabilmeliyim, sonra devam edebilmeliyim.
        wait.until(ExpectedConditions.invisibilityOf(adressCity));
        WebElement magazadanAl = driver.findElement(By.xpath("//*[text()='In-Store Pickup']"));
        magazadanAl.click();
        WebElement adresSatiri = driver.findElement(By.id("shipping-address-select"));
        wait.until(ExpectedConditions.invisibilityOf(adresSatiri));
        Assert.assertTrue(!adresSatiri.isSelected());
        WebElement continueButton2 = driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
        continueButton2.click();


        //Ödeme Yöntemini seçebilmeliyim ve devam edebilmeliyim.
        wait.until(ExpectedConditions.invisibilityOf(magazadanAl));
        WebElement paymentMethod = driver.findElement(By.cssSelector("input[id='paymentmethod_0']"));
        paymentMethod.click();
        WebElement continueButton3 = driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        continueButton3.click();

        //Seçtiğim Ödeme Yöntemini "Payment Information" kısmında doğrulayabilmeliyim ve devam edebilmeliyim.
        wait.until(ExpectedConditions.invisibilityOf(paymentMethod));
        WebElement paymentInfo = driver.findElement(By.xpath("//*[@class='info']//p"));
        Assert.assertTrue(paymentInfo.getText().equals("You will pay by COD"));
        WebElement continueButton4 = driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));
        continueButton4.click();

        //Ürün fiyatıyla, ek ödemelerin toplamının, hesaplanan toplamla aynı olduğunu doğrulayabilmeliyim.
        // siparişi onaylayabilmeliyim.
        wait.until(ExpectedConditions.invisibilityOf(paymentInfo));
        List<WebElement> urunFiyatlari = driver.findElements(By.className("product-subtotal"));
        WebElement shipping = driver.findElement(By.xpath("(//span[@class='product-price'])[2]"));
        WebElement tax = driver.findElement(By.xpath("(//span[@class='product-price'])[3]"));
        WebElement total = driver.findElement(By.xpath("(//span[@class='product-price order-total'])//strong"));

        double urunToplami = 0;
        for (WebElement u: urunFiyatlari) {
            urunToplami = urunToplami + Double.parseDouble(u.getText().replaceAll("[^0-9,.]", ""));
        }

        double shippingPrice = Double.parseDouble(shipping.getText().replaceAll("[^0-9,.]", ""));
        double taxPrice = Double.parseDouble(tax.getText().replaceAll("[^0-9,.]", ""));
        double totalPrice = Double.parseDouble(total.getText().replaceAll("[^0-9,.]", ""));
        Assert.assertTrue(totalPrice==urunToplami+taxPrice+shippingPrice);

        WebElement continueButton5 = driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        continueButton5.click();
        //"Your order has been successfully processed!" mesajını görüntüleyerek
        // siparişin başarıyla tamamlandığını doğrulayabilmeliyim.
        wait.until(ExpectedConditions.invisibilityOf(total));
        WebElement dogrulamaMesaji = driver.findElement(By.cssSelector("[class='title'] strong"));
        Assert.assertTrue(dogrulamaMesaji.getText().equals("Your order has been successfully processed!"));

        BekleVeKapat();

    }
}

