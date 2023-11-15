import com.microsoft.playwright.Page;
public class HouseDeletionPage {
    private final Page page;

    public HouseDeletionPage(Page page) {
        this.page = page;
    }

    public void deleteHouse(String house_id) {
        page.waitForTimeout(3000);
        page.navigate("http://77.50.236.203:4881/#/delete/all");
        page.locator("input >> nth=1").fill(house_id);
        String buttonSelector = String.format("button:has-text('%s')", "HOUSE");
        page.click(buttonSelector);
        page.waitForTimeout(5000);
    }
}
