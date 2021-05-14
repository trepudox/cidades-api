package com.trepudox.cidadesapi.controller;

import com.trepudox.cidadesapi.model.Estado;
import com.trepudox.cidadesapi.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService service;

    @GetMapping
    public ResponseEntity<Page<Estado>> getAllPageable(Pageable page) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getById(@PathVariable Long id) {
        Optional<Estado> e = service.findById(id);

        return e.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(e.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/containing")
    public ResponseEntity<List<Estado>> findByNomeContainingIgnoreCase(@RequestParam(name = "nome") String nome) {
        List<Estado> lista = service.findByNomeContainingIgnoreCase(nome);

        if(lista.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

}
