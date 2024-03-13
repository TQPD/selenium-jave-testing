package webdriver;

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
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

}
