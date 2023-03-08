package com.qiaort.baseJAVA.test;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TestCase {
    public WebDriver webDriver;

    @BeforeClass
    public void setUpEnv(){
        webDriver=new ChromeDriver();
      //  webDriver.get("https://baidu.com/");
    }

    @Test
    public void openWebBaidu() throws InterruptedException {
        //创建浏览器实例
        webDriver.findElement(By.id("kw")).sendKeys("ljj");
        webDriver.findElement(By.id("su")).click();
        Thread.sleep(3000);
    }
    @Test
    public void testName() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.findElement(By.className("wd")).sendKeys("zyx");
        webDriver.findElement(By.className("s_btn")).click();
    }
    @Test
    //使用Xpath定位元素
    public void testXpath(){

        webDriver.findElement(By.xpath("//a[@id=\"nav_hotel\" and text()=\"酒店\"]")).click();
    }
    @Test
    public void testCss(){
        webDriver.findElement(By.cssSelector("li[id=\"cui_nav_hotel\"]>a[id=\"nav_hotel\"]")).click();
    }
    @Test
    public void testAction(){
        Actions actions=new Actions(webDriver);
        WebElement morebtn = webDriver.findElement(By.linkText("更多"));
        actions.moveToElement(morebtn);
        WebElement MP3btn=webDriver.findElement(By.cssSelector("a[name=\"tj_mp3\"]>img[src=\"https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/topnav/yinyue@2x-c18adacacb.png\"]"));
        actions.moveToElement(MP3btn).click().perform();
    }
    @Test
    //测试拖拽地图
    public void baiduMap() throws InterruptedException {
        Thread.sleep(3000);
        WebElement platform=webDriver.findElement(By.id("mask"));
        Actions actions=new Actions(webDriver);
        actions.moveToElement(platform).contextClick().pause(3000);
        WebElement cmitem_start=webDriver.findElement(By.id("cmitem_start"));
        actions.moveToElement(cmitem_start).click();
        //拖拽地图
        actions.clickAndHold();
        actions.moveByOffset(200,100);
        actions.release();
        actions.contextClick();
        actions.pause(3000);
        WebElement cmitem_end=webDriver.findElement(By.id("cmitem_end"));
        actions.moveToElement(cmitem_end).click();
        actions.pause(3000);
        actions.perform();
    }
    @Test
    public void testSwitchWindows(){
        webDriver.findElement(By.linkText("学术")).click();
        String currentWindow=webDriver.getWindowHandle();
        Set<String> allWindows=webDriver.getWindowHandles();
        for(String window:allWindows){
            if(window!=currentWindow){
                webDriver.switchTo().window(window);
            }
        }
        webDriver.findElement(By.id("kw")).sendKeys("huanxiaoming");
        webDriver.switchTo().window(currentWindow);
        webDriver.findElement(By.id("kw")).sendKeys("hahhahaha");
    }
    @Test
    //使用iframe定位
    public void testSwitchFrame(){
        webDriver.get("https://login.anjuke.com/login/form");
        WebElement iframe=webDriver.findElement(By.id("iframeLoginIfm"));
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.id("phoneIpt")).sendKeys("11111111");
    }
    @Test
    //隐式等待-全局等待时间-最长找10s
    public void setImplicity(){
        webDriver.get("https://www.juhe.cn/register");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.findElement(By.id("username")).sendKeys("123456789");
    }
    @Test
    //显示等待-设置单个元素等待时间-最长找10s
    public void setTimeout(){
        webDriver.get("https://www.juhe.cn/registr");
    WebDriverWait wait=new WebDriverWait(webDriver, 60);
    WebElement frame=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        webDriver.findElement(By.id("username")).sendKeys("123456789");
    }



    @AfterClass
    public void closeEnv() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}
