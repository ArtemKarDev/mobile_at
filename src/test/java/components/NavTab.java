package components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import screens.HistoryScreen;
import screens.SearchScreen;

import static com.codeborne.selenide.Selenide.$x;

public class NavTab {

    private final SelenideElement
            exploreTab = $x("//android.widget.FrameLayout[@content-desc=\"Explore\"]"),
            historyTab = $x("//android.widget.FrameLayout[@content-desc=\"History\"]");


    @Step("Открыть вкладку Исследовать")
    public SearchScreen openExploreTab(){
        exploreTab.click();
        return new SearchScreen();
    }
    @Step("Открыть историю")
    public HistoryScreen openHistoryTab(){
        historyTab.click();
        return new HistoryScreen();
    }




}
