package org.paurus.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country_tax_rules")
public class CountryTaxRulesJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private double taxRate;
    private double taxAmount;

    @Enumerated(EnumType.STRING)
    private TaxType taxType;

    public enum TaxType {
        RATE, AMOUNT
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public TaxType getTaxType() {
        return taxType;
    }

}