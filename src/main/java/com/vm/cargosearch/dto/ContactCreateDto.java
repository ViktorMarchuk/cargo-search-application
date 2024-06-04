package com.vm.cargosearch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ContactCreateDto {
    private Integer id;
    private String companyName;
    private String address;
    private String email;
    private String telephone;
    private String contactName;
    private String password;
}
