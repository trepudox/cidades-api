package com.trepudox.cidadesapi.controller;

import com.trepudox.cidadesapi.model.Cidade;
import com.trepudox.cidadesapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;

    @GetMapping
    public ResponseEntity<Page<Cidade>> getAllPageable(Pageable page) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getById(@PathVariable Long id) {
        Optional<Cidade> c = repository.findById(id);

        return c.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(c.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
