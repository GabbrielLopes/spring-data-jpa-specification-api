package com.gabbriellps.jpa.specification.api.service.interfaces;

import com.gabbriellps.jpa.specification.api.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findByRaizCnpj(String nomeEmpresa);

    List<Company> findCompanyLikeRaizCnpj(Integer raizCnpj);

}
