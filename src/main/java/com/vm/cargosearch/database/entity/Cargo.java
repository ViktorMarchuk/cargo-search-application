package com.vm.cargosearch.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "cargo", name = "loading")
@Data
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loading_date")
    private LocalDate loadDate;

    @ManyToMany
    @JoinTable(
            name = "cargo_load_country",
            joinColumns = @JoinColumn(name = "cargo_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private Set<Country> loadCountry;

    @ManyToMany
    @JoinTable(
            name = "cargo_load_city",
            joinColumns = @JoinColumn(name = "cargo_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private Set<City> loadCity;

    @ManyToMany
    @JoinTable(
            name = "cargo_unload_country",
            joinColumns = @JoinColumn(name = "cargo_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private Set<Country> unloadCountry;

    @ManyToMany
    @JoinTable(
            name = "cargo_unload_city",
            joinColumns = @JoinColumn(name = "cargo_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private Set<City> unloadCity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "kind_of_transport_id")
    private Set<KindOfTransport> list;

    @Column(name = "name_of_load")
    private String loadName;

    @Column(name = "price")
    private int price;
}
