package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormTestPageWithFaker;

public class AutomationPracticeFormTestWithPageObjectAndFaker extends TestBase
{

    AutomationPracticeFormTestPageWithFaker automationPracticeFormTestPage = new AutomationPracticeFormTestPageWithFaker();

    @Test
    void fillFormTestWithPageObject()
    {

                automationPracticeFormTestPage.openPage()

                .setFirstName(data.firstName)
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

                .submit()

                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber)
                .checkResult("Date of Birth", data.userBirthDay + " " + data.userBirthMonth + "," + data.userBirthYear)
                .checkResult("Subjects", data.subjects)
                .checkResult("Hobbies", data.hobbies)
                .checkResult("Picture", data.picture)
                .checkResult("Address", data.currentAddress)
                .checkResult("State and City", data.state + " " + data.city);

    }

    @Test
    void OnlyRequiredfillFormTestWithPageObject()
    {

        automationPracticeFormTestPage.openPage()

                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setUserNumber(data.userNumber)

                .submit()

                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber);

    }

    @Test
    void NegativefillFormTestWithPageObject()
    {

        automationPracticeFormTestPage.openPage()

                .submit()

                .checkValidation();

    }
}