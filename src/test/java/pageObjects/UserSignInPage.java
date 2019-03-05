package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserSignInPage {

    WebDriver driver;

    public UserSignInPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(how = How.ID, using = "username")
    WebElement fieldUsername;

    @FindBy(how = How.ID, using = "password")
    WebElement fieldPassword;

    @FindBy(how = How.ID, using = "login-button")
    WebElement btnLogin;

    public void fillInUsername(String username){
        fieldUsername.sendKeys(username);
    }

    public void fillInPassword(String password){
        fieldPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        btnLogin.click();
    }




}
