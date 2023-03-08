package com.qiaort.baseJAVA.test;
import com.qiaort.baseJAVA.test.pagePO.buItems;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Set;
//登录gpm系统，保存cookie信息，以及使用数据驱动保存账号密码，驱动
public class gpmLogin {
    public WebDriver webDriver;

    @BeforeTest
    public void setUpEnv() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void LoginAndSetCookie() throws InterruptedException {
        webDriver.get("http://gpmuat.midea.com/flowList/WF22");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //调用buitems的登录方法
        buItems buItems=new buItems(webDriver);
        buItems.login("qiaort","peppa1//");
        Thread.sleep(3000);
        Set<Cookie> data = webDriver.manage().getCookies();
        System.out.print(data);
        for (Cookie cookie : data) {
            webDriver.manage().addCookie(cookie);
        }

    }

    @AfterTest
    public void closeEnv() {
        webDriver.quit();
    }
}
