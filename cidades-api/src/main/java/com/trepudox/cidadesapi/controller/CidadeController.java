package com.trepudox.cidadesapi.controller;

import com.trepudox.cidadesapi.model.Cidade;
import com.trepudox.cidadesapi.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping
    public ResponseEntity<Page<Cidade>> getAllPageable(Pageable page) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getById(@PathVariable Long id) {
        Optional<Cidade> c = service.findById(id);

        return c.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(c.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/containing")
    public ResponseEntity<List<Cidade>> getAllByNomeContainingIgnoreCase(@RequestParam(name = "nome") String nome) {
        List<Cidade> lista = service.findAllByNomeContainingIgnoreCase(nome);

        if (lista.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
}
