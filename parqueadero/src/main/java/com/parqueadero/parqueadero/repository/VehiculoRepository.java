package com.parqueadero.parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parqueadero.parqueadero.model.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}