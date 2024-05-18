package test_Scenarios;

import Pages.LoginPage;
import Pages.OtpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.*;

public class NafithLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private OtpPage otpPage;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://staging.nafith.sa/accounts/login/company/");
        loginPage = new LoginPage(driver);
        otpPage = new OtpPage(driver);
    }

    @Test (priority = 1)
    public void testValidLogin(){
        loginPage.enterEmail("mohammad.j+46895@sitech.me");
        loginPage.enterPassword("Test@123456");
        loginPage.clickLogin();

        otpPage.enterOtp("111111");
        otpPage.clickSubmitOtp();

        String expectedUrl = "https://staging.nafith.sa/dashboard/sanad/";
        assertEquals(expectedUrl, driver.getCurrentUrl());
        driver.close();
    }

    @Test (priority = 2)
    public void testInvalidLogin() {
        setUp();
        loginPage.enterEmail("invalid@sitech.me");
        loginPage.enterPassword("WrongPassword");
        loginPage.clickLogin();

        assertTrue(driver.findElement(By.cssSelector("ul[class='m-0'] li")).isDisplayed());
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }}
