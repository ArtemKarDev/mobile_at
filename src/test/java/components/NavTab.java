package components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import screens.ArticleScreen;
import screens.HistoryScreen;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class NavTab {

    private final SelenideElement
            exploreTab = $x("//android.widget.FrameLayout[@content-desc=\"Explore\"]"),
            myListsTab = $x("//android.widget.FrameLayout[@content-desc=\"My lists\"]"),
            historyTab = $x("//android.widget.FrameLayout[@content-desc=\"History\"]"),
            nearbyTab = $x("//android.widget.FrameLayout[@content-desc=\"Nearby\"]");


    @Step("Открыть историю")
    public HistoryScreen openHistory(){
        historyTab.click();
        return new HistoryScreen();
    }

}
