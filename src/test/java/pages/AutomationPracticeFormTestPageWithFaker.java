package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AutomationPracticeFormTestPageWithFaker
{

    public AutomationPracticeFormTestPageWithFaker openPage()
    {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
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
            outputTable = $(".table-responsive"),
            userForm = $("#userForm");

    CalendarComponent calendarComponent = new CalendarComponent();
    StateComponent stateComponent = new StateComponent();
    CityComponent cityComponent = new CityComponent();

    public pages.AutomationPracticeFormTestPageWithFaker setFirstName(String value)
    {

        firstNameInput.setValue(value);
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker setLastName(String value)
    {

        lastNameInput.setValue(value);
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker setEmail(String value)
    {

        userEmailInput.setValue(value);
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker setGender(String value)
    {

        genderInput.$(byText(value)).click();
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker setUserNumber(String value)
    {

        userNumberInput.setValue(value);
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker setDateOfBirth(String day, String month, String year)
    {

        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker setSubjects(String value)
    {

        subjectsInput.setValue(value).pressEnter();
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker setHobbies(String value)
    {

        hobbiesInput.$(byText(value)).click();
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker setPicture(String value)
    {

        setPicture.uploadFromClasspath(value);
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker setCurrentAddress(String value)
    {

        addressInput.setValue(value);
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker setState(String value)
    {

        stateComponent.setState(value);
        return this;

    }


    public pages.AutomationPracticeFormTestPageWithFaker setCity(String value)
    {

        cityComponent.setCity(value);
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker submit()
    {

        submitClick.scrollIntoView(true);
        submitClick.click();
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker checkResult(String key, String value)
    {

        outputTable.$(byText(key)).parent().shouldHave(text(value));
        return this;

    }

    public pages.AutomationPracticeFormTestPageWithFaker checkValidation()
    {
        //NegativefillFormTestWithPageObject

        userForm.shouldHave(cssClass("was-validated"));
        firstNameInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
        lastNameInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
        userNumberInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
        outputTable.shouldNotBe(visible);
        return this;

    }
}