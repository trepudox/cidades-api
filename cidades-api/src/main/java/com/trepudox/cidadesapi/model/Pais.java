package com.trepudox.cidadesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pais")
@Getter @Setter @NoArgsConstructor
public class Pais {

    @Id
    private Long id;

    private String nome;

    @Column(name = "nome_pt")
    private String nomePt;

    private String sigla;

    private Integer bacen;

    @OneToMany(mappedBy = "pais")
    @JsonIgnoreProperties("pais")
    private List<Estado> estados;

}
