package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By privacyPolicy = By.name("agree");
    By continueBtn = By.xpath("//input[@value='Continue']");
    By successMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String fname) { driver.findElement(firstName).sendKeys(fname); }
    public void setLastName(String lname) { driver.findElement(lastName).sendKeys(lname); }
    public void setEmail(String mail) { driver.findElement(email).sendKeys(mail); }
    public void setTelephone(String phone) { driver.findElement(telephone).sendKeys(phone); }
    public void setPassword(String pwd) { driver.findElement(password).sendKeys(pwd); }
    public void setConfirmPassword(String pwd) { driver.findElement(confirmPassword).sendKeys(pwd); }
    public void acceptPrivacyPolicy() { driver.findElement(privacyPolicy).click(); }
    public void clickContinue() { driver.findElement(continueBtn).click(); }
    public boolean isRegistrationSuccess() { return driver.findElement(successMessage).isDisplayed(); }
}
