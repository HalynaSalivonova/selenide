package selenide.pages.Stylus;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class StylusMainPage {
    private SelenideElement search = $(By.name("q"));

    public StylusMainPage searchFor(String searchText) {
        search.val(searchText).pressEnter();
        return this;
    }
}