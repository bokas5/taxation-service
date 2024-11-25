package org.paurus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TaxationResourceTest {

    @Test
    public void testGeneralTaxRateGermany() {
        // Given: Germany uses rate-based taxation (10%)
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("""
                      {
                          "traderId": 1,
                          "playedAmount": 7.5,
                          "odd": 1.0
                      }
                      """)
                .when()
                .post("/taxation/general")
                .then()
                .statusCode(200)
                .body("possibleReturnAmount", equalTo(6.75f))
                .body("possibleReturnAmountBefTax", equalTo(7.5f))
                .body("possibleReturnAmountAfterTax", equalTo(6.75f))
                .body("taxRate", equalTo(10.0f))
                .body("taxAmount", equalTo(0.75f));
    }

    @Test
    public void testGeneralTaxAmountFrance() {
        // Given: France uses amount-based taxation (2 EUR)
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("""
                      {
                          "traderId": 2,
                          "playedAmount": 7.5,
                          "odd": 1.0
                      }
                      """)
                .when()
                .post("/taxation/general")
                .then()
                .statusCode(200)
                .body("possibleReturnAmount", equalTo(4.5f))
                .body("possibleReturnAmountBefTax", equalTo(7.5f))
                .body("possibleReturnAmountAfterTax", equalTo(4.5F))
                .body("taxRate", equalTo(0.0f))
                .body("taxAmount", equalTo(3.0f));
    }


    @Test
    public void testWinningsTaxRateGermany() {
        // Given: Germany uses rate-based taxation (10%)
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("""
                      {
                          "traderId": 1,
                          "playedAmount": 7.5,
                          "odd": 1.0
                      }
                      """)
                .when()
                .post("/taxation/winnings")
                .then()
                .statusCode(200)
                .body("possibleReturnAmount", equalTo(7.5f))
                .body("possibleReturnAmountBefTax", equalTo(7.5f))
                .body("possibleReturnAmountAfterTax", equalTo(7.5F))
                .body("taxRate", equalTo(10.0f))
                .body("taxAmount", equalTo(0.0f));
    }

    @Test
    public void testWinningsTaxAmountItaly() {
        // Given: Italy uses amount-based taxation (1 EUR)
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("""
                      {
                          "traderId": 4,
                          "playedAmount": 7.5,
                          "odd": 1.0
                      }
                      """)
                .when()
                .post("/taxation/winnings")
                .then()
                .statusCode(200)
                .body("possibleReturnAmount", equalTo(7.5F))
                .body("possibleReturnAmountBefTax", equalTo(7.5f))
                .body("possibleReturnAmountAfterTax", equalTo(7.5f))
                .body("taxRate", equalTo(0.0f))
                .body("taxAmount", equalTo(0.0f));
    }
}
