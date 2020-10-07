package ru.severotek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {

    private WebDriver driver;

    private static String entryXpath = "//a[@class=' addlink' and contains(text(),'%s')]";

    public BlogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean isAddEntryVisible(String entry) {
        String xpath = String.format(entryXpath, entry);
        WebElement webElement = driver.findElement(By.xpath(xpath));
        return webElement.isDisplayed();
    }

    public void clickByAddEntry(String entry) {
        String xpath = String.format(entryXpath, entry);
        WebElement webElement = driver.findElement(By.xpath(xpath));
        webElement.click();
    }
}
