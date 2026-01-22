package tests;

import components.NavTab;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.HistoryScreen;
import screens.OnboardingScreen;
import screens.SearchScreen;

public class HistoryTests extends TestBase {

    OnboardingScreen onboardingScreen;
    SearchScreen searchScreen;
    HistoryScreen historyScreen;
    ArticleScreen articleScreen;
    NavTab navTab;

    @Test
    @Tag("HistoryTests")
    public void testAddArticleHistory() {
        String searchTerm = "Appium";
        onboardingScreen = new OnboardingScreen();
        onboardingScreen.clickSkip();

        navTab = new NavTab();
        historyScreen = navTab.openHistoryTab();

        historyScreen.clearHistoryIfNotEmpty();

        //navTab = new NavTab();
        searchScreen = navTab.openExploreTab();

        articleScreen = searchScreen.openSearch()
                .typeSearch(searchTerm)
                .verifyResultsArePresent()
                .clickFirstResult()
                .verifyErrorOpenedArticle();

        searchScreen = articleScreen.clickGoBackButton().clickGoBack();
        historyScreen = navTab.openHistoryTab();
        historyScreen.checkArticleInHistory(searchTerm);
    }

}
