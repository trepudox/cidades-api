package com.trepudox.cidadesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estado")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Getter @Setter @NoArgsConstructor
public class Estado {

    @Id
    private Long id;

    private String nome;

    private String uf;

    private Integer ibge;

    @ManyToOne
    @JsonIgnoreProperties({"estados", "id", "nome"})
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Pais pais;

    @OneToMany(mappedBy = "estado")
    @JsonIgnoreProperties({"estado", "lat_lon", "latitude", "longitude"})
    private List<Cidade> cidades;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<Integer> ddd;

}
