package com.example.PedidosApp.repositorios;

import com.example.PedidosApp.modelos.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITiendaRepositorio extends JpaRepository<Tienda,Integer> {
    Optional<Tienda> findByCorreoElectronico(String correoElectronico);
}
