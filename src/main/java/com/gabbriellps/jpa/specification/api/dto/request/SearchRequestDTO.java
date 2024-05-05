package com.gabbriellps.jpa.specification.api.dto.request;

import com.gabbriellps.jpa.specification.api.enumeration.Operador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchRequestDTO {

    private String columnName;
    private String value;
    private Operador operator;

}
