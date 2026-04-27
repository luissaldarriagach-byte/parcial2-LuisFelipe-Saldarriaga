package com.parqueadero.parqueadero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parqueadero.parqueadero.model.Vehiculo;
import com.parqueadero.parqueadero.repository.VehiculoRepository;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoController {

    @Autowired
    private VehiculoRepository repo;

    @GetMapping
    public List<Vehiculo> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Vehiculo crear(@RequestBody Vehiculo v) {
        return repo.save(v);
    }
}