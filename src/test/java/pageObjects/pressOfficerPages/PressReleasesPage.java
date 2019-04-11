package pageObjects.pressOfficerPages;

import driverSetUp.WebDriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class PressReleasesPage {

    WebDriver driver;

    public PressReleasesPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.ID, using = "publish-filter-button")
    WebElement publishFilterButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div/div/ul/li[1]/a")
    WebElement allFilterOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app-overlay\"]/div/div/div/div[3]/section/button[1]")
    WebElement cloneButton;

    @FindBy(how = How.LINK_TEXT, using = "Draft")
    WebElement draftFilterOption;

    @FindBy(how = How.LINK_TEXT, using = "Published")
    WebElement publishFilterOption;

    @FindBy(how = How.LINK_TEXT, using = "Scheduled")
    WebElement scheduleFilterOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[5]/ul/li[1]/div[1]/div/div/span")
    WebElement firstMaterialHeading;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[5]/ul/li[1]/div[1]/div/span/a")
    WebElement pressReleaseTitle;

    @FindBy(how = How.ID, using = "actions-dropdown")
    WebElement actionsDropDown;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/ul/li[1]/div[2]/ul/li[7]/a")
    WebElement deleteDraftOption;

    @FindBy(how = How.LINK_TEXT, using = "Clone")
    WebElement cloneActionButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app-overlay\"]/div/div/div/div[3]/section/ul/li[1]/div[2]/div/span/span")
    WebElement newsRoomHeading;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[3]/a")
    WebElement createNewPressReleaseButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"54458\"]")
    WebElement codemoGlobalCheckBox;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Codemocrazy global")
    WebElement codemoGlobalSelectOption;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div/div[2]/p")
    WebElement toasterParagraph;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[3]/ol/li[3]")
    WebElement newsRoomSelector;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[4]/ul/div/h3")
    WebElement allZeroStateHeadingText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[4]/ul/div/a")
    WebElement allZeroStateCreateButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[5]/ul/div/h3")
    WebElement filteredZeroStateHeading;

    final static String PUBLISH_FILTER_BUTTON ="publish-filter-button";

    public void verifyFilterButtonIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(PUBLISH_FILTER_BUTTON))));
        System.out.println("User navigate to the press release section");
    }

    public void chooseAllOption(){ allFilterOption.click(); }

    public void clickOnNewsRoomSelector(){ newsRoomSelector.click(); }

    public void chooseDraftOption(){ draftFilterOption.click(); }

    public void choosePublishOption(){ publishFilterOption.click(); }

    public void chooseScheduledOption(){ scheduleFilterOption.click(); }

    public void verifyFilterText(String text){
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id(PUBLISH_FILTER_BUTTON)), text));
        System.out.println("Filter button has " + text + " text");
    }

    public void checkFirstNewsRoomCheckBox(){
        codemoGlobalCheckBox.click();
        if(codemoGlobalCheckBox.isSelected()){
            System.out.println(newsRoomHeading.getText() + " is selected!");
        } else {
            System.out.println(newsRoomHeading.getText() + " is NOT selected!");
        }
    }

    public void verifyToasterText(String title){
        String toasterRealText = toasterParagraph.getText();
        System.out.println(toasterRealText);
        String toasterExpectedText = "\"" + title + "\" was successfully cloned";
        Assert.assertEquals(toasterExpectedText, toasterExpectedText);

    }

    public void clickCreateNewPressReleaseButton(){ createNewPressReleaseButton.click(); }

    public void clickOnFilterButton(){ publishFilterButton.click(); }

    public void clickCloneActionButton(){ cloneActionButton.click(); }

    public void verifyTopMaterialIs(String materialType){ // should be changed this is not POM and PFM
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.textToBePresentInElement(firstMaterialHeading, materialType));
        System.out.println("The top material is " + firstMaterialHeading.getText());
    }

    public void clickActionsDropDown(){ actionsDropDown.click(); }

    public void clickDeleteDraftOption() { deleteDraftOption.click(); }

    public String getPressReleaseTitleText(){
        String text = pressReleaseTitle.getText();
        return text;
    }

    public void clickOnCodemoGlobalOption(){ codemoGlobalSelectOption.click(); }

    public void clickCloneButton(){ cloneButton.click(); }

    public void verifyPressReleaseCloned(String title){
        String titleTextV = getPressReleaseTitleText();
        Assert.assertEquals(titleTextV, title);
    }

    public void verifyAllZeroState(){
        String headingText = allZeroStateHeadingText.getText();
        String buttonText = allZeroStateCreateButton.getText();
        Assert.assertEquals(headingText, "You have no press releases created");
        ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"react-container\"]/div/div[2]/div[4]/ul/div/a"));
        Assert.assertEquals(buttonText, "Create new press release");
        System.out.println("Heading text is " + headingText);
    }

    public void verifyFilteredZeroState(String text){
        Assert.assertEquals(filteredZeroStateHeading.getText(), text);
    }




}
