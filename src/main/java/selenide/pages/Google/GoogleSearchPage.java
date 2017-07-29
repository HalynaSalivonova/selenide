package selenide.pages.Google;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class GoogleSearchPage extends AbstractPage{
    private SelenideElement search = $(By.name("q"));
    private String buttonSearch = "btnK";

//    @Step("Searches for \"Selenium\" text")
    @Step("Searches for {0} text")
    public GoogleSearchPage searchFor(String searchText) {
        search.val(searchText);
        jsClick(buttonSearch, "name");
//ретёрн, возрврати страницу (ссылку на обьект)
        return this;
    }
}