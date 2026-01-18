package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import components.NavTab;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchScreen {

    NavTab navTab = new NavTab();
    private final SelenideElement
            searchBanner = $(accessibilityId("Search Wikipedia")),
            searchInput = $(id("org.wikipedia.alpha:id/search_src_text")),
            searchResultFirstItem = $(id("org.wikipedia.alpha:id/page_list_item_title"));

        private final ElementsCollection searchResultItems = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Открыть поиск")
    public SearchScreen openSearch() {
        searchBanner.click();
        return this;
    }

    @Step("Ввести запрос: {term}")
    public SearchScreen typeSearch(String term) {
        searchInput.click();
        searchInput.sendKeys(term);
        return this;
    }

    @Step("Кликнуть по первому результату")
    public ArticleScreen clickFirstResult() {
        searchResultFirstItem.click();
        return new ArticleScreen();
    }

    @Step("Проверить, что результаты поиска отобразились")
    public SearchScreen verifyResultsArePresent() {
        int size = searchResultItems.size();
        assertThat(size)
                .withFailMessage("Результаты поиска не найдены. Ожидалось > 0, найдено: %d", size)
                .isGreaterThan(0);
        return this;
    }

    @Step("Проверить, что заголовок первой найденой статьи — {expectedTitle}")
    public SearchScreen verifyTitleIs(String expectedTitle) {
        searchResultItems.get(0)
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText(expectedTitle));
        return this;
    }

    @Step("Открыть вкладку истории поиска")
    public HistoryScreen openHistory() {
        navTab.openHistory();
        return new HistoryScreen();
    }

}
