package com.vm.cargosearch.service;

import com.vm.cargosearch.database.entity.KindOfTransport;
import com.vm.cargosearch.database.repository.KindOfTransportRepository;
import com.vm.cargosearch.dto.KindOfTransportReadDto;
import com.vm.cargosearch.mapper.KindOfTransportReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KindOfTransportService {
    private final KindOfTransportRepository kindOfTransportRepository;
    private final KindOfTransportReadMapper kindOfTransportReadMapper;

    public List<KindOfTransportReadDto> findAll() {
        return kindOfTransportRepository.findAll()
                .stream()
                .map(kindOfTransportReadMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<KindOfTransport> findById(Integer id) {
        return kindOfTransportRepository.findById(id);
    }
}
