import com.microsoft.playwright.*;
import java.nio.file.Paths;
import static com.codeborne.selenide.Selenide.*;

public class CreateHouseTest {
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
        //to store our auth info in json file
//        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("ui-tests/applogin.json")));
        page.reload();
        page.click("#basic-nav-dropdown:text('Houses')");
        page.locator("a[href='#/create/house']").first().elementHandle().click();
        page.fill("#floor_send", "2");
        page.fill("#price_send", "44444");
        page.fill("#parking_first_send", "0");
        page.fill("#parking_second_send", "1");
        page.fill("#parking_third_send", "0");
        page.fill("#parking_fourth_send", "1");
        page.locator(".tableButton").click();
        sleep(5000);
        browser.close();


        //seledide+playwright
//        Configuration.browser = "chrome"; // or your preferred browser
//        Configuration.baseUrl = "http://77.50.236.203:4881"; // Replace with your target URL
//        open("/");
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch();
//            BrowserContext browserContext = browser.newContext();
//            Page page = browserContext.newPage();
//            page.navigate("http://77.50.236.203:4881");
//            page.fill("input[name='email']", "user@pflb.ru");
//            page.fill("input[name='password']", "user");
//            page.click(".btn-primary");
//            page.waitForTimeout(3000);
//            browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("ui-tests/applogin.json")));
//            page.reload();
//            page.click("#basic-nav-dropdown:text('Houses')");
//            page.locator("a[href='#/create/house']").first().elementHandle().click();
//            page.fill("#floor_send", "4");
//            page.fill("#price_send", "888888888888");
//            page.fill("#parking_first_send", "0");
//            page.fill("#parking_second_send", "1");
//            page.fill("#parking_third_send", "0");
//            page.fill("#parking_fourth_send", "1");
//            page.locator(".tableButton").click();
//            sleep(5000);
//            page.close();
//            browserContext.close();
//            browser.close();
//        }
    }
}