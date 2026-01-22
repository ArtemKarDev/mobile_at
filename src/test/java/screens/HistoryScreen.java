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
        yesClearHistoryButton = $(id("android:id/button1")),
        searchHistoryButton = $(id("org.wikipedia:id/menu_search_history")),
        searchHistoryInputField = $(id("org.wikipedia:id/search_src_text")),
        historyEmptyTitle = $(id("org.wikipedia:id/history_empty_title"));



    ElementsCollection historyTitles = $$(id("org.wikipedia:id/page_list_item_title"));

    @Step("Проверить отображение экрана истории")
    public HistoryScreen checkHistoryScreen(){
        if (titleHistoryScreen.isDisplayed()) {
            System.out.println("History screen is displayed");
            return this;
        } else {
            System.out.println("History screen is not displayed");
            return null;
        }
    }

    @Step("Очистить всю историю")
    public HistoryScreen clearHistory(){
        clearHistoryButton.click();
        yesClearHistoryButton.click();
        historyTitles.shouldHave(size(0));
        return this;
    }

    @Step("Проверить отображениие сообщения об отсутствии статей в истории")
    public HistoryScreen checkEmptyHistoryTitle(){
        historyEmptyTitle.shouldBe(Condition.visible);
        historyTitles.shouldHave(size(0));
        return this;
    }

    @Step("Если история не пуста - очистить историю")
    public HistoryScreen clearHistoryIfNotEmpty(){
        if (historyEmptyTitle.is(Condition.visible)) {
            System.out.println("History is empty");
        } else {
            System.out.println("History not empty, clearing");
            clearHistoryButton.click();
            historyEmptyTitle.shouldBe(Condition.visible);
        }
        return this;
    }

    @Step("Проверить, что в истории есть статья")
    public HistoryScreen checkArticleInHistory(String article){
        historyEmptyTitle.shouldNotBe(Condition.visible);
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
