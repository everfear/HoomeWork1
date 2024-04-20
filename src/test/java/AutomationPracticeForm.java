import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
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
        $(new ByText("17")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").type("Biology").pressEnter();
        $(new ByText("Sports")).click();
        $(new ByText("Reading")).click();
        $(By.className("form-file-label")).click();


        $("#currentAddress").setValue("USA, CA, Beverly Hills, 90210");
        $("#state").click();
        $(new ByText("Haryana")).click();
        $("#city").click();
        $(new ByText("Karnal")).click();



        $(By.cssSelector("react-datepicker__day react-datepicker__day--017")).click();

        $("#currentAddress").setValue("USA, CA, Beverly Hills, 90210");
        $("#currentAddress").setValue("USA, CA, Beverly Hills, 90210");
        $("#submit").click();

        $("#output #name").shouldHave(text("Deez Nuts"));
        $("#output #email").shouldHave(text("scoobydoo@mail.ru"));
        $("#output #currentAddress").shouldHave(text("USA, CA, Beverly Hills, 90210"));
        $("#output #permanentAddress").shouldHave(text("USA, Texas"));

    }

}
