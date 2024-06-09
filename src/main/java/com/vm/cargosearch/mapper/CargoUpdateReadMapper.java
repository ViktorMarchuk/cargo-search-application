package com.vm.cargosearch.mapper;

import com.vm.cargosearch.database.entity.Cargo;
import com.vm.cargosearch.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CargoUpdateReadMapper implements Mapper<Cargo, CargoUpdateReadDto> {
    private final CityReadMapper cityReadMapper;
    private final CountryReadMapper countryReadMapper;
    private final KindOfTransportReadMapper kindOfTransportReadMapper;
    private final ContactReadMapper contactReadMapper;

    @Override
    public CargoUpdateReadDto map(Cargo object) {
        CountryReadDto countryLoad = Optional.ofNullable(object.getCountryLoad())
                .map(countryReadMapper::map)
                .orElse(null);
        CityReadDto cityLoad = Optional.ofNullable(object.getCityLoad())
                .map(cityReadMapper::map)
                .orElse(null);
        CountryReadDto countryUnload = Optional.ofNullable(object.getCountryUnload())
                .map(countryReadMapper::map)
                .orElse(null);
        CityReadDto cityUnload = Optional.ofNullable(object.getCityUnload())
                .map(cityReadMapper::map)
                .orElse(null);
        KindOfTransportReadDto transport = Optional.ofNullable(object.getKindOfTransport())
                .map(kindOfTransportReadMapper::map)
                .orElse(null);
        Integer price = object.getPrice();
        Integer priceValue = 0;
        if (price == null) {
            price = priceValue;
        }
        return new CargoUpdateReadDto(object.getId(),
                object.getLoadDate(),
                countryLoad,
                cityLoad,
                countryUnload,
                cityUnload,
                transport,
                object.getNameOfLoad(),
                price
        );
    }
}

