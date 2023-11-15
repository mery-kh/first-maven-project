import com.microsoft.playwright.*;
public class DeleteHouseTest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("user@pflb.ru", "user");
        HouseDeletionPage houseDeletionPage = new HouseDeletionPage(page);
        houseDeletionPage.deleteHouse("574");
        browser.close();
    }
}