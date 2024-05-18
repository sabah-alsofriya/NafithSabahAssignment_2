package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtpPage {
    WebDriver driver;
    By otpField = By.id("id_otp_digit");
    By submitOtpButton = By.cssSelector("button[type='submit']");

    public OtpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterOtp(String OTPInput) {
        driver.findElement(otpField).sendKeys(OTPInput);
    }
    public void clickSubmitOtp() {
        driver.findElement(submitOtpButton).click();
    }}
