package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsComponent
{

    public void setSubject(String value)
    {

        $("#subjectsInput").sendKeys("Biology");
        $("#subjectsInput").pressEnter();

    }
}
