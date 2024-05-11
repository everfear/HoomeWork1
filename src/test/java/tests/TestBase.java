package tests;

import com.codeborne.selenide.Configuration;
import data.TestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase
{

    @BeforeAll
    static void beforeAll()
    {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    TestData data;
    @BeforeEach
    void testDataGeneration()
    {

        data = new TestData();

    }
}