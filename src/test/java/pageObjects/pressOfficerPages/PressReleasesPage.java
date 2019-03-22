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

    final static String PUBLISH_FILTER_BUTTON ="publish-filter-button";

    public void verifyFilterButtonIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(PUBLISH_FILTER_BUTTON))));
        System.out.println("User navigate to the press release section");
    }

    public void chooseAllOption(){ allFilterOption.click(); }

    public void chooseDraftOption(){ draftFilterOption.click(); }

    public void choosePublishOption(){ publishFilterOption.click(); }

    public void chooseScheduledOption(){ scheduleFilterOption.click(); }

    public void verifyFilterText(String text){
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id(PUBLISH_FILTER_BUTTON)), text));
        System.out.println("Filter button has " + text + " text");
    }

    public void clickOnFilterButton(){ publishFilterButton.click(); }

    public void verifyTopMaterialIs(String materialType){ // should be changed this is not POM and PFM
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.textToBePresentInElement(firstMaterialHeading, materialType));
        System.out.println("The top material is " + firstMaterialHeading.getText());
    }


}
