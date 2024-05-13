package com.gabbriellps.jpa.specification.api.controller;

import com.gabbriellps.jpa.specification.api.dto.request.FilterRequestDTO;
import com.gabbriellps.jpa.specification.api.model.Company;
import com.gabbriellps.jpa.specification.api.service.interfaces.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/company/specification")
    public ResponseEntity<List<Company>> findCompanyDynamicSpecification(
            @RequestBody FilterRequestDTO requestDTO) {
        // Nesse modelo de query abrimos uma exceção para fazer consultas com request method Post e Request Body
        // para passar os parametros da query dinamica
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findCompanyDynamicSpecification(requestDTO));
    }

    @PostMapping("/company/specification/page")
    public ResponseEntity<Page<Company>> findCompanyDynamicSpecificationPagination(
            @RequestBody FilterRequestDTO requestDTO,
            @PageableDefault(page = 0, size = 5) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(companyService.findCompanyDynamicSpecificationPaginado(requestDTO, pageable));
    }


}
