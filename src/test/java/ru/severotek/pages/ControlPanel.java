package ru.severotek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlPanel {

    private WebDriver driver;

    public ControlPanel(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[@class='dashboard-title']")
    private WebElement controlPanel;

    @FindBy(xpath = "//a[@href='/admin/blog/entry/add/']")
    private WebElement addButton;

    public String getTextControlPanel() {
        return controlPanel.getText();
    }

    /**
     * метод для нажатия кнопки добавить
     */
    public void pushAdd() {
        addButton.click();
    }

}

