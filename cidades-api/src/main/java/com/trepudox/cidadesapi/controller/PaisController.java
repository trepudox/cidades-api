package com.trepudox.cidadesapi.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trepudox.cidadesapi.model.Pais;
import com.trepudox.cidadesapi.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @GetMapping
    public ResponseEntity<Page<Pais>> getAllPageable(Pageable page) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getById(@PathVariable Long id) {
        Optional<Pais> p = repository.findById(id);

        return p.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(p.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
