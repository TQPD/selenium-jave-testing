package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {

    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){

        driver = new FirefoxDriver();

        driver.get("https://www.facebook.com/");

    }

    @Test
    public void TC_01_ID() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("Macbook");
        Thread.sleep(3000);
        driver.findElement(By.id("pass")).sendKeys("Automation");
        Thread.sleep(3000);
    }

    @Test
    public void TC_02_Class() throws InterruptedException {
        // Nó không lấy hết toàn bộ giá trị (nếu có khoảng trắng)
        driver.findElement(By.className("selected")).click();
        Thread.sleep(3000);
    }
    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("referrer"));
        driver.findElement(By.name("login"));
        driver.findElement(By.name("description"));
    }

    @Test
    public void TC_04_LinkText() {
        // chỉ làm việc với element là link
        // thẻ a và có thuộc tính href
        // di chuộc vô hiện hình bàn tay là link
        // Phải lấy hết toàn bộ text không chừa cái nào hết
        driver.findElement(By.linkText("Forgot password?"));
        driver.findElement(By.linkText("Create a Page")).click();
    }
    @Test
    public void TC_05_Partial_Link_Text(){
        // chỉ làm việc vs element là link
        // có thể lấy hết toàn bộ text hoặc 1 phần(hay dùng 1 phần )
        driver.findElement(By.partialLinkText("Forgot"));
        driver.findElement(By.partialLinkText("Page")).click();
    }

    @Test
    public void TC_06_Tagname(){
        // Tên thẻ (HTML)
        // Tìm tất cả các element giống nhau ( thẻ của component giống nhau)
        // Tất cả các textbox/ checkbox/ radio/ link/ button/ ...
        driver.findElements(By.tagName("button"));
        driver.findElements(By.tagName("input"));
        driver.findElements(By.tagName("label"));
    }

    @Test
    public void TC_07_Css(){
        driver.findElement(By.cssSelector("input#email"));
        driver.findElement(By.cssSelector("#email"));
        driver.findElement(By.cssSelector("input[id='email']"));

        driver.findElement(By.cssSelector("button.selected"));
        driver.findElement(By.cssSelector("button[class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']"));




        driver.findElement(By.cssSelector("a[href='#']"));
        driver.findElement(By.cssSelector("a[href='/pages/create/?ref_type=registration_form']"));

        driver.findElement(By.cssSelector("a[href*='#']"));
        driver.findElement(By.cssSelector("a[href*='pages']"));

        driver.findElement(By.cssSelector("a"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("input"));

        driver.findElement(By.cssSelector("select[name=''"));
        //phải bắt đầu bằn chữ select

    }

    @Test
    public void TC_08_Xpath(){
        driver.findElement(By.xpath("//input[@id='email']"));

        driver.findElement(By.xpath("//select[@name='login']"));


        driver.findElement(By.xpath("//select[@name='...']"));
        // phải bắt đầu bằng chữ select






    }
}
