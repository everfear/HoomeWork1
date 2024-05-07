package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.*;

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
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            setPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submitClick = $("#submit"),
            outputTable = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();
    StateComponent stateComponent = new StateComponent();
    CityComponent cityComponent = new CityComponent();

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

        genderInput.$(byText(value)).click();
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

    public AutomationPracticeFormTestPage setSubjects(String value)
    {

        subjectsInput.setValue(value).pressEnter();
        return this;

    }

    public AutomationPracticeFormTestPage setHobbies(String value)
    {

        hobbiesInput.$(byText(value)).click();
        return this;

    }

    public AutomationPracticeFormTestPage setPicture(String value)
    {

        setPicture.uploadFromClasspath(value);
        return this;

    }

    public AutomationPracticeFormTestPage setCurrentAddress(String value)
    {

        addressInput.setValue(value);
        return this;

    }

    public AutomationPracticeFormTestPage setState(String value)
    {

        stateComponent.setState(value);
        return this;

    }


    public AutomationPracticeFormTestPage setCity(String value)
    {

        cityComponent.setCity(value);
        return this;

    }

    public AutomationPracticeFormTestPage submit()
    {

        submitClick.scrollIntoView(true);
        submitClick.click();
        return this;

    }

    public AutomationPracticeFormTestPage checkResult(String key, String value)
    {

        outputTable.$(byText(key)).parent().shouldHave(text(value));
        return this;

    }
}
