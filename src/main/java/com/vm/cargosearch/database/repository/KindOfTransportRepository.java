package com.vm.cargosearch.database.repository;

import com.vm.cargosearch.database.entity.KindOfTransport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KindOfTransportRepository extends JpaRepository<KindOfTransport, Integer> {
    @Override
    Optional<KindOfTransport> findById(Integer integer);
}
