package com.kodilla.testing.ebay;

import com.kodilla.testing.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayTestingApp {
    public static String name = "_nkw";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.ebay.pl");

        WebElement searchField = driver.findElement(By.name(name));
        searchField.sendKeys("laptop");
        searchField.submit();
    }
}
