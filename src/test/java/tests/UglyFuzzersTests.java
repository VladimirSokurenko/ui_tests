package tests;

import driverSetUp.WebDriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Arrays;

public class UglyFuzzersTests extends WebDriverSetUp {

    String[] dangerStrings = new String[]{
           // "₀₁₂",
            //"⁰⁴⁵",
            //"  ₀₁₂",
            //"ด้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็็็็้้้้้็็็็ ด้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็็็็้้้้้็็็็ ด้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็็็็้้้้้็็็็",
            "'",
            //"<foo val=“bar” />",
            //"<foo val=“bar” />",
            //"<foo val=”bar“ />",
            //"<foo val=`bar' />",
            "表ポあA鷗ŒéＢ逍Üßªąñ丂㐀",
            "(｡◕ ∀ ◕｡)",
            ",。・:*:・゜’( ☻ ω ☻ )。・:*:・゜’",
            //"❤️ \uD83D\uDC94 \uD83D\uDC8C \uD83D\uDC95 \uD83D\uDC9E \uD83D\uDC93 \uD83D\uDC97 \uD83D\uDC96 \uD83D\uDC98 \uD83D\uDC9D \uD83D\uDC9F \uD83D\uDC9C \uD83D\uDC9B \uD83D\uDC9A \uD83D\uDC99",
            //"\uD83C\uDDFA\uD83C\uDDF8\uD83C\uDDF7\uD83C\uDDFA\uD83C\uDDF8\uD83C\uDDE6\uD83C\uDDEB\uD83C\uDDE6\uD83C\uDDF2",
            //"\uD835\uDD4B\uD835\uDD59\uD835\uDD56 \uD835\uDD62\uD835\uDD66\uD835\uDD5A\uD835\uDD54\uD835\uDD5C \uD835\uDD53\uD835\uDD63\uD835\uDD60\uD835\uDD68\uD835\uDD5F \uD835\uDD57\uD835\uDD60\uD835\uDD69 \uD835\uDD5B\uD835\uDD66\uD835\uDD5E\uD835\uDD61\uD835\uDD64 \uD835\uDD60\uD835\uDD67\uD835\uDD56\uD835\uDD63 \uD835\uDD65\uD835\uDD59\uD835\uDD56 \uD835\uDD5D\uD835\uDD52\uD835\uDD6B\uD835\uDD6A \uD835\uDD55\uD835\uDD60\uD835\uDD58",
            "⒯⒣⒠ ⒬⒰⒤⒞⒦ ⒝⒭⒪⒲⒩ ⒡⒪⒳ ⒥⒰⒨⒫⒮ ⒪⒱⒠⒭ ⒯⒣⒠ ⒧⒜⒵⒴ ⒟⒪⒢",
            "Ｔｈｅ ｑｕｉｃｋ ｂｒｏｗｎ ｆｏｘ ｊｕｍｐｓ ｏｖｅｒ ｔｈｅ ｌａｚｙ ｄｏｇ",
            "ABC<div style=\"x\\x3Aexpression(javascript:alert(1)\">DEF",
            "ABC<div style=\"x:expression\\x5C(javascript:alert(1)\">DEF",
            "ABC<div style=\"x:expression\\x00(javascript:alert(1)\">DEF",
            "ABC<div style=\"x:exp\\x00ression(javascript:alert(1)\">DEF",
            "<a href=\"\\xE1\\xA0\\x8Ejavascript:javascript:alert(1)\" id=\"fuzzelement1\">test</a>",
            "<a href=\"\\x0Bjavascript:javascript:alert(1)\" id=\"fuzzelement1\">test</a>",
            "`\"'><img src=xxx:x \\x09onerror=javascript:alert(1)>",
            "<img src=x\\x13onerror=\"javascript:alert(1)\">",
            "SRC=&#106;&#97;&#118;&#97;&#115;&#99;&#114;&#105;&#112;&#116;&#58;&#97;&#108;&#101;&#114;&#116;&#40;&#39;&#88;&#83;&#83;&#39;&#41;>",
            "\\\";alert('XSS');//",
            "http://a/%%30%30",
            "--version",
            "--help",
            "Powerلُلُصّبُلُلصّبُررً ॣ ॣh ॣ ॣ冗",
    };

