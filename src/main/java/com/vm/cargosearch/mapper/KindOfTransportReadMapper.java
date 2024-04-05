package com.vm.cargosearch.mapper;

import com.vm.cargosearch.database.entity.KindOfTransport;
import com.vm.cargosearch.dto.KindOfTransportReadDto;
import org.springframework.stereotype.Component;
@Component
public class KindOfTransportReadMapper implements Mapper<KindOfTransport,KindOfTransportReadDto> {
    @Override
    public KindOfTransportReadDto map(KindOfTransport object) {
        return new KindOfTransportReadDto(object.getId(),object.getName());
    }
}
