package com.vm.cargosearch.dto;

public record ContactDetailsDto(Integer id,
                                String companyName,
                                String address,
                                String email,
                                String telephone,
                                String contactName) {
}
