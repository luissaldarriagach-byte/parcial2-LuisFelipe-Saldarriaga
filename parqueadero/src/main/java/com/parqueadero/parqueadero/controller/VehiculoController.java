package com.parqueadero.parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.parqueadero.parqueadero.model.Vehiculo;
import com.parqueadero.parqueadero.repository.VehiculoRepository;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
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