package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.Credentials;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationFormData;
import pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static helpers.Attach.getSessionId;
import static helpers.GetProperty.readProperty;

public class TestWithPageObject {

    @BeforeAll
    static void setUpConfig() {
        String login = Credentials.credentials.login();
        String password = Credentials.credentials.password();
        String server = readProperty();
        //Configuration.remote = "https://"+login+":"+pass+"@"+server+"/wd/hub/";
        Configuration.remote = String.format("https://%s:%s@%s/wd/hub",login,password,server);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;



    }

    @Test
    void selenideSearchTest() {

        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        RegistrationFormData registrationFormData = new RegistrationFormData();
        registrationFormPage.fillForm(registrationFormData);
        registrationFormPage.checkForm(registrationFormData);

    }

    @AfterEach
    void closeBrowser() {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        closeWebDriver();
        Attach.addVideo(sessionId);
    }
}
