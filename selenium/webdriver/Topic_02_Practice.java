package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Practice {
    WebDriver driver;
    @BeforeClass
    public void intitalBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://sso.sasktel.com/iam/mySasktelLogin?bmctx=573900EFA02B1469DB53F7C6EEA40B1E67F451BEFBAFC6C83C6842D8E0F592B1&contextType=external&username=string&OverrideRetryLimit=5&mfaCheck=true&password=secure_string&challenge_url=%2Fiam%2FmySasktelLogin&request_id=-4560027412810133751&authn_try_count=0&locale=en_CA&resource_url=https%253A%252F%252Fsso.sasktel.com%252Foamfed%252Fidp%252Finitiatesso%253Fproviderid%253Dhttps%253A%252F%252Fwww.sasktel.com%252Fsamlsps%252Facs");
    }
    @Test
    public void TC_01_ID() throws InterruptedException {
        driver.findElement(By.id("password-field"));
        Thread.sleep(3000);
    }
    @Test
    public void TC_02_Class() throws InterruptedException {
        driver.findElement(By.className("button-group"));
        Thread.sleep(3000);
    }
    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("password"));
    }
    @Test
    public void TC_04_LinkText(){
        driver.findElement(By.linkText("password"));
    }
    @Test
    public void TC_05_Partial_Link_Text(){
        driver.findElement(By.partialLinkText("password"));
    }
    @Test
    public void TC_06_Tagname(){
      driver.findElements(By.tagName("class"));
      // số nhiều (Elements)
    }
    @Test
    public void TC_07_Css(){
        driver.findElement(By.cssSelector("input[id='password-field']"));
        driver.findElement(By.cssSelector("a[class='button']"));
        driver.findElement(By.cssSelector("input[name='OAM_REQ_0']"));
        driver.findElement(By.cssSelector("a[href='MySasktelForgotUsername']"));
        driver.findElement(By.cssSelector("input"));
      //driver.findElement(By.xpath("Thẻ( đầu câu code)[hàm(id, class, name, href,href*)='']"));
    }
    @Test
    public void TC_08_XPath(){
        driver.findElement(By.xpath("//input[@id='password-field']"));
        driver.findElement(By.xpath("//a[@class='button']"));
        driver.findElement(By.xpath("//input[@name='username']"));
        driver.findElement(By.xpath("//a[text()='username']"));
        driver.findElements(By.xpath("//input"));
      //driver.findElement(By.xpath("//Thẻ( đầu câu code)[@hàm(id, class, name, text())='']"));
    }
    @Test
    public void TC_09_Relative_Locator(){ // Find By Position
    By usernameTextboxBy= By.cssSelector("input[id='username']");
    By passwordTextboxBY= By.id("password-field");
    driver.findElement(RelativeLocator.with(By.tagName("label")).above(passwordTextboxBY).below( usernameTextboxBy));
    }

// khi định danh được element của chính nó( dựa vào những cái vị trí bên cạnh/ gần đó)
// sử dụng để test GUI ( giao diện - position khớp với design)
    @AfterClass
    public void cleanBrowser() { driver.quit();}
}