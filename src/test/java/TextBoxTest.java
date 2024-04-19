import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Deez Nuts");
        $("#userEmail").setValue("scoobydoo@mail.ru");
        $("#currentAddress").setValue("USA, CA, Beverly Hills, 90210");
        $("#permanentAddress").setValue("USA, Texas");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Deez Nuts"));
        $("#output").$("#email").shouldHave(text("scoobydoo@mail.ru"));
        $("#output").$("#currentAddress").shouldHave(text("USA, CA, Beverly Hills, 90210"));
        $("#output").$("#permanentAddress").shouldHave(text("USA, Texas"));

    }
}
