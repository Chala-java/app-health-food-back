package com.example.PedidosApp.repositorios;

import com.example.PedidosApp.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepositorio extends JpaRepository<Producto,Integer> {
}
