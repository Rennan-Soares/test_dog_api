package com.dogapi.tests;

import com.dogapi.specs.RequestSpecs;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class DogApiTest {

    @Test
    @DisplayName("Deve listar todas as raças com sucesso e validar estrutura")
    public void deveListarTodasAsRacas() {
        given()
            .spec(RequestSpecs.getBaseSpec())
        .when()
            .get("/breeds/list/all")
        .then()
            .statusCode(200)
            .body("status", is("success"))
            .body("message", notNullValue())
            .body("message", hasKey("pitbull"));
    }

    @Test
    @DisplayName("Deve retornar imagens de uma raça específica com sucesso")
    public void deveRetornarImagensDeUmaRaca() {
        String raca = "hound";
        
        given()
            .spec(RequestSpecs.getBaseSpec())
            .pathParam("breed", raca)
        .when()
            .get("/breed/{breed}/images")
        .then()
            .statusCode(200)
            .body("status", is("success"))
            .body("message", not(empty()))
            // ALTERAÇÃO AQUI: Garante que a URL da imagem contenha a pasta da raça informada
            .body("message[0]", containsString("/breeds/" + raca)); 
    }

    @Test
    @DisplayName("Deve retornar erro 404 ao buscar imagens de uma raça inexistente")
    public void deveRetornarErroParaRacaInexistente() {
        given()
            .spec(RequestSpecs.getBaseSpec())
            .pathParam("breed", "gato_nao_e_cao")
        .when()
            .get("/breed/{breed}/images")
        .then()
            .statusCode(404)
            .body("status", is("error"))
            .body("message", containsString("Breed not found"));
    }

    @Test
    @DisplayName("Deve retornar uma imagem aleatória com formato de URL válido")
    public void deveRetornarUmaImagemAleatoria() {
        given()
            .spec(RequestSpecs.getBaseSpec())
        .when()
            .get("/breeds/image/random")
        .then()
            .statusCode(200)
            .body("status", is("success"))
            // Expressão regular simples para validar se o campo message contém um link de imagem
            .body("message", matchesPattern("^https://.*\\.(jpg|jpeg|png)$"));
    }
}