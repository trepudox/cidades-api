package com.trepudox.cidadesapi.service;

import com.trepudox.cidadesapi.model.Pais;
import com.trepudox.cidadesapi.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    private PaisRepository repository;

    public Page<Pais> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public Optional<Pais> findById(Long id) {
        return repository.findById(id);
    }

    public List<Pais> findByNomePtContainingIgnoreCase(String nome) {
        return repository.findByNomePtContainingIgnoreCase(nome);
    }
}
