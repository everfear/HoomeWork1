package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage
{

    public TextBoxPage openPage()
    {

        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    private SelenideElement

            userNameInput = $("#userName"),
            submitButton = $("#submit"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress");

    public TextBoxPage setUserName(String value)
    {

        userNameInput.setValue(value);
        return this;

    }

    public TextBoxPage setEmail(String value)
    {

        emailInput.setValue(value);
        return this;

    }

    public TextBoxPage setCurrentAddress(String value)
    {

        currentAddressInput.setValue(value);
        return this;

    }

    public TextBoxPage setPermanentAddress(String value)
    {

        permanentAddressInput.setValue(value);
        return this;

    }

    public TextBoxPage submit()
    {

        submitButton.scrollIntoView(true);
        submitButton.click();
        return this;

    }

    public TextBoxPage checkResult(String key, String value)
    {

        $("#output").$(byText(key)).parent().shouldHave(text(value));
        return this;

    }
}