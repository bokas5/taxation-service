package org.paurus.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.paurus.jpa.TraderJpa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TraderRepository implements PanacheRepository<TraderJpa> {

    public String findLocationByTraderId(Long traderId) {
        TraderJpa trader = findById(traderId);
        if (trader == null) {
            throw new IllegalArgumentException("Trader not found with ID: " + traderId);
        }
        return trader.getLocation();
    }
}
