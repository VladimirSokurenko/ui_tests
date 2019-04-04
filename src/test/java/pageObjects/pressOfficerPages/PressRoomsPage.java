package pageObjects.pressOfficerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PressRoomsPage {

    WebDriver driver;

    public PressRoomsPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"wrapper\"]/div/div[2]/div/section/table/tbody/tr[10]/td/a/span")
    WebElement sePressRoom;

    @FindBy(how = How.XPATH, using = "//*[@id=\"wrapper\"]/div/div[1]/div/a")
    WebElement manageUsersButton;

    @FindBy(how = How.LINK_TEXT, using = "sloboda_studio_ua")
    WebElement slobodaPressRoom;

    public void navigateToSEPressRoom(){ sePressRoom.click(); }

    public void navigateToSlobodaUaPressRoom(){ slobodaPressRoom.click(); }

    public void verifyManageUsersButtonIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.elementToBeClickable(manageUsersButton));
        System.out.println("User navigate to the press room section");
    }
}
