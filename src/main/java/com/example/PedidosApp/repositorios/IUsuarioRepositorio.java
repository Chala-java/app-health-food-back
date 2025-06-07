package com.example.PedidosApp.repositorios;

import com.example.PedidosApp.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer>{
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);

    //Dentro del repo van las consultas personalizadas

}
