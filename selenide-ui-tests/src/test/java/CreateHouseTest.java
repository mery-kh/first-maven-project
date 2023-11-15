import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

public class CreateHouseTest {
    public static void main(String[] args) {
        Configuration.headless = false;
        LoginPage loginPage = new LoginPage();
        loginPage.login("user@pflb.ru", "user");
        HouseCreationPage houseCreationPage = new HouseCreationPage();
        houseCreationPage.createHouse("2", "7766", "0", "1", "0", "1");
        closeWebDriver();
    }
}
