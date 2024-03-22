package com.vm.cargosearch.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "cargo", name = "city")
@Data
public class City {
    @Id
    private int id;

    @Column(name = "name_city")
    private String nameCity;

    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToMany
    private Set<Cargo> cargoList;
}
