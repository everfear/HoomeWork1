package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AtPracticeFormPage {

    public AtPracticeFormPage openPage() {

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
            userForm = $("#userForm");

    CalendarComponent calendarComponent = new CalendarComponent();
    StateComponent stateComponent = new StateComponent();
    CityComponent cityComponent = new CityComponent();
    OutputTableComponent outputTableComponent = new OutputTableComponent();

    public AtPracticeFormPage setFirstName(String value) {

        firstNameInput.setValue(value);
        return this;

    }

    public AtPracticeFormPage setLastName(String value) {

        lastNameInput.setValue(value);
        return this;

    }

    public AtPracticeFormPage setEmail(String value) {

        userEmailInput.setValue(value);
        return this;

    }

    public AtPracticeFormPage setGender(String value) {

        genderInput.$(byText(value)).click();
        return this;

    }

    public AtPracticeFormPage setUserNumber(String value) {

        userNumberInput.setValue(value);
        return this;

    }

    public AtPracticeFormPage setDateOfBirth(String day, String month, String year) {

        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;

    }

    public AtPracticeFormPage setSubjects(String value) {

        subjectsInput.setValue(value).pressEnter();
        return this;

    }

    public AtPracticeFormPage setHobbies(String value) {

        hobbiesInput.$(byText(value)).click();
        return this;

    }

    public AtPracticeFormPage setPicture(String value) {

        setPicture.uploadFromClasspath(value);
        return this;

    }

    public AtPracticeFormPage setCurrentAddress(String value) {

        addressInput.setValue(value);
        return this;

    }

    public AtPracticeFormPage setState(String value) {

        stateComponent.setState(value);
        return this;

    }


    public AtPracticeFormPage setCity(String value) {

        cityComponent.setCity(value);
        return this;

    }

    public AtPracticeFormPage submit() {

        submitClick.scrollIntoView(true);
        submitClick.click();
        return this;

    }

    public AtPracticeFormPage checkResult(String key, String value) {

        outputTableComponent.checkResult(key, value);
        return this;

    }

    public AtPracticeFormPage checkValidation() {
        //NegativefillFormTestWithPageObject

        userForm.shouldHave(cssClass("was-validated"));
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;

    }
}