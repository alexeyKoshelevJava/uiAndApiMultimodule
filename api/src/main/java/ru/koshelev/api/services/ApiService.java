package ru.koshelev.api.services;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import ru.koshelev.api.ProjectConfig;



import java.util.List;

public class ApiService {

    protected RequestSpecification setUp() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .filters(getFilters());
    }

    private List<Filter> getFilters() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class,System.getProperties());
//        boolean enable = Boolean.valueOf(System.getProperty("logging", "true"));
//        if (enable) {
        if(config.logging()){
            return List.of(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }
        return List.of();
    }
}
