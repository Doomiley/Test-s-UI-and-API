package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локаторов полей ввода
     */

    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement nextBtn;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwdField;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/span")
    private WebElement nextPassBtn;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]")
    private WebElement notNowBtn;

    /**
     * методы для ввода логина, пароля и осуществления нажатия кнопки входа в аккаунт
     */

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickNextBtn() {
        nextBtn.click();
    }

    public void clickNextPassBtn() {
        nextPassBtn.click();
    }

    public FeedPage clickLoginBtn() {
        notNowBtn.click();
        return new FeedPage(driver);
    }
}
