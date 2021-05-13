package com.trepudox.cidadesapi.controller;

import com.trepudox.cidadesapi.model.Estado;
import com.trepudox.cidadesapi.repository.EstadoRepository;
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
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public ResponseEntity<Page<Estado>> getAllPageable(Pageable page) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getById(@PathVariable Long id) {
        Optional<Estado> e = repository.findById(id);

        return e.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(e.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
