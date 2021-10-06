package org.example;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        //значение login/password берутся из файла настроек conf.properties

        //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
        LoginPage loginPage = new LoginPage(driver);
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.clickNextBtn();
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("pass"));
        loginPage.clickNextPassBtn();
        //вызываем меню
        ProfilePage profilePage = loginPage.clickLoginBtn();
        profilePage.userMenu();
        //получаем отображаемый логин
        String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("email"), user);
    }

    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */

    @AfterClass
    public static void tearDown() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.userLogout();
        driver.quit();
    }
}