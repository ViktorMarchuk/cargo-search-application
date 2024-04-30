package com.vm.cargosearch.database.repository;

import com.vm.cargosearch.database.entity.Cargo;
import com.vm.cargosearch.dto.CargoFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FilterCargoRepositoryImpl implements FilterCargoRepository {
    private final EntityManager entityManager;


    @Override
    public List<Cargo> findAllByFilter(CargoFilter filter) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteria = criteriaBuilder.createQuery(Cargo.class);
        var cargo = criteria.from(Cargo.class);
        criteria.select(cargo);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.loadDateFrom() != null && filter.loadDate() != null) {
            predicates.add(criteriaBuilder.between(cargo.get("loadDate"), filter.loadDateFrom(), filter.loadDate()));
        } else if (filter.loadDateFrom() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(cargo.get("loadDate"), filter.loadDateFrom()));
        } else if (filter.loadDate() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(cargo.get("loadDate"), filter.loadDate()));
        }
        if (filter.countryLoad() != null && filter.countryLoad().name() != null && !filter.countryLoad().name().isBlank()) {
            String countryNameLowerCase = filter.countryLoad().name().toLowerCase();
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(cargo.get("countryLoad").get("name")), "%" + countryNameLowerCase + "%"));
        }
        if (filter.countryUnload() != null && filter.countryUnload().name() != null && !filter.countryUnload().name().isBlank()) {
            String countryNameLowerCase = filter.countryUnload().name().toLowerCase();
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(cargo.get("countryUnload").get("name")), "%" + countryNameLowerCase + "%"));
        }
        if (filter.kindOfTransport() != null && filter.kindOfTransport().name() != null && !filter.kindOfTransport().name().isBlank()) {
            String kindOfTransportNameLowerCase = filter.kindOfTransport().name().toLowerCase();
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(cargo.get("kindOfTransport").get("name")), "%" + kindOfTransportNameLowerCase + "%"));
        }
        criteria.where(predicates.toArray(Predicate[]::new));
        return entityManager.createQuery(criteria).getResultList();
    }
}
