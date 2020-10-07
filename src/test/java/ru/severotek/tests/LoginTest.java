package ru.severotek.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.severotek.ConfProperties;
import ru.severotek.DriverConfigurator;
import ru.severotek.pages.*;

import java.util.Random;


public class LoginTest extends DriverConfigurator {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //проверяем заголовок
        ControlPanel controlPanel = new ControlPanel(driver);
        Assert.assertEquals(
                "Заголовок не совпадает с ожидаемым",
                "Панель управления",
                controlPanel.getTextControlPanel());


        //нажимаем кнопку добавить
        controlPanel.pushAdd();

        EntryPage entryPage = new EntryPage(driver);
        //проверка заголовка
        Assert.assertEquals(
                "Заголовок не совпадает с ожидаемым",
                "Добавить entry",
                entryPage.getTextTitle());

        //заполнение полей

        int random = new Random().nextInt(10000000);
        String newTitle = "Title" + random;
        String newSlug = "Slug" + random;
        entryPage.inputTitle(newTitle);
        entryPage.inputSlug(newSlug);
        entryPage.inputTextMarkdown(newSlug);
        entryPage.inputText(newSlug);
        //нажимаем кнопку сохранить
        entryPage.clickSaveBtn();
        //переход на страницу
        goToUrl(ConfProperties.getProperty("url") + "admin/blog/");
        BlogPage blogPage = new BlogPage(driver);
        //проверка
        Assert.assertTrue("Запись не появилась", blogPage.isAddEntryVisible(newTitle));
        blogPage.clickByAddEntry(newTitle);

        entryPage.clickDeleteBtn();

        DeletePage deletePage = new DeletePage(driver);
        deletePage.clickDeleteBtn();

    }


}
