package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormTestPage;

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
                .setSubjects("Biology")
                .setHobbies("Reading")
                .setPicture("cat.webp")
                .setCurrentAddress("USA, CA, Beverly Hills, 90210")
                .setState("Haryana")
                .setCity("Karnal")

                .submit()

                .checkResult("Student Name", "Deez Nuts")
                .checkResult("Student Email", "scoobydoo@mail.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8974590871")
                .checkResult("Date of Birth", "17 July,1913")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "cat.webp")
                .checkResult("Address", "USA, CA, Beverly Hills, 90210")
                .checkResult("State and City", "Haryana Karnal");

    }

    @Test
    void OnlyRequiredfillFormTestWithPageObject()
    {

                automationPracticeFormTestPage.openPage()

                .setFirstName("Deez")
                .setLastName("Nuts")
                .setGender("Other")
                .setUserNumber("8974590871")

                .submit()

                .checkResult("Student Name", "Deez Nuts")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8974590871");

    }

    @Test
    void EmptyfillFormTestWithPageObject()
    {

                automationPracticeFormTestPage.openPage()

                .submit()

                .checkValidation();

    }
}