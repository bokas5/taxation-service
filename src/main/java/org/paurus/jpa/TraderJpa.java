package org.paurus.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trader")
public class TraderJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long traderId;

    private String name;
    private String location; // Country name or code

    public String getLocation() {
        return location;
    }

}