package org.paurus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.paurus.jpa.TaxationJpa;

@ApplicationScoped
public class TaxationRepository implements PanacheRepository<TaxationJpa> {
}
