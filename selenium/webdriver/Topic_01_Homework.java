package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_01_Homework {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://www.qtrade.ca/en/investor/apply.html");
    }
    @Test
    public void TC_01_ID() throws InterruptedException {
        driver.findElement(By.id("lastName"));
        Thread.sleep(3000);
// Phải có chữ id="..."
    }
    @Test
    public void TC_02_Class() throws InterruptedException {
        driver.findElement(By.className("apply-page"));
        Thread.sleep(3000);
// không lấy phần có space trong class="..."
    }
    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("lastName"));
    }
    @Test
    public void TC_04_LinkText(){
        driver.findElement(By.linkText("Qtrade Privacy Policies."));
// Lấy hết trong >...<
    }
    @Test
    public void TC_05_Partial_Link_Text(){
        driver.findElement(By.partialLinkText("Qtrade"));
// lấy 1 phần trong >...<
    }
    @Test
    public void TC_06_Tagname(){
        driver.findElements(By.tagName("lable"));
        driver.findElements(By.tagName("text"));
    }
    @Test
    public void TC_07_Css(){
// Css không hổ trợ code
        driver.findElement(By.cssSelector("input[id='lastName']"));
// có input đầu câu code
        driver.findElement(By.cssSelector("button[class='hamburger']"));
// có button đầu câu code
        driver.findElement(By.cssSelector("select[name=''"));
// có select đầu câu code
        driver.findElement(By.cssSelector("a[href='/security']"));
        driver.findElement(By.cssSelector("a[href*='investor']"));
// Thêm dấu sao vào href*= thì sẽ lấy 1 phần của link.
// Bắt buộc đầu dòng code phải có ký tự a
// có ký tự a đầu câu code kết thúc bằng >...<
        driver.findElement(By.cssSelector("input"));
    }
    @Test
    public void TC_08_XPath(){
// XPath có hổ trợ text
// "//input,button,select,a[contains(@id, @class, @name, text()='...')]"
//dùng để chọn ít ký tự hơn trong'...'
        driver.findElement(By.xpath("//input[@id='lastName']"));
// có input đầu câu code
        driver.findElement(By.xpath("//button[@class='hamburger']"));
// có button đầu câu code
        driver.findElement(By.xpath("//select[@name='...']"));
//có select đầu câu code
        driver.findElement(By.xpath("//a[text()='Skip to main content']"));
// có ký tự a đầu câu code kết thúc bằng >...<
        driver.findElement(By.xpath("//input"));
    }
    @Test
    public void TC_09_Relative_Locator(){
        driver.get("https://sso.sasktel.com/iam/MySasktelEmailEntry");
        // Element/ By A
        By passwordTextboxBy = By.cssSelector("re");
        // Kèm theo thẻ tên ( input )
        // Element/ By B
        By RememberMeCheckboxBy= By.id("RemeberMe");
        // Kèm theo thẻ tên (ìd or class)
        // có Id thì dùn id để nhận dạng
        // Element/ By C
        By forgotUsernameTextLinkBy = By.cssSelector("span.forgot-password");

        // Kèm theo thẻ tên (a trong href)
        // Element/ By D
        By signUpButton = By.cssSelector("button.login-button");
        // ("button.phần class không có khoảng trắng);
        // Element/ By C
       WebElement rememberMeLabelText = driver.findElement(RelativeLocator.with(By.tagName("button"))
                .above(signUpButton)// label đang nằm trên login button
                .below(passwordTextboxBy) // label nằm dưới password textbox
                .toLeftOf(RememberMeCheckboxBy)// lable nằm bên phải checkbox
                .toRightOf(forgotUsernameTextLinkBy)// lable nằm bê trái forgot password
        );


    }
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}