    @Test(priority = 5)
    public void createPressRelease() throws InterruptedException{
        String baseUrlProduction = "https://www.mynewsdesk.com/user/signin";
        driver.get(baseUrlProduction);
        driver.findElement(By.id("username")).sendKeys("vova_sloboda_po");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("123123qwe");
        passwordField.submit();
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[2]/div/section/table/tbody/tr[2]/td/a")).click();
        driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[1]/div/span")).click();
        driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[1]/div/div/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[2]/div[3]/a")).click();
        for (int i = 1; i <= 10; i++) {
            String name = "Auto Press Release " + i;
            driver.findElement(By.id("item_header")).sendKeys(name);
            driver.findElement(By.xpath("//*[@id=\"item_update_form\"]/div[1]/div[1]/div/div[2]/div[4]/div[2]/div")).sendKeys(name);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"save_button\"]")));
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id=\"save_button\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"item_update_form\"]/div[2]/div[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"submit_button\"]")));
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id=\"submit_button\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"submit-confirm-yes\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[2]/div[3]/a")).click();
//            if(verifyElementPresent("//*[@id=\"analyze-modal-close-button\"]")) {
//                driver.findElement(By.xpath("//*[@id=\"analyze-modal-close-button\"]")).click();
//                driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[2]/div[3]/a")).click();
//            } else {
//                driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[2]/div[3]/a")).click();
//            }
//        }
        }
    }

    @Test(priority = 1, description = "primitive fuzzer for press release")
    public void pressReleasesFuzzer() throws InterruptedException {
        String baseUrlProduction = "https://www.mynewsdesk.com/user/signin";
        driver.get(baseUrlProduction);
        driver.findElement(By.id("username")).sendKeys("vova_sloboda_po");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("123123qwe");
        passwordField.submit();
        driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[1]/div/span/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[1]/div/div/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/div/a")).click();
        for (int i = 0; i <= dangerStrings.length ; i++) {
            String name = dangerStrings[i];
            driver.findElement(By.id("item_header")).sendKeys(name);
            driver.findElement(By.xpath("//*[@id=\"item_summary\"]")).sendKeys(name);
            driver.findElement(By.xpath("//*[@id=\"item_update_form\"]/div[1]/div[1]/div/div[2]/div[4]/div[2]/div")).sendKeys(name);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"save_button\"]")));
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id=\"save_button\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"item_update_form\"]/div[2]/div[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"submit_button\"]")));
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id=\"submit_button\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"submit-confirm-yes\"]")).click();
            if(verifyElementPresent("//*[@id=\"analyze-modal-close-button\"]")) {
                driver.findElement(By.xpath("//*[@id=\"analyze-modal-close-button\"]")).click();
                driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div[1]/div/a")).click();
            } else {
                driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div[1]/div/a")).click();
            }
        }
    }

    @Test()
    public void sendMessages() throws InterruptedException {
        driver.get("https://www.mnd-staging.com/user/signin");
        driver.findElement(By.id("username")).sendKeys("vladimir_codemo_po");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("123123qwe");
        passwordField.submit();
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[2]/div/section/table/tbody/tr[1]/td/a")).click();
        driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[2]/div/span")).click();
        driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[2]/div/div/div/a[5]")).click();
        for (int i = 0; i <20 ; i++) {
            String count = Integer.toString(i);
            driver.findElement(By.xpath("//*[@id=\"message-recipients-lists\"]")).click();
            //*[@id="app-message"]/div[4]/div[1]/div/div[1]/span/span/div/ul/li[3]/a
            driver.findElement(By.xpath("//*[@id=\"app-message\"]/div[4]/div[1]/div/div[1]/span/span/div/ul/li[3]/a")).click();
            driver.findElement(By.id("message-form-subject")).sendKeys("test credits" + count);
            driver.findElement(By.id("message-form-msg")).sendKeys("test credits" + count);
            driver.findElement(By.xpath("//*[@id=\"app-message\"]/div[3]/div[1]/div/div[7]/button[1]")).click();
            Thread.sleep(2000);
        }
    }


    @Test()
    public void testForce() throws InterruptedException {
        openBrowser("https://zoogen.ua");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/header/div[1]/div[2]/div[4]/a")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div/div/input")).sendKeys("06316389591");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
        Thread.sleep(1000);
        for (int i = 1000; i <10000 ; i++) {
            String input = Integer.toString(i);
            String test = "//*[@id=\"login-form_2\"]/div/input";
            driver.findElement(By.xpath("//*[@id=\"login-form_2\"]/div/input")).sendKeys(input);
            driver.findElement(By.xpath("//*[@id=\"login-form_2\"]/div/input")).submit();
           // driver.findElement(By.xpath("//*[@id=\"login-form_2\"]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"login-form_2\"]/div/input")).clear();
           if(verifyElementPresent(test)){
               driver.findElement(By.xpath("//*[@id=\"login-form_2\"]/div/input")).sendKeys(input);
               driver.findElement(By.xpath("//*[@id=\"login-form_2\"]/div/input")).submit();
               // driver.findElement(By.xpath("//*[@id=\"login-form_2\"]/button")).click();
               driver.findElement(By.xpath("//*[@id=\"login-form_2\"]/div/input")).clear();
           } else {
               Thread.sleep(10000);
           }
            System.out.println(i);
        }
        Thread.sleep(10000);

    }


}
