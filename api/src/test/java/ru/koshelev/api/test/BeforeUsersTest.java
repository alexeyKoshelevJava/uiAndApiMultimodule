package ru.koshelev.api.test;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import ru.koshelev.api.ProjectConfig;

import java.util.Locale;


public class BeforeUsersTest {
    protected static Faker faker;
    @BeforeAll
    public static void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class);
        RestAssured.baseURI = config.baseUrl();
        faker=new Faker(Locale.forLanguageTag(config.locale()));


    }
}
