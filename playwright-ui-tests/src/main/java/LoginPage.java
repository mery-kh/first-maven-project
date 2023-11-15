import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String email, String password) {
        page.navigate("http://77.50.236.203:4881/");
        page.fill("input[name='email']", email);
        page.fill("input[name='password']", password);
        page.click(".btn-primary");
        page.waitForTimeout(3000);
        page.reload();
    }
}
