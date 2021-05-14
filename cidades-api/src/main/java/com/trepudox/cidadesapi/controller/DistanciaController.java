package com.trepudox.cidadesapi.controller;

import com.trepudox.cidadesapi.service.DistanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distancia")
public class DistanciaController {

    @Autowired
    private DistanciaService service;

    @GetMapping
    public ResponseEntity<String> distanciaEntre(@RequestParam(name = "from") Long idCidade1,
                                         @RequestParam(name = "to") Long idCidade2) {
//         log.info("byCube");
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.distanciaEntre(idCidade1, idCidade2));
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
