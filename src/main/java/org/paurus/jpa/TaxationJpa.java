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

}
