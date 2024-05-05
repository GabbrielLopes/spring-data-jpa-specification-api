package com.gabbriellps.jpa.specification.api.controller;

import com.gabbriellps.jpa.specification.api.model.Company;
import com.gabbriellps.jpa.specification.api.service.interfaces.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/")
public class CompanyController {

    private final transient CompanyService companyService;


    @GetMapping("/company/specification/nome/{nomeEmpresa}")
    public ResponseEntity<List<Company>> findCompanyByNameSpecification(
            @PathVariable(value = "nomeEmpresa") String nomeEmpresa) {

        return ResponseEntity.status(HttpStatus.OK).body(companyService.findByRaizCnpj(nomeEmpresa));
    }

    @GetMapping("/company/specification/raizCnpj/{raizCnpj}")
    public ResponseEntity<List<Company>> findCompanyLikeRaizCnpj(
            @PathVariable(value = "raizCnpj") Integer raizCnpj) {

        return ResponseEntity.status(HttpStatus.OK).body(companyService.findCompanyLikeRaizCnpj(raizCnpj));
    }
    

}
