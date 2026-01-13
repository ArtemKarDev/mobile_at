package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.SearchScreen;

public class SearchTests extends TestBase {

    SearchScreen searchScreen;
    ArticleScreen articleScreen;

    @Test
    void successfulSearchTest2(){
        String searchTerm = "Appium";
        searchScreen = new SearchScreen();
        searchScreen.openSearch()
                .typeSearch(searchTerm)
                .verifyResultsArePresent()
                .verifyTitleIs(searchTerm);
    }

    @Test
    //@Tag("SearchTests")
    @Description("Проверка поисковой строки и вывода релевантного значения в поиске")
    void successfulOpenArticleTest(){
        String searchTerm = "Appium";
        searchScreen = new SearchScreen();
        articleScreen = searchScreen.openSearch()
                .typeSearch(searchTerm)
                .verifyResultsArePresent()
                .clickFirstResult();

        //articleScreen.verifyArticleTitleContains(searchTerm);
        articleScreen.verifyErrorOpenedArticle();
    }

}