import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HouseCreationPage {
    public void createHouse(String floor, String price, String parking1, String parking2, String parking3, String parking4) {
        $$("#basic-nav-dropdown").findBy(text("Houses")).click();
        $("a[href='#/create/house']").click();
        $("#floor_send").setValue(floor);
        $("#price_send").setValue(price);
        $("#parking_first_send").setValue(parking1);
        $("#parking_second_send").setValue(parking2);
        $("#parking_third_send").setValue(parking3);
        $("#parking_fourth_send").setValue(parking4);
        $(".tableButton").click();
        sleep(5000);
    }
}
