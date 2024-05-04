package com.gabbriellps.jpa.specification.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "COMPANY")
public class Company {

    @EmbeddedId
    private CompanyId id;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nomeGuerra;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "TELEFONE", length = 11)
    private String telefone;

    @CreatedBy
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

}
