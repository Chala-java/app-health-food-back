package com.example.PedidosApp.repositorios;

import com.example.PedidosApp.modelos.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IPagoRepositorio extends JpaRepository<Pago,Integer> {
}
