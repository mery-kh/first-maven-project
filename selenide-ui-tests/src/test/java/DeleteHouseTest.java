import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

public class DeleteHouseTest {
    public static void main(String[] args) {
        Configuration.headless = false;
        LoginPage loginPage = new LoginPage();
        loginPage.login("user@pflb.ru", "user");
        HouseDeletionPage houseDeletionPage = new HouseDeletionPage();
        houseDeletionPage.deleteHouse("578");
        closeWebDriver();
    }
}
