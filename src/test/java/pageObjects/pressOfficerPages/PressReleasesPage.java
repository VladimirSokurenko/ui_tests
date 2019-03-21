package pageObjects.pressOfficerPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PressReleasesPage {

    WebDriver driver;

    public PressReleasesPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.ID, using = "publish-filter-button")
    WebElement publishFilterButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div/div/ul/li[1]/a")
    WebElement allFilterOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div/div/ul/li[2]/a")
    WebElement draftFilterOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div/div/ul/li[3]/a")
    WebElement publishFilterOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div/div/ul/li[4]/a")
    WebElement scheduleFilterOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/ul/li[1]/div/div/div")
    WebElement firstMaterialHeading;

    public void verifyFilterButtonIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(publishFilterButton));
        System.out.println("User navigate to the press release section");
    }

    public void chooseAllOption(){ allFilterOption.click(); }

    public void chooseDraftOption(){ draftFilterOption.click(); }

    public void choosePublishOption(){ publishFilterOption.click(); }

    public void chooseSecheduledOption(){ scheduleFilterOption.click(); }

    public void verifyFilterText(String text){
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.textToBePresentInElement(publishFilterButton, text));
        System.out.println("Filter button has " + text + " text");
    }

    public void clickOnFilterButton(){ publishFilterButton.click(); }

    public void verifyDraftMaterialsListed(){
        WebDriverWait wait = new WebDriverWait(driver, 4);
        for (int i = 1; i <= 10 ; i++) {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[2]/ul/li["+i+"]/div/div/div"));
            wait.until(ExpectedConditions.textToBePresentInElement(element, "Draft"));
        }
    }

    public void verifyTopMaterialIs(String materialType){ // should be changed this is not POM and PFM
        WebDriverWait wait = new WebDriverWait(driver, 4);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[2]/ul/li[1]/div/div/div"));
        wait.until(ExpectedConditions.textToBePresentInElement(element, materialType));
        System.out.println("The top material is " + element.getText());
    }


}
