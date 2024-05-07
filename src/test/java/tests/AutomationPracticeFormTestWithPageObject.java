package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormTestPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeFormTestWithPageObject extends TestBase
{

    AutomationPracticeFormTestPage automationPracticeFormTestPage = new AutomationPracticeFormTestPage();

    @Test
    void fillFormTestWithPageObject()
    {

        automationPracticeFormTestPage.openPage()
                .setFirstName("Deez")
                .setLastName("Nuts")
                .setEmail("scoobydoo@mail.ru")
                .setGender("Other")
                .setUserNumber("8974590871")
                .setDateOfBirth("17", "July", "1913")
                .setSubjects("Biology");

        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("cat.webp");
        $("#currentAddress").setValue("USA, CA, Beverly Hills, 90210");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Deez"), text("Nuts"),
                text("scoobydoo@mail.ru"), text("8974590871"));

        automationPracticeFormTestPage.checkResult("Student Name", "Deez Nuts")
                .checkResult("Student Email", "scoobydoo@mail.ru");

    }
}
