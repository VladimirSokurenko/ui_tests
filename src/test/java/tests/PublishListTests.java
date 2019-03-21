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
import pageObjects.UserSignInPage;
import pageObjects.pressOfficerPages.DashboardPage;
import pageObjects.pressOfficerPages.PressReleasesPage;
import pageObjects.pressOfficerPages.PressRoomsPage;

public class PublishListTests extends WebDriverSetUp {

    @Test(priority = 1, description = "login as Press Officer")
    public void logInAsPressOfficer(){
        UserSignInPage userSignInPage = PageFactory.initElements(driver, UserSignInPage.class);
        PressRoomsPage pressRoomsPage = PageFactory.initElements(driver, PressRoomsPage.class);
        openBrowser("https://www.mynewsdesk.com/user/signin");
        userSignInPage.fillInUsername("vladimir.s");
        userSignInPage.fillInPassword("vladimir2019");
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

    @Test(priority = 4, description = "apply published filter")
    public void applyPublishedFilter(){
        PressReleasesPage pressReleasesPage = PageFactory.initElements(driver, PressReleasesPage.class);
        navigateToThePressReleasesPage();
        pressReleasesPage.clickOnFilterButton();
        pressReleasesPage.choosePublishOption();
        pressReleasesPage.verifyFilterText("Showing: published");
        pressReleasesPage.verifyTopMaterialIs("PUBLISHED");
    }

    @Test(priority = 4, description = "apply published filter")
    public void applyScheduledFilter(){
        PressReleasesPage pressReleasesPage = PageFactory.initElements(driver, PressReleasesPage.class);
        navigateToThePressReleasesPage();
        pressReleasesPage.clickOnFilterButton();
        pressReleasesPage.chooseSecheduledOption();
        pressReleasesPage.verifyFilterText("Showing: scheduled");
        pressReleasesPage.verifyTopMaterialIs("SCHEDULED");
    }

}
