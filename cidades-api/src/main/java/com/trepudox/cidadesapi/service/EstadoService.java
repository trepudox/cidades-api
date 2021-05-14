package com.trepudox.cidadesapi.service;

import com.trepudox.cidadesapi.model.Estado;
import com.trepudox.cidadesapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    public Page<Estado> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public Optional<Estado> findById(Long id) {
        return repository.findById(id);
    }

    public List<Estado> findByNomeContainingIgnoreCase(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

}
