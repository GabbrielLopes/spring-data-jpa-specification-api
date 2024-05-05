package com.gabbriellps.jpa.specification.api.service;

import com.gabbriellps.jpa.specification.api.model.Company;
import com.gabbriellps.jpa.specification.api.repository.CompanyRepository;
import com.gabbriellps.jpa.specification.api.service.interfaces.CompanyService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final transient CompanyRepository repository;

    @Override
    public List<Company> findByName(String nomeEmpresa) {
        Specification<Company> specification = new Specification<Company>() {

            @Override
            public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("nomeGuerra"), nomeEmpresa);
            }
        };

        return repository.findAll(specification);
    }
}
