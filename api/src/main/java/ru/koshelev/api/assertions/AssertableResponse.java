package ru.koshelev.api.assertions;


import io.qameta.allure.Step;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.koshelev.api.conditions.Condition;

@Slf4j
@RequiredArgsConstructor
public class AssertableResponse {
    private final Response response;

    @Step("api should have: {condition}")
    public AssertableResponse shouldHave(Condition condition) {
        log.info("About for check condition {}", condition);
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass) {
        return response.as(tClass);
    }

    public Headers headers() {
        return response.getHeaders();
    }
}