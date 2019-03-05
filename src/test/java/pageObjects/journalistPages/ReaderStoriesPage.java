package pageObjects.journalistPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[2]/nav/div/ul/li[2]/a")
    WebElement followingSubMenuSection;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[3]/div/div/div/div/a[2]/h1")
    WebElement followedNewsrommHeading;



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

    public void clickOnStoriesSection(){ subscriptionsSection.click(); }

    public void clickOnFollowingSection(){ followingSubMenuSection.click(); }

    public void checkIfNewsroomFollowed(String companyName){
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.textToBePresentInElement(followedNewsrommHeading, companyName));
        System.out.println("Followed company is present");
    }






}
