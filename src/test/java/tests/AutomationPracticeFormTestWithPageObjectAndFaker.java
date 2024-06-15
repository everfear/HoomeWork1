package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormTestWithFakerPage;

import static io.qameta.allure.Allure.step;


public class AutomationPracticeFormTestWithPageObjectAndFaker extends TestBase {

    AutomationPracticeFormTestWithFakerPage automationPracticeFormTestPage = new AutomationPracticeFormTestWithFakerPage();

    @Test
    @DisplayName("Регистрация с заполнением всех полей")
    void fillFormTestWithPageObject() {

        step("Открываем страничку регистрации", () -> {

            automationPracticeFormTestPage.openPage();

        });

        step("Заполняем все поля и кликаем submit", () -> {

            automationPracticeFormTestPage.setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setGender(data.gender)
                    .setUserNumber(data.userNumber)
                    .setDateOfBirth(data.userBirthDay, data.userBirthMonth, data.userBirthYear)
                    .setSubjects(data.subjects)
                    .setHobbies(data.hobbies)
                    .setPicture(data.picture)
                    .setCurrentAddress(data.currentAddress)
                    .setState(data.state)
                    .setCity(data.city)
                    .submit();

        });

        step("Проверяем результат", () -> {

            automationPracticeFormTestPage.checkResult("Student Name", data.firstName + " " + data.lastName)
                    .checkResult("Student Email", data.email)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.userNumber)
                    .checkResult("Date of Birth", data.userBirthDay + " " + data.userBirthMonth + "," + data.userBirthYear)
                    .checkResult("Subjects", data.subjects)
                    .checkResult("Hobbies", data.hobbies)
                    .checkResult("Picture", data.picture)
                    .checkResult("Address", data.currentAddress)
                    .checkResult("State and City", data.state + " " + data.city);

        });

    }

    @Test
    @DisplayName("Регистрация с заполнением только обязательных полей")
    void onlyRequiredfillFormTestWithPageObject() {

        step("Открываем страничку регистрации", () -> {

            automationPracticeFormTestPage.openPage();

        });

        step("Заполняем только обязательные поля", () -> {

            automationPracticeFormTestPage.setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setGender(data.gender)
                    .setUserNumber(data.userNumber)
                    .submit();

        });

        step("Проверяем результат", () -> {

            automationPracticeFormTestPage.checkResult("Student Name", data.firstName + " " + data.lastName)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.userNumber);

        });

    }

    @Test
    @DisplayName("Неуспешная регистрация, обязательные поля пустые")
    void negativefillFormTestWithPageObject() {

        step("Открываем страничку регистрации", () -> {

            automationPracticeFormTestPage.openPage();

        });

        step("Ничего не заполняем, сразу кликаем submit", () -> {

            automationPracticeFormTestPage.submit();

        });

        step("Проверяем результат", () -> {

            automationPracticeFormTestPage.checkValidation();

        });
    }
}