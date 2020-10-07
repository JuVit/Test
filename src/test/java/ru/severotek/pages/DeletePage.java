package ru.severotek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePage {
    private WebDriver driver;

    public DeletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement deleteBtn;

    public void clickDeleteBtn() {
        deleteBtn.click();
    }

}
