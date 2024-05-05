package com.gabbriellps.jpa.specification.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterRequestDTO {

    private List<SearchRequestDTO> searchRequestDTO;

}
