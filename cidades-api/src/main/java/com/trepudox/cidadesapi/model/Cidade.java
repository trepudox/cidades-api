package com.trepudox.cidadesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trepudox.cidadesapi.util.PointType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
@TypeDef(name = "point", typeClass = PointType.class)
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

    @Type(type = "point")
    @Column(name = "lat_lon")
    private Point latLon;

    private Double latitude;

    private Double longitude;

    @Column(name = "cod_tom")
    private Short codTom;
}
