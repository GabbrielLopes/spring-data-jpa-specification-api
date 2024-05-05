package com.gabbriellps.jpa.specification.api.service;

import com.gabbriellps.jpa.specification.api.dto.request.SearchRequestDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


public class DynamicSpecifications {

    public static <T> Specification<T> searchFilters(final List<SearchRequestDTO> filters) {
        return bySearchFilter(filters);
    }

    public static <T> Specification<T> bySearchFilter(final List<SearchRequestDTO> filters) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = filters.stream().map(filter -> {

                Path<T> columnName = buildColumnsEmbedded(filter, root);

                return buildPredicate(filter, criteriaBuilder, columnName);

            }).toList();

            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }

    private static <T> Path<T> buildColumnsEmbedded(SearchRequestDTO filter, Root<T> root) {
        // Delimita as colunas com "." para fazer buscar em Foreign Key ex: id.raizCnpj
        String[] columnNames = filter.getColumnName().split("\\.");

        Path expression = root.get(columnNames[0]);

        for (int i = 1; i < columnNames.length; i++) {
            expression = expression.get(columnNames[i]);
        }

        return expression;
    }

    private static Predicate buildPredicate(SearchRequestDTO filter, CriteriaBuilder builder, Path columnName) {
        // Monta o predicado de acordo com o filtro passado via parametro
        return switch (filter.getOperator()) {
            case IGUAL -> builder.equal(columnName, filter.getValue().toLowerCase());
            case MAIOR ->
                    builder.greaterThan(builder.lower(builder.toString(columnName)), (Comparable) filter.getValue().toLowerCase());
            case MENOR ->
                    builder.lessThan(builder.lower(builder.toString(columnName)), (Comparable) filter.getValue().toLowerCase());
            case MAIOR_IGUAL ->
                    builder.greaterThanOrEqualTo(builder.lower(builder.toString(columnName)), (Comparable) filter.getValue().toLowerCase());
            case MENOR_IGUAL ->
                    builder.lessThanOrEqualTo(builder.lower(builder.toString(columnName)), (Comparable) filter.getValue().toLowerCase());
            case DIFERENTE ->
                    builder.notEqual(builder.lower(builder.toString(columnName)), filter.getValue().toLowerCase());
            case CONTEM ->
                    builder.like(builder.lower(builder.toString(columnName)), "%" + filter.getValue().toLowerCase() + "%");
            case NAO_CONTEM ->
                    builder.notLike(builder.lower(builder.toString(columnName)), "%" + filter.getValue().toLowerCase() + "%");
            case NULO -> builder.isNull(builder.lower(builder.toString(columnName)));
            case NAO_NULO -> builder.isNotNull(builder.lower(builder.toString(columnName)));
        };
    }
}