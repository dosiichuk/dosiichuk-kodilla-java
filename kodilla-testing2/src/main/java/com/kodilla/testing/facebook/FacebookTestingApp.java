package com.kodilla.testing.facebook;

import com.kodilla.testing.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class FacebookTestingApp {
    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/r.php?entry_point=login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the div with aria-label and click it
            WebElement allowCookies = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]")
            ));
            allowCookies.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Allow Cookies button not found or already handled.");
        }
        WebElement monthDropdown = driver.findElement(By.name("birthday_month")); // Replace with actual id/name
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText("May"); // or selectByValue("5")

        WebElement dayDropdown = driver.findElement(By.name("birthday_day"));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByVisibleText("15");

        WebElement yearDropdown = driver.findElement(By.name("birthday_year"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText("1995");

//        driver.quit();

    }
}
