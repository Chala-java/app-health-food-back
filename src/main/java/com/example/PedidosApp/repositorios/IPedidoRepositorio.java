package com.example.PedidosApp.repositorios;

import com.example.PedidosApp.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IPedidoRepositorio extends JpaRepository<Pedido,Integer> {
}
