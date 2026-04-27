package com.parqueadero.parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parqueadero.parqueadero.model.TipoVehiculo;

public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, Long> {
}