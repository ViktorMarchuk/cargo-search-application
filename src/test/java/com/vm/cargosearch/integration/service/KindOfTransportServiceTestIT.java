package com.vm.cargosearch.integration.service;

import com.vm.cargosearch.annotation.IT;
import com.vm.cargosearch.dto.KindOfTransportReadDto;
import com.vm.cargosearch.service.KindOfTransportService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IT
@RequiredArgsConstructor
public class KindOfTransportServiceTestIT {
//    private final KindOfTransportService kindOfTransportService;
//
//    @Test
//    void findAll() {
//        var transport = kindOfTransportService.findAll();
//        List<String> actualResult = transport.stream()
//                .map(KindOfTransportReadDto::name)
//                .collect(Collectors.toList());
//        assertNotNull(transport);
//        assertThat(actualResult).hasSize(4);
//    }
}
