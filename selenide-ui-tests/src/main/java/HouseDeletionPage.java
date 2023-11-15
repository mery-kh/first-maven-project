import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HouseDeletionPage {
    public void deleteHouse(String house_id) {
        sleep(3000);
        open("http://77.50.236.203:4881/#/delete/all");
        $$(".btn-group input").get(1).setValue(house_id);
        $$("button").findBy(text("HOUSE")).click();
        sleep(5000);
    }
}
