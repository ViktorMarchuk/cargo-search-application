package com.vm.cargosearch.dto;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Fill company name!")
    private String companyName;

    @NotBlank(message = "Fill address!")
    private String address;

    @NotBlank(message = "Fill email!")
    private String email;

    @NotBlank(message = "Fill telephone!")
    private String telephone;

    @NotBlank(message = "Fill contact name!")
    private String contactName;

    @NotBlank(message = "Fill the password!")
    private String password;
}
