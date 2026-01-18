package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.SearchScreen;

import static com.codeborne.selenide.Selenide.back;

public class SearchTests extends TestBase {

    SearchScreen searchScreen;
    ArticleScreen articleScreen;

    @Test
    @Tag("SearchTests")
    @Description("Проверка поисковой строки и вывода релевантного значения в поиске")
    void successfulSearchTest(){
        String searchTerm = "Appium";
        searchScreen = new SearchScreen();
        searchScreen.openSearch()
                .typeSearch(searchTerm)
                .verifyResultsArePresent()
                .verifyTitleIs(searchTerm);
    }

    @Test
    @Tag("SearchTests")
    @Description("Проверка открытия найденой статьи")
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