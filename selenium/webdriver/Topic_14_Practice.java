package webdriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_14_Practice {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/?stype=lo&deoia=1&jlou=AfdSLhZhqjZDmEEqpxZXqTFl4a3WY1XYOKSBALd6b3Lrf9GRhsYmWevSWJNelycOxowhnGSCiynb8uztteWDJYU2Rs6xTqsiM4RiL7xoX3RCLg&smuh=43462&lh=Ac-_au3DO7OqsPenZHU");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_XPath() {
        driver.findElement(By.xpath("//div[@id='content']//a[text()='Forgot password?']")).click();
        driver.findElement(By.xpath("//div[@class='mvl copyright']//span"));
        //tag_name[@Attribute_name="Value odd attribute(phải có giá trị)"];
    }
    @Test
    public void Register_01_Emty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        // Action
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Assert
        Assert.assertEquals( driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals( driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email");
        Assert.assertEquals( driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals( driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals( driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals( driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Vui lòng nhập số điện thoại.");
    }
    @Test
    public void Register_02_Invalid_Email () {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        // Verify
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtEmail")).sendKeys("123@345@321");
        driver.findElement(By.id("txtCEmail")).sendKeys("123@345@321");
        //Action
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals( driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals( driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");

    }
    @Test
    public void Register_03_Incorrect_Confirm_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtCEmail")).sendKeys("johnwick@gmail.com");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals( driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng" );
    }
    @Test
    public void Register_04_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtPassword")).sendKeys("123");
        driver.findElement(By.id("txtCPassword")).sendKeys("123");


        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }
    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtCPassword")).sendKeys("123467");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu bạn nhập không khớp");
    }
    @Test
    public void Register_06_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtPhone")).sendKeys("09123467");
        driver.findElement(By.id("txtPhone")).sendKeys("2212346734");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");

        driver.findElement(By.id("txtPhone")).clear();
        // Làm 2 Element thì dùng clear và làm tiếp
        driver.findElement(By.id("txtPhone")).sendKeys("2212346734");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

}