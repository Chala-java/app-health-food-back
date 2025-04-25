package com.example.PedidosApp.repositorios;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.example.PedidosApp.modelos.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IDetalleRepositorio extends JpaRepository<Detalle, Integer> {
}
