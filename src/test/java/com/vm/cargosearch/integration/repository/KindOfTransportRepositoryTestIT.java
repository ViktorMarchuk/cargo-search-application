package com.vm.cargosearch.integration.repository;

import com.vm.cargosearch.annotation.IT;
import com.vm.cargosearch.database.entity.KindOfTransport;
import com.vm.cargosearch.database.repository.KindOfTransportRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@IT
@RequiredArgsConstructor
public class KindOfTransportRepositoryTestIT {
    private final KindOfTransportRepository transportRepository;
    private final int TRANSPORT_ID = 2;

    @Test
    void findByIdTest() {
        var transport = transportRepository.findById(TRANSPORT_ID);
        Optional<Integer> actualResult = transport.stream().map(KindOfTransport::getId).findFirst();
        assertThat(actualResult.get()).isEqualTo(TRANSPORT_ID);
    }
}
