package com.gabbriellps.jpa.specification.api.service.interfaces;

import com.gabbriellps.jpa.specification.api.dto.request.FilterRequestDTO;
import com.gabbriellps.jpa.specification.api.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    List<Company> findByRaizCnpj(String nomeEmpresa);

    List<Company> findCompanyLikeRaizCnpj(Integer raizCnpj);

    List<Company> findCompanyDynamicSpecification(FilterRequestDTO requestDTO);

    Page<Company> findCompanyDynamicSpecificationPaginado(FilterRequestDTO requestDTO, Pageable pageable);

}
