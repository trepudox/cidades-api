package com.trepudox.cidadesapi.repository;

import com.trepudox.cidadesapi.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
    public List<Pais> findByNomePtContainingIgnoreCase(String nome);
}
