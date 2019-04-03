package pageObjects.pressOfficerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PressReleaseWizardPage {

    WebDriver driver;


    public PressReleaseWizardPage(WebDriver driver) { this.driver = driver; }

    @FindBy(how = How.ID, using = "item_header")
    WebElement pressReleaseHeaderField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"item_update_form\"]/div[1]/div[1]/div/div[2]/div[4]/div[2]/div")
    WebElement pressReleaseBodyField;



}
