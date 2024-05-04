package com.gabbriellps.jpa.specification.api.dto.response;

import com.gabbriellps.jpa.specification.api.util.Util;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyResponseDTO {

    private Integer raizCnpj;
    private String sufixoCnpj;
    private Integer digitoCnpj;
    private String nome;
    private String endereco;
    private String telefone;

    public String getCnpjFormatado() {
        return Util.formataCnpj(raizCnpj, sufixoCnpj, digitoCnpj);
    }
}
