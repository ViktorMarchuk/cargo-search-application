package com.vm.cargosearch.dto;

public record ContactReadDto(
        Integer id,
        String companyName,
        String address,
        String email,
        String telephone,
        String contactName,
        String password) {
}
