package demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class test1 {
    WebDriver driver;
    String url="http://google.com";


    @BeforeTest
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(url);

    }
    @Test
    public  void  start() throws IOException {
        File fim=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fim, new File("C:\\Users\\mohab\\IdeaProjects\\selenium\\img.png"));
    }

    @AfterTest
    public  void end(){
        driver.quit();

    }
}
