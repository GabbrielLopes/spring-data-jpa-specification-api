package com.gabbriellps.jpa.specification.api.repository;

import com.gabbriellps.jpa.specification.api.model.Company;
import com.gabbriellps.jpa.specification.api.model.CompanyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, CompanyId>, JpaSpecificationExecutor<Company> {


}
