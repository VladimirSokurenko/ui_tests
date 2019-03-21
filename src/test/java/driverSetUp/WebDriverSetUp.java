package driverSetUp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebDriverSetUp {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("chromedriver", "/home/alexander/IdeaProjects/mnd_prime_uitest");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    public void openBrowser(String url){
        driver.get(url);
    }

    public void clickWebElement(WebElement element){
        element.click();
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName){
        try
        {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
            System.out.println("Screenshot has taken!");
        } catch (Exception e){
            System.out.println("Exception" + e.getMessage());
        }
    }

    public boolean verifyElementPresent(String locator){
    try {
        driver.findElement(By.xpath(locator));
        return true;
    } catch (org.openqa.selenium.NoSuchElementException e) {
        return false;
        }
    }

    @AfterMethod
    public void exitBrowser(){
        driver.quit();
    }







}
