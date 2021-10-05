package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeedPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */

    public WebDriver driver;
    public FeedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора меню аккаунта
     */

    @FindBy(xpath = "//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a")
    private WebElement profileMenu;

    /**
     * определение локатора имени пользователя аккаунта
     */

    @FindBy(xpath = "//*[@id=\"gb\"]/div[2]/div[4]/div[1]/div[2]/div[2]")
    private WebElement profileName;

    /**
     * определение локатора кнопки выхода из аккаунта
     */

    @FindBy(xpath = "//*[@id=\"gb_71\"]")
    private WebElement logoutBtn;

    /**
     * метод для нажатия кнопки меню
     */

    public void userMenu() {
        profileMenu.click();
    }

    /**
     * метод для получения имени пользователя
     */

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String userName = profileName.getText();
        return userName;
    }

    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        logoutBtn.click();
    }
}
