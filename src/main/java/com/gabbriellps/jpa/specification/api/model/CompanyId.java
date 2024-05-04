package com.gabbriellps.jpa.specification.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class CompanyId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "RAIZ_CNPJ", length = 8, nullable = false)
    private Integer raizCnpj;

    @Column(name = "SUFIXO_CNPJ", length = 4, nullable = false)
    private String sufixoCnpj;

    @Column(name = "DIGITO_CNPJ", length = 2, nullable = false)
    private Integer digitoCnpj;

}
