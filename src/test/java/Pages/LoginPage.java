package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By emailField = By.id("id_email");
    By passwordField = By.id("id_password");
    By loginButton = By.xpath("//button[contains(text(),'تسجيل الدخول')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterEmail(String usernameInput) {
        driver.findElement(emailField).sendKeys(usernameInput);
    }

    public void enterPassword(String PasswordInput) {
        driver.findElement(passwordField).sendKeys(PasswordInput);
    }


    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

}
