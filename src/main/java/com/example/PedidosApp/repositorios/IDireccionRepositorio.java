package com.example.PedidosApp.repositorios;

import com.example.PedidosApp.modelos.Direccion;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IDireccionRepositorio extends JpaRepository<Direccion,Integer> {
}
