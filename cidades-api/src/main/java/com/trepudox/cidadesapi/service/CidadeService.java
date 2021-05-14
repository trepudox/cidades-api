package com.trepudox.cidadesapi.service;

import com.trepudox.cidadesapi.model.Cidade;
import com.trepudox.cidadesapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public Page<Cidade> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public Optional<Cidade> findById(Long id) {
        return repository.findById(id);
    }

    public List<Cidade> findAllByNomeContainingIgnoreCase(String nome) {
        return repository.findAllByNomeContainingIgnoreCase(nome);
    }
}
