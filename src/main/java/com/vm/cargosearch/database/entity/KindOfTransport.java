package com.vm.cargosearch.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "cargo", name = "kind_of_transport")
@Data
public class KindOfTransport implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kind_transport", unique = true, nullable = false)
    private String name;
}
