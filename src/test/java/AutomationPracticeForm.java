import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm
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
        $(By.className("form-control-file")).uploadFile(new File("src/test/cat.webp"));
        $("#currentAddress").setValue("USA, CA, Beverly Hills, 90210");
        $("#state").click();
        $(new ByText("Haryana")).click();
        $("#city").click();
        $(new ByText("Karnal")).click();

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
