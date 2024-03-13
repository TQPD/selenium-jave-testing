package webdriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Topic_13_Practice {

    WebDriver driver;

    @BeforeClass
    public void intitalBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://www.amazon.ca/b/ref=win24_l0_dt_herott_2?pf_rd_r=G69FVBP9FZQ09JQV0BRJ&pf_rd_p=d8543181-9b3f-421f-b3f0-5a9cf77b81a9&pf_rd_m=A3DWYIK6Y9EEQB&pf_rd_s=merchandised-search-3&pf_rd_t=&pf_rd_i=21353444011&node=120788025011");
    }
    @Test
    public void TC_01_XPath(){
    driver.findElement(By.xpath (""));
// input type="email" autocapitalize="none" autocorrect="off"
// spellcheck= "false" name=" login[username]" value=""
// id="email class='input-text required-entry validate-email"
// title="Email Address">

// input[@type='email']
// input[@autocapitalize='none']
// input[@autocorrect='off']
// input[@spellcheck='false']
// input[@name='login[username]']
// input[@value='']
// input[@id='email']
// input[@class='input-text required-entry validate-email']
// input[@title='Email Address']

// 1- Bắt buộc nó phải là duy nhất
// input[@id='email']
// input[@name='login[username]']
// input[@title='Email Address']

// 2- Ưu tiên nếu có id/ class/ name thì dùng trước
// input[@id='email']
// input[@name='login[username]']

// 3- không có id/ class/ name: dùng bất kì 1 cái attribute khác

// 4- Giá trị của attribute phải có nghĩa -  liên quan tới cái element đó
// input[@title='Email Address']

// => tối ưu nhất để dùng

    }
    @AfterClass
    public void cleanBrowser() { driver.quit();}


}
