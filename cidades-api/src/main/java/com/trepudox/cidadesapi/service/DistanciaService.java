package com.trepudox.cidadesapi.service;

import com.trepudox.cidadesapi.model.Cidade;
import com.trepudox.cidadesapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistanciaService {

    @Autowired
    private CidadeRepository repository;

    public String distanciaEntre(Long idCidade1, Long idCidade2) {
        Optional<Cidade> cidade1 = repository.findById(idCidade1);
        Optional<Cidade> cidade2 = repository.findById(idCidade2);

        if(!cidade1.isPresent())
            throw new NullPointerException("O ID informado da cidade 1 não existe!");
        if(!cidade2.isPresent())
            throw new NullPointerException("O ID informado da cidade 2 não existe!");

        Point p1 = cidade1.get().getLatLon();
        Point p2 = cidade2.get().getLatLon();

        // o Cube retorna a distância em metros
        Double distanciaEmKm = repository.distanciaEntre(p1.getX(), p1.getY(), p2.getX(), p2.getY()) / 1000;
        return String.format("A distância entre %s e %s é de cerca de %.2f km", cidade1.get().getNome(),
                cidade2.get().getNome(), distanciaEmKm);
    }

}
