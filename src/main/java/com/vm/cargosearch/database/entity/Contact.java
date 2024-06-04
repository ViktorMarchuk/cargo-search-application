package com.vm.cargosearch.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "cargo", name = "contact")
@Data
public class Contact implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name", unique = true, nullable = false)
    private String companyName;

    @Column(name = "address", unique = true, nullable = false)
    private String address;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "telephone", unique = true, nullable = false)
    private String telephone;

    @Column(name = "contact_name", unique = true, nullable = false)
    private String contactName;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

}
