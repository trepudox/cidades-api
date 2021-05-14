package com.trepudox.cidadesapi.repository;

import com.trepudox.cidadesapi.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    public List<Cidade> findAllByNomeContainingIgnoreCase(String nome);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1, ?2), ll_to_earth(?3, ?4))", nativeQuery = true)
    public Double distanciaEntre(Double lat1, Double lon1, Double lat2, Double lon2);
}
