import com.microsoft.playwright.Page;
public class HouseCreationPage {
    private final Page page;

    public HouseCreationPage(Page page) {
        this.page = page;
    }

    public void createHouse(String floor, String price, String parking1, String parking2, String parking3, String parking4) {
        page.click("#basic-nav-dropdown:text('Houses')");
        page.locator("a[href='#/create/house']").first().elementHandle().click();
        page.fill("#floor_send", floor);
        page.fill("#price_send", price);
        page.fill("#parking_first_send", parking1);
        page.fill("#parking_second_send", parking2);
        page.fill("#parking_third_send", parking3);
        page.fill("#parking_fourth_send", parking4);
        page.locator(".tableButton").click();
        page.waitForTimeout(5000);
    }
}
