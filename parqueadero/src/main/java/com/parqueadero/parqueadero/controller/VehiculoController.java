package com.parqueadero.parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.parqueadero.parqueadero.model.Vehiculo;
import com.parqueadero.parqueadero.repository.VehiculoRepository;

import java.time.LocalDateTime;
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

   
    @PostMapping("/entrada")
    public Vehiculo entrada(@RequestBody Vehiculo v) {

        if (v.getPlaca().length() > 6) {
            throw new RuntimeException("La placa no puede tener más de 6 caracteres");
        }

        v.setHoraEntrada(LocalDateTime.now());
        return repo.save(v);
    }

   
    @PutMapping("/salida/{id}")
    public Vehiculo salida(@PathVariable Long id) {

    	Vehiculo v = repo.findById(id).orElseThrow();
    	v.getTipoVehiculo().getNombre();

        if (v.getHoraEntrada() == null) {
            throw new RuntimeException("El vehículo no tiene entrada registrada");
        }

        v.setHoraSalida(LocalDateTime.now());
        return repo.save(v);
    }

   
    @PutMapping("/ubicacion/{id}")
    public Vehiculo actualizarUbicacion(@PathVariable Long id, @RequestParam String ubicacion) {

        Vehiculo v = repo.findById(id).orElseThrow();
        v.setUbicacion(ubicacion);
        return repo.save(v);
    }
}