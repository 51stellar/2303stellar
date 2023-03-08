
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;






public class DemoLogin {

    public void testLogin(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://m.youximao.tv/#/login");
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        driver.manage().window().maximize();
        driver.findElement(By.name("account")).sendKeys("*****保密");
        driver.findElement(By.name("password")).sendKeys("*****保密");
        driver.findElement(By.className("el-button")).click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.close();

    }
    public static  void main(String args[]){
        DemoLogin demo=new DemoLogin();
        demo.testLogin();
    }

}
