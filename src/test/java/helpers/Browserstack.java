package helpers;

import static io.restassured.RestAssured.given;


public class Browserstack {

//    curl -u "artemkarlashov_r6fMas:4YJqxHgbhFh6v7DgvMMS" -X GET "https://api.browserstack.com/app-automate/sessions/<session-id>.json"

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        String user = System.getProperty("browserstack.user");
        String key = System.getProperty("browserstack.key");
        if (user == null || key == null) {
            System.err.println("Error: JVM properties 'browserstack.user' and 'browserstack.key' are not set!");
            return null;
        }

        return given()
                .auth().basic(user, key)
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}