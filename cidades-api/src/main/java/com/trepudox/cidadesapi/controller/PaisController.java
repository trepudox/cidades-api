package com.trepudox.cidadesapi.controller;

import com.trepudox.cidadesapi.model.Pais;
import com.trepudox.cidadesapi.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisService service;

    @GetMapping
    public ResponseEntity<Page<Pais>> getAllPageable(Pageable page) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getById(@PathVariable Long id) {
        Optional<Pais> p = service.findById(id);

        return p.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(p.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/containing")
    public ResponseEntity<List<Pais>> getByNomeContaining(@RequestParam(name = "nome") String nome) {
        List<Pais> lista = service.findByNomePtContainingIgnoreCase(nome);

        if (lista.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

}
