package data;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData
{

    Faker faker = new Faker(new Locale("fr"));

    public String

            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            userBirthDay = String.format("%02d", faker.number().numberBetween(1, 28)),
            userBirthMonth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            userBirthYear = String.format("%s",faker.number().numberBetween(2000,2200)),
            subjects = faker.options().option("Accounting", "Art", "Physics", "Economics", "English", "Biology"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = faker.options().option("cat.webp", "cat2.webp"),
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getRandomCity();

    public String getRandomCity()
    {

        if (state.equals("NCR")) city = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh")) city = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana")) city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan")) city = faker.options().option("Jaipur", "Jaiselmer");
        return city;

    }
}