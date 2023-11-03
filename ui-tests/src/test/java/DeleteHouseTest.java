import com.microsoft.playwright.*;
import java.nio.file.Paths;
import static com.codeborne.selenide.Selenide.*;
public class DeleteHouseTest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("http://77.50.236.203:4881/");
        page.fill("input[name='email']", "user@pflb.ru");
        page.fill("input[name='password']", "user");
        page.click(".btn-primary");
        page.waitForTimeout(3000);
        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("ui-tests/applogin.json")));
        page.reload();
        page.waitForTimeout(3000);
        page.navigate("http://77.50.236.203:4881/#/delete/all");
       page.locator("input >> nth=1").fill("564");
        String buttonText = "HOUSE";
        String buttonSelector = String.format("button:has-text('%s')", buttonText);
        page.click(buttonSelector);
        sleep(5000);
        browser.close();
    }
}