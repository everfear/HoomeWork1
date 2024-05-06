package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeFormTest
{

    @BeforeAll
    static void beforeAll()
    {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";


    }

    @Test
    void fillFormTest()
    {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Deez");
        $("#lastName").setValue("Nuts");
        $("#userEmail").setValue("scoobydoo@mail.ru");
        $("#gender-radio-3").doubleClick();
        $("#userNumber").setValue("8974590871");
        $("#dateOfBirthInput").click();
        $(By.className("react-datepicker__month-select")).click();
        $(By.className("react-datepicker__month-select")).selectOption("July");
        $(By.className("react-datepicker__year-select")).click();
        $(By.className("react-datepicker__year-select")).selectOption("1913");
        $(byText("17")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").type("Biology").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("cat.webp");
        $("#currentAddress").setValue("USA, CA, Beverly Hills, 90210");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").click();

        $(By.className("table-responsive")).shouldHave(text("Deez Nuts"));
        $(By.className("table-responsive")).shouldHave(text("scoobydoo@mail.ru"));
        $(By.className("table-responsive")).shouldHave(text("Other"));
        $(By.className("table-responsive")).shouldHave(text("8974590871"));
        $(By.className("table-responsive")).shouldHave(text("17 July,1913"));
        $(By.className("table-responsive")).shouldHave(text("Biology"));
        $(By.className("table-responsive")).shouldHave(text("Sports, Reading"));
        $(By.className("table-responsive")).shouldHave(text("cat.webp"));
        $(By.className("table-responsive")).shouldHave(text("USA, CA, Beverly Hills, 90210"));
        $(By.className("table-responsive")).shouldHave(text("Haryana Karnal"));

        $("#closeLargeModal").click();

    }
}
