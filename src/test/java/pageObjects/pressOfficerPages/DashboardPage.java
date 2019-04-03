package pageObjects.pressOfficerPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[1]/div/span")
    WebElement publishMenuDropDown;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[1]/div/div/div/a[1]")
    WebElement pressReleasesOption;

    final static String PUBLISH_DROP_DOWN = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[1]/div/span";

    public void clickOnPublishDropDown(){ publishMenuDropDown.click(); }

    public void clickOnPressReleasesOption(){ pressReleasesOption.click(); }

    public void verifyUrl(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://publish.mynewsdesk.com/se/dashboard");
        System.out.println("url is " + url);
    }

    public void verifyDashboardSection(){
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(PUBLISH_DROP_DOWN)))).click();
        System.out.println("User navigate to the dashboard section");
    }

}
