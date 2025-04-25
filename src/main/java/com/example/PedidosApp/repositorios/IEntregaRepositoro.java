package com.example.PedidosApp.repositorios;

import com.example.PedidosApp.modelos.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IEntregaRepositoro extends JpaRepository<Entrega,Integer> {
}
