package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.SubjectsComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AutomationPracticeFormTestPage
{

    public AutomationPracticeFormTestPage openPage()
    {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsContainer");

    CalendarComponent calendarComponent = new CalendarComponent();
    SubjectsComponent subjectsComponent = new SubjectsComponent();

    public AutomationPracticeFormTestPage setFirstName(String value)
    {

        firstNameInput.setValue(value);
        return this;

    }

    public AutomationPracticeFormTestPage setLastName(String value)
    {

        lastNameInput.setValue(value);
        return this;

    }

    public AutomationPracticeFormTestPage setEmail(String value)
    {

        userEmailInput.setValue(value);
        return this;

    }

    public AutomationPracticeFormTestPage setGender(String value)
    {

        genderWrapper.$(byText(value)).click();
        return this;

    }

    public AutomationPracticeFormTestPage setUserNumber(String value)
    {

        userNumberInput.setValue(value);
        return this;

    }

    public AutomationPracticeFormTestPage setDateOfBirth(String day, String month, String year)
    {

        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;

    }

    public AutomationPracticeFormTestPage setSubjects(String subjectOption)
    {

        subjectsInput.click();
        subjectsComponent.setSubject(subjectOption);
        return this;

    }

    public AutomationPracticeFormTestPage checkResult(String key, String value)
    {

        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;

    }
}
