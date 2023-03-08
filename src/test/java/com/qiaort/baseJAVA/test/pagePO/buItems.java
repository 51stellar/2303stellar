package com.qiaort.baseJAVA.test.pagePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class buItems {
    @FindBy(xpath ="//*[@id=\"masForm\"]/div[2]/button")
    WebElement clickLoginButton;
    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement inputUsername;
    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"elcontainer\"]/main/div/div[1]/div[1]/button[1]/span")
    WebElement newButton;
    //bu新建页面元素
    @FindBy(xpath = "//*[@id=\"_FLD_T_00051\"]/div/div[1]/input")
    WebElement buName;
    @FindBy(xpath = "//*[@id=\"_FLD_T_00061\"]/div/div[1]/input")
    WebElement buYear;
    @FindBy(xpath = "/html/body/div[9]/div[1]/div/div[2]/table[2]/tbody/tr[1]/td[3]/a")
    WebElement buYear_2022;
    @FindBy(xpath = "//*[@id=\"_FLD_S_00062\"]/div/span/div[2]/div/input")
    WebElement buBrand;
    @FindBy(xpath = "//*[@id=\"el-popover-1404\"]/div/div[2]/div[3]/div[1]/span[2]")
    WebElement buBrand_midea;
    @FindBy(xpath = "//*[@id=\"_FLD_S_00009\"]/div/span/div[2]/div/input")
    WebElement BU;
    @FindBy(xpath = "//*[@id=\"el-popover-3256\"]/div/div[2]/div[1]/div[1]/span[2]")
    WebElement BU_obm;
    @FindBy(xpath = "//*[@id=\"_TARGETCOUNTRYAREA\"]/div/span/div[2]/div/input")
    WebElement TargetCountry;
    @FindBy(xpath = " //*[@id=\"el-popover-463\"]/div/div[2]/div[1]/div[1]/span[2]")
    WebElement TargetCountry_japan;
    @FindBy(xpath = "//*[@id=\"el-popover-463\"]/div/div[3]/button/span")
    WebElement TargetCountry_japan_ok;



    @FindBy(xpath = "//*[@id=\"_FLD_S_00065\"]/div/span/div[2]/div/input")
    WebElement MasterCategory;
    @FindBy(xpath = "//*[@id=\"_FLD_D_00005\"]/div/div[1]/input")
    WebElement ReleaseDate;
    @FindBy(xpath = "//*[@id=\"_FLD_D_00006\"]/div/div[1]/input")
    WebElement OnShelfDate;
    @FindBy(xpath = "//*[@id=\"_FLD_S_00064\"]/div/div[1]/div[1]/input")
    WebElement DemandScenarios;
    @FindBy(xpath = "//*[@id=\"_FLD_A_00008\"]/div/div[1]/textarea")
    WebElement Notes;

    public buItems(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    public void login(String username,String password)throws InterruptedException{
        inputUsername.sendKeys(username);
      //  Reporter.log("password"+password);
        inputPassword.sendKeys(password);
        clickLoginButton.click();
        Thread.sleep(6000);
    }
    public void clickButton(WebDriver webDriver) throws InterruptedException {
        newButton.click();
        Thread.sleep(6000);
        buName.sendKeys("test---00001");
        buYear.click();
        Thread.sleep(6000);
        buYear_2022.click();
        buBrand.click();
        Thread.sleep(6000);
        buBrand_midea.click();
        BU.click();
        Thread.sleep(6000);
        BU_obm.click();
        TargetCountry.click();
        Thread.sleep(6000);
        TargetCountry_japan.click();
        Thread.sleep(6000);
        TargetCountry_japan_ok.click();



    }
}
