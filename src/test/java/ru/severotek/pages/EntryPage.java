package ru.severotek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryPage {
    private WebDriver driver;

    public EntryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement titleElement;

    @FindBy(xpath = "//*[contains(@id, 'id_title')]")
    private WebElement titleField;

    @FindBy(xpath = "//*[contains(@id, 'id_slug')]")
    private WebElement slugField;

    @FindBy(xpath = "//*[contains(@id, 'id_text_markdown')]")
    private WebElement textMarkdownField;

    @FindBy(xpath = "//*[contains(@id, 'id_text')]")
    private WebElement textField;

    @FindBy(xpath = "//*[contains(@class, 'default')]")
    private WebElement saveBtn;

    @FindBy(xpath = "//*[contains(@class, 'deletelink')]")
    private WebElement deleteBtn;

    public String getTextTitle() {
        return titleElement.getText();
    }

    public void inputTitle(String title) {
        titleField.sendKeys(title);
    }

    public void inputSlug(String slug) {
        slugField.sendKeys(slug);
    }

    public void inputTextMarkdown(String textMarkdown) {
        textMarkdownField.sendKeys(textMarkdown);
    }

    public void inputText(String text) {
        textField.sendKeys(text);
    }

    public void clickSaveBtn() {
        saveBtn.click();
    }

    public void clickDeleteBtn() {
        deleteBtn.click();
    }
}
