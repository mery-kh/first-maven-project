import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.refresh;

public class LoginPage {
    public void login(String email, String password) {
        open("http://77.50.236.203:4881/");
        $("input[name='email']").setValue("user@pflb.ru");
        $("input[name='password']").setValue("user");
        $(".btn-primary").click();
        sleep(3000);
        refresh();
    }
}
