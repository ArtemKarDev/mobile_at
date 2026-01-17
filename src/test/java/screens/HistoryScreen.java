package screens;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class HistoryScreen {
    private final SelenideElement
        titleHistoryScreen = $("new UiSelector().text(\"History\").instance(1)"),
        clearHistoryButton = $(id("org.wikipedia:id/menu_clear_all_history")),
        searchHistoryButton = $(id("org.wikipedia:id/menu_search_history")),
        searchHistoryInputField = $(id("org.wikipedia:id/search_src_text"));

    ElementsCollection historyTitles = $$(id("org.wikipedia:id/page_list_item_title"));

    @Step("Очистить всю историю")
    public HistoryScreen clearHistory(){
        clearHistoryButton.click();
        historyTitles.shouldHave(size(0));
        return this;
    }

    @Step("Проверить, что в истории есть статья")
    public HistoryScreen checkArticleInHistory(String article){
        historyTitles.shouldHave(CollectionCondition.sizeGreaterThan(0));
        historyTitles.shouldHave(
                CollectionCondition.anyMatch("Статья присутствует в истории", historyTitle ->
                        historyTitle.getText().equalsIgnoreCase(article.trim())
                ));
        return this;
    }

    @Step("Ввести в поле поиска название статьи {article}")
    public HistoryScreen inputArticleInSearchHistory(String article){
        searchHistoryButton.click();
        searchHistoryInputField.setValue(article);
        return  this;
    }




}
