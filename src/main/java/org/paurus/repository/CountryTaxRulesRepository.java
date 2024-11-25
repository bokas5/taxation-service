package org.paurus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.paurus.jpa.CountryTaxRulesJpa;

@ApplicationScoped
public class CountryTaxRulesRepository implements PanacheRepository<CountryTaxRulesJpa> {
    public CountryTaxRulesJpa findByCountry(String country) {
        return find("country", country).firstResult();
    }
}
