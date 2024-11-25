package org.paurus.models;

public record TaxationResponse(
        Double possibleReturnAmount,
        Double possibleReturnAmountBefTax,
        Double possibleReturnAmountAfterTax,
        Double taxRate,
        Double taxAmount
) {

}
