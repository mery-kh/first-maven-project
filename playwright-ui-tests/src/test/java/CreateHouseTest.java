import com.microsoft.playwright.*;
public class CreateHouseTest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("user@pflb.ru", "user");
        HouseCreationPage houseCreationPage = new HouseCreationPage(page);
        houseCreationPage.createHouse("2", "12343", "0", "1", "0", "1");
        browser.close();
    }
}
