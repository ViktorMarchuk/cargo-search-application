package com.vm.cargosearch.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "cargo", name = "loading")
@Data
public class Cargo implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loading_date")
    private LocalDate loadDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_load_id", nullable = false)
    private Country countryLoad;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_name_load_id", nullable = false)
    private City cityLoad;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_unload_id", nullable = false)
    private Country countryUnload;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_name_unload_id", nullable = false)
    private City cityUnload;

    @ManyToOne
    @JoinColumn(name = "kind_of_transport_id", nullable = false)
    private KindOfTransport kindOfTransport;

    @Column(name = "name_of_load")
    private String nameOfLoad;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;
}
