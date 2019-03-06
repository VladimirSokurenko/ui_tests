package tests;

import driverSetUp.WebDriverSetUp;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.journalistPages.ReaderStoriesPage;


public class ReaderPageJournalistTest extends WebDriverSetUp {

    /** variables for test */

    String toggledReaderPages = "https://www.mynewsdesk.com/stories?FEATURE_TOGGLE=beta-reader";
    String journalistUsername = "dnghoys";
    String journalistPassword = "123123qwe";

    /** tests */

    @Test(description = "as journalist I want to be able to login thought Reader page")
    public void loginTroughReaderPage(){
        ReaderStoriesPage readerStoriesPage = PageFactory.initElements(driver, ReaderStoriesPage.class);
        openBrowser(toggledReaderPages);
        readerStoriesPage.clickLoginLink();
        readerStoriesPage.fillInEmailField(journalistUsername);
        readerStoriesPage.fillInPasswordField(journalistPassword);
        readerStoriesPage.clickLogInButton();
        readerStoriesPage.clickMyProfileLink();
        readerStoriesPage.checkIfLogoutPresent();
        System.out.println("Journalist " +journalistUsername + " successfully logged in");
    }

    @Test(description = "as journalist I want to be able to logout thought Reader page")
    public void logoutTroughReaderPage(){
        ReaderStoriesPage readerStoriesPage = PageFactory.initElements(driver, ReaderStoriesPage.class);
        loginTroughReaderPage();
        readerStoriesPage.clickLogoutButton();
        readerStoriesPage.checkIfUserLoggedOut();
        System.out.println("Journalist " +journalistUsername + " successfully logged out");
    }

    @Test(description = "as journalist I want to be able to subscribe on newsroom trough newsroom feed")
    public void subscribeOnPressRoomTroughNewsFeed() {
        ReaderStoriesPage readerStoriesPage = PageFactory.initElements(driver, ReaderStoriesPage.class);
        loginTroughReaderPage();
        readerStoriesPage.clickFollowNewsButton();
        readerStoriesPage.ifButtonFollowing();
        readerStoriesPage.clickOnSubscriptionsSection();
        readerStoriesPage.verifySubscriptionsSectionIsReached();
        readerStoriesPage.clickOnFollowingSection();
        readerStoriesPage.clickOnFollowingButton();
        readerStoriesPage.checkIfSubscriptionsZeroStateIsPresent();
    }

    @Test(description = "as journalist I want to be able to subscribe on newsroom trough companies feed")
    public void subscribeOnPressRoomTroughCompaniesFeed(){
        ReaderStoriesPage readerStoriesPage = PageFactory.initElements(driver, ReaderStoriesPage.class);
        loginTroughReaderPage();
        readerStoriesPage.selectArtTopicTag();
        readerStoriesPage.navigateToCompaniesSubSection();
        readerStoriesPage.clickFollowCompanyButton();
        readerStoriesPage.checkIfCompanyButtonFollowed();
        readerStoriesPage.clickOnSubscriptionsSection();
        readerStoriesPage.verifySubscriptionsSectionIsReached();
        readerStoriesPage.clickOnFollowingSection();
        readerStoriesPage.clickOnFollowingButton();
        readerStoriesPage.checkIfSubscriptionsZeroStateIsPresent();
    }
}
