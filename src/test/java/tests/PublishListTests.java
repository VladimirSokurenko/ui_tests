package tests;

import driverSetUp.WebDriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import pageObjects.UserSignInPage;
import pageObjects.pressOfficerPages.DashboardPage;
import pageObjects.pressOfficerPages.PressReleasesPage;
import pageObjects.pressOfficerPages.PressRoomsPage;

public class PublishListTests extends WebDriverSetUp {

    final static String USERNAME = "vladimir.s";
    final static String PASSWORD = "vladimir2019";
    final static String BASE_URL = "https://www.mynewsdesk.com/user/signin";

    @Test(priority = 1, description = "login as Press Officer")
    public void logInAsPressOfficer(){
        UserSignInPage userSignInPage = PageFactory.initElements(driver, UserSignInPage.class);
        PressRoomsPage pressRoomsPage = PageFactory.initElements(driver, PressRoomsPage.class);
        openBrowser(BASE_URL);
        userSignInPage.fillInUsername(USERNAME);
        userSignInPage.fillInPassword(PASSWORD);
        userSignInPage.clickLoginButton();
        pressRoomsPage.verifyManageUsersButtonIsPresent();
    }

    @Test(priority = 2, description = "navigate to the press room")
    public void navigateToThePressRoom(){
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        PressRoomsPage pressRoomsPage = PageFactory.initElements(driver, PressRoomsPage.class);
        logInAsPressOfficer();
        pressRoomsPage.navigateToSEPressRoom();
        dashboardPage.verifyDashboardSection();
        dashboardPage.verifyUrl();
    }

    @Test(priority = 3, description = "navigate to the Press Releases section")
    public void navigateToThePressReleasesPage() {
        navigateToThePressRoom();
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        PressReleasesPage pressReleasesPage = PageFactory.initElements(driver, PressReleasesPage.class);
        dashboardPage.clickOnPublishDropDown();
        dashboardPage.clickOnPressReleasesOption();
        pressReleasesPage.verifyFilterButtonIsPresent();
    }

    @Test(priority = 4, description = "apply draft filter")
    public void applyDraftFilter(){
        PressReleasesPage pressReleasesPage = PageFactory.initElements(driver, PressReleasesPage.class);
        navigateToThePressReleasesPage();
        pressReleasesPage.clickOnFilterButton();
        pressReleasesPage.chooseDraftOption();
        pressReleasesPage.verifyFilterText("Showing: draft");
        pressReleasesPage.verifyTopMaterialIs("DRAFT");
    }

    @Test(priority = 5, description = "apply published filter")
    public void applyPublishedFilter(){
        PressReleasesPage pressReleasesPage = PageFactory.initElements(driver, PressReleasesPage.class);
        navigateToThePressReleasesPage();
        pressReleasesPage.clickOnFilterButton();
        pressReleasesPage.choosePublishOption();
        pressReleasesPage.verifyFilterText("Showing: published");
        pressReleasesPage.verifyTopMaterialIs("PUBLISHED");
    }

    @Test(priority = 6, description = "apply scheduled filter")
    public void applyScheduledFilter(){
        PressReleasesPage pressReleasesPage = PageFactory.initElements(driver, PressReleasesPage.class);
        navigateToThePressReleasesPage();
        pressReleasesPage.clickOnFilterButton();
        pressReleasesPage.chooseScheduledOption();
        pressReleasesPage.verifyFilterText("Showing: scheduled");
        pressReleasesPage.verifyTopMaterialIs("SCHEDULED");
    }

    @Test(priority = 7, description = "clone DRAFT press release")
    public void cloneDraftPressRelease() throws InterruptedException{
        PressReleasesPage pressReleasesPage = PageFactory.initElements(driver, PressReleasesPage.class);
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        navigateToThePressReleasesPage();
        String pressReleaseTitle = pressReleasesPage.getPressReleaseTitleText();
        System.out.println("title is: " + pressReleaseTitle);
        scrollPageDown("1000");
        pressReleasesPage.clickActionsDropDown();
        pressReleasesPage.clickCloneActionButton();
        pressReleasesPage.checkFirstNewsRoomCheckBox();
        pressReleasesPage.clickCloneButton();
        pressReleasesPage.verifyToasterText(pressReleaseTitle);
        scrollPageDown("-1000");
        pressReleasesPage.clickOnNewsRoomSelector();
        pressReleasesPage.clickOnCodemoGlobalOption();
        dashboardPage.clickOnPublishDropDown();
        dashboardPage.clickOnPressReleasesOption();
        scrollPageDown("500");
        pressReleasesPage.verifyPressReleaseCloned(pressReleaseTitle);
    }

    @Test(priority = 8, description = "clone PUBLISHED press release")
    public void clonePublishedPressRelease() throws InterruptedException{
        PressReleasesPage pressReleasesPage = PageFactory.initElements(driver, PressReleasesPage.class);
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        navigateToThePressReleasesPage();
        pressReleasesPage.clickOnFilterButton();
        pressReleasesPage.choosePublishOption();
        String pressReleaseTitle = pressReleasesPage.getPressReleaseTitleText();
        System.out.println("title is: " + pressReleaseTitle);
        scrollPageDown("1000");
        pressReleasesPage.clickActionsDropDown();
        pressReleasesPage.clickCloneActionButton();
        pressReleasesPage.checkFirstNewsRoomCheckBox();
        pressReleasesPage.clickCloneButton();
        pressReleasesPage.verifyToasterText(pressReleaseTitle);
        scrollPageDown("-1000");
        pressReleasesPage.clickOnNewsRoomSelector();
        pressReleasesPage.clickOnCodemoGlobalOption();
        dashboardPage.clickOnPublishDropDown();
        dashboardPage.clickOnPressReleasesOption();
        scrollPageDown("500");
        pressReleasesPage.verifyPressReleaseCloned(pressReleaseTitle);
    }

    @Test(priority = 9, description = "clone SCHEDULED press release")
    public void cloneScheduledPressRelease() throws InterruptedException{
        PressReleasesPage pressReleasesPage = PageFactory.initElements(driver, PressReleasesPage.class);
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        navigateToThePressReleasesPage();
        pressReleasesPage.clickOnFilterButton();
        pressReleasesPage.chooseScheduledOption();
        String pressReleaseTitle = pressReleasesPage.getPressReleaseTitleText();
        System.out.println("title is: " + pressReleaseTitle);
        scrollPageDown("1000");
        pressReleasesPage.clickActionsDropDown();
        pressReleasesPage.clickCloneActionButton();
        pressReleasesPage.checkFirstNewsRoomCheckBox();
        pressReleasesPage.clickCloneButton();
        pressReleasesPage.verifyToasterText(pressReleaseTitle);
        scrollPageDown("-1000");
        pressReleasesPage.clickOnNewsRoomSelector();
        pressReleasesPage.clickOnCodemoGlobalOption();
        dashboardPage.clickOnPublishDropDown();
        dashboardPage.clickOnPressReleasesOption();
        scrollPageDown("500");
        pressReleasesPage.verifyPressReleaseCloned(pressReleaseTitle);
    }



}
