package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase
{

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest()
    {

                textBoxPage.openPage()

                .setUserName("Deez Nuts")
                .setEmail("scoobydoo@mail.ru")
                .setCurrentAddress("USA, CA, Beverly Hills, 90210")
                .setPermanentAddress("USA, CA, Beverly Hills, 90210")

                .submit()

                .checkResult("Name:", "Deez Nuts")
                .checkResult("Email:", "scoobydoo@mail.ru")
                .checkResult("Current Address :", "USA, CA, Beverly Hills, 90210")
                .checkResult("Permananet Address :", "USA, CA, Beverly Hills, 90210");

    }
}