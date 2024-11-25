package org.paurus.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.paurus.jpa.CountryTaxRulesJpa;
import org.paurus.models.TaxationRequest;
import org.paurus.models.TaxationResponse;
import org.paurus.repository.CountryTaxRulesRepository;
import org.paurus.repository.TraderRepository;

@ApplicationScoped
public class TaxationService {

    @Inject
    TraderRepository traderRepository;

    @Inject
    CountryTaxRulesRepository countryTaxRulesRepository;

    @Transactional
    public TaxationResponse calculateGeneralTaxation(TaxationRequest taxationRequest) {
        CountryTaxRulesJpa taxRules = getCountryTaxRulesForTrader(taxationRequest.traderId());
        return calculateTaxation(taxationRequest, taxRules, false);
    }

    @Transactional
    public TaxationResponse calculateWinningsTaxation(TaxationRequest taxationRequest) {
        CountryTaxRulesJpa taxRules = getCountryTaxRulesForTrader(taxationRequest.traderId());
        return calculateTaxation(taxationRequest, taxRules, true);
    }

    private CountryTaxRulesJpa getCountryTaxRulesForTrader(Long traderId) {
        String location = traderRepository.findLocationByTraderId(traderId);
        return countryTaxRulesRepository.findByCountry(location);
    }

    private TaxationResponse calculateTaxation(
            TaxationRequest taxationRequest,
            CountryTaxRulesJpa taxRules,
            boolean isWinningsTaxation
    ) {
        double possibleReturnAmountBefTax = taxationRequest.playedAmount() * taxationRequest.odd();
        double taxableAmount = isWinningsTaxation
                ? possibleReturnAmountBefTax - taxationRequest.playedAmount() // Winnings
                : possibleReturnAmountBefTax;                                // General

        double taxAmount;

        if (taxRules.getTaxType() == CountryTaxRulesJpa.TaxType.RATE) {
            // Calculate tax based on the rate
            taxAmount = taxableAmount * (taxRules.getTaxRate() / 100);
        } else {
            // Cap the tax amount to the winnings for amount-based taxation
            taxAmount = Math.min(taxableAmount, taxRules.getTaxAmount());
        }

        Double possibleReturnAmountAfterTax = isWinningsTaxation
                ? taxationRequest.playedAmount() + (taxableAmount - taxAmount) // Subtract tax from winnings
                : possibleReturnAmountBefTax - taxAmount; // Subtract tax from total

        return new TaxationResponse(
                possibleReturnAmountAfterTax,
                possibleReturnAmountBefTax,
                possibleReturnAmountAfterTax,
                taxRules.getTaxRate(),
                taxAmount
        );
    }
}