package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.BaseClass;

public class TestTC_001_AccountRegistration extends BaseClass {

    @Test
    public void registerTest() {
        driver.get(p.getProperty("base_url"));
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Shivani");
        driver.findElement(By.id("input-lastname")).sendKeys("K");
        driver.findElement(By.id("input-email")).sendKeys(p.getProperty("email_id"));
        driver.findElement(By.id("input-password")).sendKeys(p.getProperty("pswd"));
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }
}
