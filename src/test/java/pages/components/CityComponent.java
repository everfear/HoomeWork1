package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CityComponent
{

    public void setCity(String value)
    {

        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();

    }
}
