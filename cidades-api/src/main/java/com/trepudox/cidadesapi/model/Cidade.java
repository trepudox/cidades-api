package com.trepudox.cidadesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cidade {

    @Id
    private Long id;

    private String nome;

    @ManyToOne
    @JsonIgnoreProperties({"cidades", "ddd"})
    @JoinColumn(name = "uf", referencedColumnName = "id")
    private Estado estado;

    private Integer ibge;

    @Column(name = "lat_lon")
    private String latLon;

    private Double latitude;

    private Double longitude;

    @Column(name = "cod_tom")
    private Short codTom;
}
