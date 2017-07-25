package selenide.pages.Google;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchResultPage {
    private ElementsCollection linksResults = $$(".r>a");

    public ElementsCollection getLinksResults() {
        return linksResults;
    }
}