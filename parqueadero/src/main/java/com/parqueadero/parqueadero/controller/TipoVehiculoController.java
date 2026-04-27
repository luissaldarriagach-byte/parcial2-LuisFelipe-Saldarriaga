package com.parqueadero.parqueadero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parqueadero.parqueadero.model.TipoVehiculo;
import com.parqueadero.parqueadero.repository.TipoVehiculoRepository;

@RestController
@RequestMapping("/tipos")
public class TipoVehiculoController {

    @Autowired
    private TipoVehiculoRepository repo;

    @GetMapping
    public List<TipoVehiculo> listar() {
        return repo.findAll();
    }

    @PostMapping
    public TipoVehiculo crear(@RequestBody TipoVehiculo t) {
        return repo.save(t);
    }
}