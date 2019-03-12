package pageObjects.journalistPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReaderStoriesPage {

    WebDriver driver;

    public ReaderStoriesPage(WebDriver driver){ this.driver = driver;}

    /** page elements list */

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[1]/nav/div[3]/ul/li/button")
    WebElement logInLink;

    @FindBy(how = How.NAME, using = "email")
    WebElement emailField;

    @FindBy(how = How.NAME, using = "password")
    WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app-overlay\"]/div/div/div/article/div[2]/button[1]")
    WebElement logInButton;

    @FindBy(how = How.ID, using = "dropdown-1")
    WebElement myProfileLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[1]/nav/div[3]/ul/li/div/ul/li[8]/a")
    WebElement logOutLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[2]/div[1]/div[1]/div[1]/div/div/div/div/a/h2")
    WebElement newsroomHeading;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[2]/div[1]/div[1]/div[1]/div/div/button")
    WebElement followNewsButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[1]/nav/div[2]/div/ul/li[2]/a")
    WebElement subscriptionsSection;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[2]/nav/div/ul/li[1]/a")
    WebElement alertsSubMenuSection;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[2]/nav/div/ul/li[2]/a")
    WebElement companiesSubSection;
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[2]/nav/div/ul/li[2]/a")
    WebElement followingSubMenuSection;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[3]/div/div/div/div/a[2]/h1")
    WebElement followedNewsroomHeading;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[3]/div/div/div/button")
    WebElement followingButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[3]/div/div/p")
    WebElement zeroStateTextSubscriptions;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[3]/div/div/div")
    WebElement followedNewsroomCard;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-select-2--option-0\"]")
    WebElement artTag;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-select-2--value\"]/div[1]")
    WebElement topicsTagInputField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[3]/div[1]/div[1]/div/button")
    WebElement followCompanyButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[3]/div[2]/button")
    WebElement createAlertButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app-overlay\"]/div/div/article/div[1]/h1")
    WebElement alertFormHeading;






    /** page methods */

    public void clickLoginLink(){ logInLink.click();}

    public void fillInEmailField(String email){emailField.sendKeys(email);}

    public void fillInPasswordField(String password){passwordField.sendKeys(password);}

    public void clickLogInButton(){logInButton.click(); }

    public void clickMyProfileLink(){ myProfileLink.click();}

    public void checkIfLogoutPresent(){
        Assert.assertEquals(logOutLink.getText(), "Log out");
    }

    public void clickLogoutButton(){ logOutLink.click();}

    public String getNewsroomHeadingText(){
        String headingText = newsroomHeading.getText();
        return headingText;
    }

    public void clickFollowNewsButton(){ followNewsButton.click(); }

    public void ifButtonFollowing(){
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.textToBePresentInElement(followNewsButton,"Following"));
        System.out.println("Following the newsroom");

    }

    public void checkIfUserLoggedOut(){
        Assert.assertEquals(logInLink.getText(), "Log in");
    }

    public void clickOnSubscriptionsSection(){ subscriptionsSection.click(); }

    public void clickOnFollowingSection(){ followingSubMenuSection.click(); }

    public void verifySubscriptionsSectionIsReached(){
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.visibilityOf(alertsSubMenuSection));
        wait.until(ExpectedConditions.visibilityOf(followingSubMenuSection));
        System.out.println("Subscriptions section is reached");
    }

    public void checkIfNewsroomFollowed(String companyName){
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.textToBePresentInElement(followedNewsroomHeading, companyName));
        System.out.println("Followed company is present");
    }

    public void clickOnFollowingButton(){
        followingButton.click();
        System.out.println("Click un-follow button");
    }

    public void checkIfSubscriptionsZeroStateIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.textToBePresentInElement(zeroStateTextSubscriptions, "You are not following any company or organization."));
        System.out.println("Zero state is displayed");
    }

    public void selectArtTopicTag(){
        topicsTagInputField.click();
        artTag.click();
        System.out.println("Search with Art tag has been executed");
    }

    public void navigateToCompaniesSubSection(){ companiesSubSection.click(); }

    public void clickFollowCompanyButton(){ followCompanyButton.click();}

    public void checkIfCompanyButtonFollowed(){
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.textToBePresentInElement(followCompanyButton,"Following"));
        System.out.println("Following the company");
    }

    public void clickOnTurnThisIntoAnAlertButton(){ createAlertButton.click(); }

    public void verifyAlertCreationFormIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.textToBePresentInElement(alertFormHeading,"Save new alert"));
        System.out.println("Alert creation form is opened");
    }







}
