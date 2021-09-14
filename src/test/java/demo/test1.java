package demo;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class test1
{
//    static String username = "user_name";
//    static String accesskey = "access_key";
//    static RemoteWebDriver driver = null;
//    static String gridURL = "@hub.lambdatest.com/wd/hub";
//    static boolean status = false;
    public static WebDriver driver;

    public static void main(String[] args)
    {
        new test1().login();
    }

    public void login()
    {
        setUp();

        //Creating the JavascriptExecutor interface object by Typecasting
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Launching the Site.
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Maximize window
        driver.manage().window().maximize();

        //Login to site
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");

        //Perform Click on LOGIN button using JavascriptExecutor
        WebElement button =driver.findElement(By.className("button"));
        js.executeScript("arguments[0].click();", button);

        //Get page title and Domain using JavascriptExecutor
        String titleText =  js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: "+ titleText);

        String domainName=  js.executeScript("return document.domain;").toString();
        System.out.println("Domain is: "+domainName);

        //To generate an Alert window using JavascriptExecutor. Display the alert message
        js.executeScript("alert('Successfully Logged In');");
        sleep(2000);

        tearDown();
    }

    public static void sleep(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static void setUp()
    {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("version", "latest");
//        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one.
//        capabilities.setCapability("build", "JSExecutor-RemoteGrid");
//        capabilities.setCapability("name", "LambdaTestJavaSample");
//
        try
        {
            System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
            driver=new ChromeDriver();
//            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        }
//        catch (MalformedURLException e)
//        {
//            System.out.println("Invalid grid URL");
//        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void tearDown()
    {
        if (driver != null)
        {
            //((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit(); //really important statement for preventing your test execution from a timeout.
        }
    }
}
