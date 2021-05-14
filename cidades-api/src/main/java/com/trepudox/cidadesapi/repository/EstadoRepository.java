package com.trepudox.cidadesapi.repository;

import com.trepudox.cidadesapi.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    public List<Estado> findByNomeContainingIgnoreCase(String nome);
}
