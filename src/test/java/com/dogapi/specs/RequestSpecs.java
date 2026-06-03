package com.dogapi.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.qameta.allure.restassured.AllureRestAssured;

public class RequestSpecs {
    public static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://dog.ceo/api")
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured()) // Loga as requisições no relatório Allure
                .log(LogDetail.ALL)
                .build();
    }
}