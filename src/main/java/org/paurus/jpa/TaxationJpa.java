package org.paurus.jpa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "taxation")
public class TaxationJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long traderId;
    private Double playedAmount;
    private Double odd;
    private Double possibleReturnAmount;
    private Double possibleReturnAmountBefTax;
    private Double possibleReturnAmountAfterTax;
    private Double taxRate;
    private Double taxAmount;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTraderId(Long traderId) {
        this.traderId = traderId;
    }

    public void setPlayedAmount(Double playedAmount) {
        this.playedAmount = playedAmount;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }

    public void setPossibleReturnAmount(Double possibleReturnAmount) {
        this.possibleReturnAmount = possibleReturnAmount;
    }

    public void setPossibleReturnAmountBefTax(Double possibleReturnAmountBefTax) {
        this.possibleReturnAmountBefTax = possibleReturnAmountBefTax;
    }

    public void setPossibleReturnAmountAfterTax(Double possibleReturnAmountAfterTax) {
        this.possibleReturnAmountAfterTax = possibleReturnAmountAfterTax;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }
}
