package tests;

import driverSetUp.WebDriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SeleniumTutorialTests extends WebDriverSetUp {


    final static String BASE_URL = "http://demo.guru99.com/test/newtours/";
    String flightsSection = "/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]";

    @Test(description = "selenium methods")
    public void seleniumTestesFeatures(){
        driver.get("http://output.jsbin.com/usidix/1");
        driver.findElement(By.xpath("/html/body/input")).click();
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("/html/body/input")).click();
        driver.switchTo().alert().dismiss();
        System.out.println(alertText);
    }

    @Test(description = "locators")
    public void locatorsTutorial(){
        driver.get(BASE_URL);
        /** using name locator */
        driver.findElement(By.name("userName")).sendKeys("userName");
        driver.findElement(By.name("password")).sendKeys("123123qwe");
        driver.findElement(By.name("submit")).click();
        /** using linkText locator */
        driver.findElement(By.linkText("Flights")).click();
        driver.findElement(By.linkText("SIGN-OFF")).click();
        driver.findElement(By.linkText("REGISTER")).click();

        /** Locating by CSS Selector - Tag and Attribute */
        driver.findElement(By.cssSelector("input[name=lastName]")).sendKeys("Sokurenko");
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys("1234567890");
    }

    @Test(description = "locators_2")
    public void locatorsTutorialTwo(){
        driver.get("http://demo.guru99.com/test/facebook.html");

        /** css selector - tag and id */
        driver.findElement(By.cssSelector("input#email")).sendKeys("vova");
        driver.findElement(By.cssSelector("input#email")).clear();

        /** css selector - tag and class
         * when using tag and class one thing
         * should be taken into account
         * that multiple elements can have
         * same tag and class, so only the
         * first element in the DOM will
         * be recognized*/
        driver.findElement(By.cssSelector("input.inputtext")).sendKeys("vova_2");

        /** Locating by CSS Selector - tag, class, and attribute
         * numbers should be specified in "" */
        driver.findElement(By.cssSelector("input.inputtext[tabindex=\"2\"]")).sendKeys("password");
        driver.findElement(By.cssSelector("input.inputtext[tabindex=\"2\"]")).clear();
        driver.findElement(By.cssSelector("input.inputtext[name=pass]")).sendKeys("password_two");
    }

    @Test(description = "select element")
    public void selectorsTutorial(){
        driver.get("http://demo.guru99.com/test/newtours/register.php");
        Select countrySelector = new Select(driver.findElement(By.name("country")));
        /** using select class methods */

        countrySelector.selectByVisibleText("ANDORRA");

        countrySelector.selectByIndex(67);

        countrySelector.selectByValue("RUSSIA");

        if(countrySelector.isMultiple()){
            System.out.println("multiple");
        } else {
            System.out.println("not multiple");
        }

        List<WebElement> selectorValues = countrySelector.getOptions();
        for (WebElement values : selectorValues ){
            System.out.println(values.getText());
        }




    }

}
