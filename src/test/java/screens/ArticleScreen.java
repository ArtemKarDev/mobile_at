package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class ArticleScreen {

    private final SelenideElement
            articleTitle = $(className("android.widget.TextView")),
            articleError = $(id("org.wikipedia.alpha:id/page_error"));

    @Step("Проверить, что заголовок открытой статьи — {expectedTitle}")
    public ArticleScreen verifyArticleTitleContains(String expectedTitle) {
        String actualTitle = articleTitle.getText();
        assertThat(actualTitle)
                .as("Проверка, что заголовок статьи содержит ожидаемое значение")
                .contains(expectedTitle);
        return this;
    }

    @Step("Ошибка при открытии статить")
    public ArticleScreen verifyErrorOpenedArticle() {
        assertThat(articleError.shouldBe(visible))
                .as("Проверка, что открыта ошибка");
        return this;
    }

}
