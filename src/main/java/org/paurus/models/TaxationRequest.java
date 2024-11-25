package org.paurus.models;

public record TaxationRequest(
        Long traderId,
        Double playedAmount,
        Double odd
) {

}
