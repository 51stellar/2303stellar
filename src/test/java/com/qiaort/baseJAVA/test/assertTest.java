package com.qiaort.baseJAVA.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class assertTest {
    public WebDriver webDriver;

    @BeforeClass
    public void setUpEnv(){
        webDriver=new ChromeDriver();
    }
    @Test
    public void assertTest1() throws InterruptedException {
        String except="创新";
        WebDriverWait wait=new WebDriverWait(webDriver, 50);
       Actions actions=new Actions(webDriver);
        webDriver.get("https://www.midea.com/cn/");
       WebElement webElement1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div/div[1]/div[2]/ul/li[7]/div")));
        actions.moveToElement(webElement1);
        actions.perform();
           Thread.sleep(3000);
           WebElement webElement2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class=\"submenu-item\"]>a[href=\"/cn/About-Us/Innovation\"]")));
           String actul = webElement2.getText().toString();
           Assert.assertEquals(except, actul, "期望值与预期值不符合!");



    }
    @AfterClass
    public void closeEnv(){
        webDriver.quit();
    }

}
